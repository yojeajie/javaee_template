package cn.com.allunion.common.validation.bean.string;

import cn.com.allunion.common.validation.RegExpConstants;
import cn.com.allunion.common.validation.Validation;
import cn.com.allunion.common.validation.bean.AbstractValidationGroup;
import cn.com.allunion.common.validation.bean.BooleanValidation;

/**
 * 字符串验证类组合
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/27.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class StringValidationGroup extends AbstractValidationGroup {
    /**
     * 要验证的对象
     */
    protected String object ;

    public StringValidationGroup(String object) {
        this.object = object;
    }

    @Override
    public boolean validate() {
        if (validationList.size() > 0) {
            for (Validation v : validationList) {
                if (!v.validate()) {
                    return false ;
                }
            }
        }

        return true ;
    }

    /**
     * 验证条件 字符串为空验证
     * @return 字符串验证类组合对象
     */
    public StringValidationGroup empty() {
        validationList.add(new StringEmpty(object, errorTip));
        return getSelf() ;
    }

    /**
     * 字符串不为null并且不为空字符串验证
     * @return 字符串验证类组合对象
     */
    public StringValidationGroup notEmpty() {
        validationList.add(new StringNotEmpty(object, errorTip));
        return getSelf() ;
    }

    /**
     * 验证条件 字符串为null或者""或者"  "验证
     * <pre>
     * null     = true
     * ""       = true
     * " "      = true
     * "bob"    = false
     * "  bob  "= false
     * </pre>
     * @return 字符串验证类组合对象
     */
    public StringValidationGroup blank() {
        validationList.add(new StringBlank(object, errorTip));
        return getSelf() ;
    }

    /**
     * 字符串不为null并且不为空字符串并且字符不都为空格验证
     * <pre>
     * null     = false
     * ""       = false
     * " "      = false
     * "bob"    = true
     * "  bob  "= true
     * </pre>
     * @return 字符串验证类组合对象
     */
    public StringValidationGroup notBlank() {
        validationList.add(new StringNotBlank(object, errorTip));
        return getSelf() ;
    }

    /**
     * 字符串为数字(负数，小数)
     * @return 字符串验证类组合对象
     */
    public StringValidationGroup isNumber() {
        validationList.add(new StringIsNumber(object, errorTip));
        return getSelf() ;
    }

    /**
     * 字符串为整数字符串验证
     * @return 字符串验证类组合对象
     */
    public StringValidationGroup isDigits() {
        validationList.add(new StringIsDigits(object, errorTip));
        return getSelf() ;
    }

    /**
     * 字符串为邮箱字符串验证
     * @return 字符串验证类组合对象
     */
    public StringValidationGroup isEmail() {
        validationList.add(new StringMatchRegExp(object, RegExpConstants.REGEXP_EMAIL, errorTip));
        return getSelf() ;
    }

    /**
     * 字符串为中文字符串验证
     * @return 字符串验证类组合对象
     */
    public StringValidationGroup isChinese() {
        validationList.add(new StringMatchRegExp(object, RegExpConstants.REGEXP_CHINESE, errorTip));
        return getSelf() ;
    }

    /**
     * 字符串匹配正则表达式串验证
     * @param regExp 正则表达式字符串
     * @return 字符串验证类组合对象
     */
    public StringValidationGroup matchRegExp(String regExp) {
        validationList.add(new StringMatchRegExp(object, regExp, errorTip));
        return getSelf() ;
    }

    /**
     * 字符串最小长度验证
     * @param minLength 字符串最小长度
     * @return 字符串验证类组合对象
     */
    public StringValidationGroup minLength(int minLength) {
        validationList.add(new StringMinLength(object, minLength, errorTip));
        return getSelf() ;
    }

    /**
     * 字符串最大长度验证
     * @param maxLength 字符串最大长度
     * @return 字符串验证类组合对象
     */
    public StringValidationGroup maxLength(int maxLength) {
        validationList.add(new StringMaxLength(object, maxLength, errorTip));
        return getSelf() ;
    }

    /**
     * 字符串区间长度验证，最小长度不能大于最大长度
     * @param minLength 字符串长度区间最小长度
     * @param maxLength 字符串长度区间最大长度
     * @return 字符串验证类组合对象
     */
    public StringValidationGroup rangeLength(int minLength, int maxLength) {
        if (minLength > maxLength) {
            throw new IllegalArgumentException("the minLength arg:" + minLength + " greater than the maxLength arg:" + maxLength) ;
        }
        validationList.add(new StringRangeLength(object, minLength, maxLength, errorTip));
        return getSelf() ;
    }

    /**
     * 验证条件， 布尔表达式，验证表达式约定要和要验证的对象有关
     * 此方法作为一个扩展来使用
     * @param exp 布尔表达式验证
     * @return 日期 验证类组合对象
     */
    public StringValidationGroup expression(boolean exp) {
        validationList.add(new BooleanValidation(exp, errorTip)) ;
        return getSelf() ;
    }

    public StringValidationGroup getSelf() {
        return this ;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
