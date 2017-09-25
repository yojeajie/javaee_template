package cn.com.allunion.common.validation;

import cn.com.allunion.common.validation.bean.*;
import cn.com.allunion.common.validation.bean.date.DateAfterValidation;
import cn.com.allunion.common.validation.bean.date.DateBeforeValidation;
import cn.com.allunion.common.validation.bean.number.MaxValue;
import cn.com.allunion.common.validation.bean.number.MinValue;
import cn.com.allunion.common.validation.bean.number.RangeValue;
import cn.com.allunion.common.validation.bean.number.ValueIn;
import cn.com.allunion.common.validation.bean.string.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 服务器端验证工具类
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/26.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class ValidationHelper {

    private List<Validation> validationList = new ArrayList<>() ;

    /**
     * 构建验证辅助工具类
     * @return 验证辅助个工具类
     */
    public static ValidationHelper build() {
        return new ValidationHelper() ;
    }

    /**
     * 添加对象不为空验证
     * @param object 验证的对象
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addNotNull(Object object, String errorTip) {
        validationList.add(new NotNull(object, errorTip));

        return getSelf() ;
    }

    /**
     * 添加布尔表达式验证
     * @param exp 布尔表达式
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addExpression(boolean exp, String errorTip) {
        validationList.add(new BooleanValidation(exp, errorTip));

        return getSelf() ;
    }

    /**
     * 添加字符串不null或者为空字符串""验证
     * @param object 验证的对象
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addStringEmpty(String object, String errorTip) {
        validationList.add(new StringEmpty(object, errorTip));

        return getSelf() ;
    }

    /**
     * 添加字符串不为null并且不为空字符串""验证
     * @param object 验证的对象
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addStringNotEmpty(String object, String errorTip) {
        validationList.add(new StringNotEmpty(object, errorTip));

        return getSelf() ;
    }

    /**
     * 添加字符串为null或者为空字符串""或者所有字符都为空格验证
     * <pre>
     * null     = true
     * ""       = true
     * " "      = true
     * "bob"    = false
     * "  bob  "= false
     * </pre>
     * @param object 验证的对象
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addStringBlank(String object, String errorTip) {
        validationList.add(new StringBlank(object, errorTip));

        return getSelf() ;
    }

    /**
     * 添加字符串不为null并且不为空字符串""并且所有字符不都为空格验证
     * <pre>
     * null     = false
     * ""       = false
     * " "      = false
     * "bob"    = true
     * "  bob  "= true
     * </pre>
     * @param object 验证的对象
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addStringNotBlank(String object, String errorTip) {
        validationList.add(new StringNotBlank(object, errorTip));

        return getSelf() ;
    }

    /**
     * 添加字符串为数字(负数，小数)
     * @param object 验证的对象
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addStringIsNumber(String object, String errorTip) {
        validationList.add(new StringIsNumber(object, errorTip));
        return getSelf() ;
    }

    /**
     * 添加字符串为整数字符串验证
     * @param object 验证的对象
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addStringIsDigits(String object, String errorTip) {
        validationList.add(new StringIsDigits(object, errorTip));
        return getSelf() ;
    }

    /**
     * 添加字符串为邮箱字符串验证
     * @param object 验证的对象
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addStringIsEmail(String object, String errorTip) {
        validationList.add(new StringMatchRegExp(object, RegExpConstants.REGEXP_EMAIL, errorTip));
        return getSelf() ;
    }

    /**
     * 添加 字符串为中文字符串验证
     * @param object 验证的对象
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addStringIsChinese(String object, String errorTip) {
        validationList.add(new StringMatchRegExp(object, RegExpConstants.REGEXP_CHINESE, errorTip));
        return getSelf() ;
    }

    /**
     * 添加 字符串匹配正则表达式串验证
     * @param object 验证的对象
     * @param regExp 正则表达式字符串
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addStringMatchRegExp(String object, String regExp, String errorTip) {
        validationList.add(new StringMatchRegExp(object, regExp, errorTip));
        return getSelf() ;
    }

    /**
     * 添加字符串最小长度验证
     * @param object 验证的对象
     * @param minLength 字符串最小长度
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addStringMinLength(String object, int minLength, String errorTip) {
        validationList.add(new StringMinLength(object, minLength, errorTip));
        return getSelf() ;
    }

    /**
     * 添加字符串最大长度验证
     * @param object 验证的对象
     * @param maxLength 字符串最大长度
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addStringMaxLength(String object, int maxLength, String errorTip) {
        validationList.add(new StringMaxLength(object, maxLength, errorTip));
        return getSelf() ;
    }

    /**
     * 添加字符串区间长度验证，最小长度不能大于最大长度
     * @param object 验证的对象
     * @param minLength 字符串长度区间最小长度
     * @param maxLength 字符串长度区间最大长度
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addStringRangeLength(String object, int minLength, int maxLength, String errorTip) {
        if (minLength > maxLength) {
            throw new IllegalArgumentException("the minLength arg:" + minLength + " greater than the maxLength arg:" + maxLength) ;
        }
        validationList.add(new StringRangeLength(object, minLength, maxLength, errorTip));
        return getSelf() ;
    }

    /**
     * 添加byte最小值验证
     * @param object 验证的对象
     * @param minValue 最小值
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addMinValue(byte object, byte minValue, String errorTip) {
        validationList.add(new MinValue<Byte>(object, minValue, errorTip));
        return getSelf() ;
    }

    /**
     * 添加short最小值验证
     * @param object 验证的对象
     * @param minValue 最小值
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addMinValue(short object, short minValue, String errorTip) {
        validationList.add(new MinValue<Short>(object, minValue, errorTip));
        return getSelf() ;
    }

    /**
     * 添加int最小值验证
     * @param object 验证的对象
     * @param minValue 最小值
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addMinValue(int object, int minValue, String errorTip) {
        validationList.add(new MinValue<Integer>(object, minValue, errorTip));
        return getSelf() ;
    }

    /**
     * 添加long最小值验证
     * @param object 验证的对象
     * @param minValue 最小值
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addMinValue(long object, long minValue, String errorTip) {
        validationList.add(new MinValue<Long>(object, minValue, errorTip));
        return getSelf() ;
    }

    /**
     * 添加float最小值验证
     * @param object 验证的对象
     * @param minValue 最小值
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addMinValue(float object, float minValue, String errorTip) {
        validationList.add(new MinValue<Float>(object, minValue, errorTip));
        return getSelf() ;
    }

    /**
     * 添加double最小值验证
     * @param object 验证的对象
     * @param minValue 最小值
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addMinValue(double object, double minValue, String errorTip) {
        validationList.add(new MinValue<Double>(object, minValue, errorTip));
        return getSelf() ;
    }

    /**
     * 添加byte最大值验证
     * @param object 验证的对象
     * @param maxValue 最大值
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addMaxValue(byte object, byte maxValue, String errorTip) {
        validationList.add(new MaxValue<Byte>(object, maxValue, errorTip));
        return getSelf() ;
    }

    /**
     * 添加short最大值验证
     * @param object 验证的对象
     * @param maxValue 最大值
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addMaxValue(short object, short maxValue, String errorTip) {
        validationList.add(new MaxValue<Short>(object, maxValue, errorTip));
        return getSelf() ;
    }

    /**
     * 添加int最大值验证
     * @param object 验证的对象
     * @param maxValue 最大值
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addMaxValue(int object, int maxValue, String errorTip) {
        validationList.add(new MaxValue<Integer>(object, maxValue, errorTip));
        return getSelf() ;
    }

    /**
     * 添加long最大值验证
     * @param object 验证的对象
     * @param maxValue 最大值
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addMaxValue(long object, long maxValue, String errorTip) {
        validationList.add(new MaxValue<Long>(object, maxValue, errorTip));
        return getSelf() ;
    }

    /**
     * 添加float最大值验证
     * @param object 验证的对象
     * @param maxValue 最大值
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addMaxValue(float object, float maxValue, String errorTip) {
        validationList.add(new MaxValue<Float>(object, maxValue, errorTip));
        return getSelf() ;
    }

    /**
     * 添加double最大值验证
     * @param object 验证的对象
     * @param maxValue 最大值
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addMaxValue(double object, double maxValue, String errorTip) {
        validationList.add(new MaxValue<Double>(object, maxValue, errorTip));
        return getSelf() ;
    }

    /**
     * 添加byte数值区间验证，minValue必须小于maxValue
     * @param object 验证的对象
     * @param minValue 最小值
     * @param maxValue 最大值
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addRangeValue(byte object, byte minValue, byte maxValue, String errorTip) {
        if (minValue > maxValue) {
            throw new IllegalArgumentException("the minValue arg:" + minValue + " greater than the maxValue arg:" + maxValue) ;
        }
        validationList.add(new RangeValue<Byte>(object, minValue, maxValue, errorTip));
        return getSelf() ;
    }

    /**
     * 添加short数值区间验证，minValue必须小于maxValue
     * @param object 验证的对象
     * @param minValue 最小值
     * @param maxValue 最大值
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addRangeValue(short object, short minValue, short maxValue, String errorTip) {
        if (minValue > maxValue) {
            throw new IllegalArgumentException("the minValue arg:" + minValue + " greater than the maxValue arg:" + maxValue) ;
        }
        validationList.add(new RangeValue<Short>(object, minValue, maxValue, errorTip));
        return getSelf() ;
    }

    /**
     * 添加int数值区间验证，minValue必须小于maxValue
     * @param object 验证的对象
     * @param minValue 最小值
     * @param maxValue 最大值
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addRangeValue(int object, int minValue, int maxValue, String errorTip) {
        if (minValue > maxValue) {
            throw new IllegalArgumentException("the minValue arg:" + minValue + " greater than the maxValue arg:" + maxValue) ;
        }
        validationList.add(new RangeValue<Integer>(object, minValue, maxValue, errorTip));
        return getSelf() ;
    }

    /**
     * 添加long数值区间验证，minValue必须小于maxValue
     * @param object 验证的对象
     * @param minValue 最小值
     * @param maxValue 最大值
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addRangeValue(long object, long minValue, long maxValue, String errorTip) {
        if (minValue > maxValue) {
            throw new IllegalArgumentException("the minValue arg:" + minValue + " greater than the maxValue arg:" + maxValue) ;
        }
        validationList.add(new RangeValue<Long>(object, minValue, maxValue, errorTip));
        return getSelf() ;
    }

    /**
     * 添加float数值区间验证，minValue必须小于maxValue
     * @param object 验证的对象
     * @param minValue 最小值
     * @param maxValue 最大值
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addRangeValue(float object, float minValue, float maxValue, String errorTip) {
        if (minValue > maxValue) {
            throw new IllegalArgumentException("the minValue arg:" + minValue + " greater than the maxValue arg:" + maxValue) ;
        }
        validationList.add(new RangeValue<Float>(object, minValue, maxValue, errorTip));
        return getSelf() ;
    }

    /**
     * 添加double数值区间验证，minValue必须小于maxValue
     * @param object 验证的对象
     * @param minValue 最小值
     * @param maxValue 最大值
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addRangeValue(double object, double minValue, double maxValue, String errorTip) {
        if (minValue > maxValue) {
            throw new IllegalArgumentException("the minValue arg:" + minValue + " greater than the maxValue arg:" + maxValue) ;
        }
        validationList.add(new RangeValue<Double>(object, minValue, maxValue, errorTip));
        return getSelf() ;
    }

    /**
     * 添加int数值在一个int数值集合中验证
     * @param object 验证的对象
     * @param errorTip 错误提示
     * @param values 数值集合可变参数
     * @return 验证工具类
     */
    public ValidationHelper addValueIn(int object,  String errorTip, Integer... values) {
        validationList.add(new ValueIn<Integer>(object, errorTip, values));
        return getSelf() ;
    }

    /**
     * 添加 日期在给定条件日期之前 验证
     * @param object 验证的日期对象
     * @param afterDate 对比的条件日期
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addBefore(Date object, Date afterDate, String errorTip) {
        validationList.add(new DateBeforeValidation(object, afterDate, errorTip));
        return getSelf() ;
    }

    /**
     * 添加 日期在给定条件日期之后 验证
     * @param object 验证的日期对象
     * @param beforeDate 对比的条件日期
     * @param errorTip 错误提示
     * @return 验证工具类
     */
    public ValidationHelper addAfter(Date object, Date beforeDate, String errorTip) {
        validationList.add(new DateAfterValidation(object, beforeDate, errorTip));
        return getSelf() ;
    }


    /**
     * 添加一个验证类对象，将验证不通过通知信息封装到验证类对象中
     * @param validation 验证类对象
     * @return 验证工具类
     * @throws IllegalArgumentException 如果验证对象为null，抛出该异常
     */
    public ValidationHelper add(Validation validation) {
        if (null == validation) {
            throw new IllegalArgumentException("Validation arg must not be null") ;
        }
        validationList.add(validation);
        return getSelf() ;
    }

    /**
     * 添加组合验证，组合验证对象不能为null
     * @param group 验证组，可以使用<code>GroupBuilder.build或者buildOr方法构建组合验证对象</code>
     * @param errorTip 验证未通过提示
     * @return 验证工具类
     * @throws IllegalArgumentException 如果组合验证对象为null，抛出该异常
     */
    public ValidationHelper addGroup(ValidationGroup group, String errorTip) {
        if (null == group) {
            throw new IllegalArgumentException("ValidationGroup arg must not be null") ;
        }
        group.setErrorTip(errorTip); // 设置验证未通过提示
        validationList.add(group);
        return getSelf() ;
    }

    /**
     * 进行验证，一但有验证不通过的，立刻返回
     * @return 所有验证都通过返回null，只有有一个验证不通过返回验证不通过提示字符串
     */
    public String validate() {
        for (Validation v : validationList) {
            if(!v.validate()) {
                return v.getErrorTip() ;
            }
        }

        return null ;
    }

    /**
     * 清除所有已经添加的验证条件对象
     * @return 验证工具类
     */
    public ValidationHelper clear() {
        validationList.clear();
        return getSelf() ;
    }

    private ValidationHelper getSelf() {
        return this ;
    }
}
