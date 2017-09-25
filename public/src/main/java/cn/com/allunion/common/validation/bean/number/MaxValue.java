package cn.com.allunion.common.validation.bean.number;

import cn.com.allunion.common.validation.bean.AbstractValidation;

/**
 * 数值最大值验证
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/26.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class MaxValue<T extends Number> extends AbstractValidation<T> {
    /**
     * 最大值
     */
    private T maxValue ;

    public MaxValue(T object, T maxValue, String errorTip) {
        super(object, errorTip);
        this.maxValue = maxValue ;
    }

    @Override
    public boolean validate() {
        if (null != object && null != maxValue) {
            if (object instanceof Byte) {
                return object.byteValue() <= maxValue.byteValue() ;
            } else if (object instanceof Short) {
                return object.shortValue() <= maxValue.shortValue() ;
            } else if (object instanceof Integer) {
                return object.intValue() <= maxValue.intValue() ;
            } else if (object instanceof Long) {
                return object.longValue() <= maxValue.longValue() ;
            } else if (object instanceof Float) {
                return object.floatValue() <= maxValue.floatValue() ;
            } else if (object instanceof Double) {
                return object.doubleValue() <= maxValue.doubleValue() ;
            }
        }
        return false;
    }
}
