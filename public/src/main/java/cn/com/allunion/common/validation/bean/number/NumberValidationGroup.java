package cn.com.allunion.common.validation.bean.number;

import cn.com.allunion.common.validation.Validation;
import cn.com.allunion.common.validation.bean.AbstractValidationGroup;
import cn.com.allunion.common.validation.bean.BooleanValidation;
import cn.com.allunion.common.validation.bean.NotNull;
import cn.com.allunion.common.validation.bean.Null;

/**
 * 数值验证类组合
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/27.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class NumberValidationGroup<T extends Number> extends AbstractValidationGroup {

    /**
     * 要验证的对象
     */
    protected T object ;

    public NumberValidationGroup(T object) {
        this.object = object ;
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
     * 数值对象为null验证
     * @return 验证工具类
     */
    public NumberValidationGroup<T> isNull() {
        validationList.add(new Null(object, errorTip));
        return getSelf() ;
    }

    /**
     * 数值对象不能为null验证
     * @return 验证工具类
     */
    public NumberValidationGroup<T> notNull() {
        validationList.add(new NotNull(object, errorTip));
        return getSelf() ;
    }

    /**
     * 最小值验证
     * @param minValue 最小值
     * @return 验证工具类
     */
    public NumberValidationGroup<T> minValue(T minValue) {
        validationList.add(new MinValue<T>(object, minValue, errorTip));
        return getSelf() ;
    }

    /**
     * 最大值验证
     * @param maxValue 最大值
     * @return 验证工具类
     */
    public NumberValidationGroup<T> maxValue(T maxValue) {
        validationList.add(new MinValue<T>(object, maxValue, errorTip));
        return getSelf() ;
    }

    /**
     * 数值区间验证，minValue必须小于maxValue
     * @param minValue 最小值
     * @param maxValue 最大值
     * @return 验证工具类
     */
    public NumberValidationGroup<T> rangeValue(T minValue, T maxValue) {
//        if (minValue > maxValue) {
//            throw new IllegalStateException("the minValue arg:" + minValue + " greater than the maxValue arg:" + maxValue) ;
//        }
        validationList.add(new RangeValue<T>(object, minValue, maxValue, errorTip));
        return getSelf() ;
    }

    /**
     * 数值是一个数值集合中的元素 验证
     * @param values 数值集合可变参数
     * @return 验证工具类
     */
    public NumberValidationGroup<T> valueIn(T... values) {
        validationList.add(new ValueIn<T>(object, errorTip, values));
        return getSelf() ;
    }

    /**
     * 验证条件， 布尔表达式，验证表达式约定要和要验证的对象有关
     * 此方法作为一个扩展来使用
     * @param exp 布尔表达式验证
     * @return 日期 验证类组合对象
     */
    public NumberValidationGroup<T> expression(boolean exp) {
        validationList.add(new BooleanValidation(exp, errorTip)) ;
        return getSelf() ;
    }

    public NumberValidationGroup getSelf() {
        return this ;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
