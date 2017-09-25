package cn.com.allunion.common.validation.bean.number;

import cn.com.allunion.common.validation.bean.AbstractValidation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/26.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class ValueIn<T extends Number> extends AbstractValidation<T> {
    /**
     * 数值集合
     */
    private List<T> values ;

    public ValueIn(T object, String errorTip, T... values) {
        super(object, errorTip);

        if (null != values) {
            this.values = new ArrayList<>(values.length) ;
            for (T t : values) {
                this.values.add(t);
            }
        }
    }

    @Override
    public boolean validate() {
        if (null != values && values.size() > 0) {
            for (T t : values) {
                if (t.equals(object)) {
                    return true ;
                }
            }
        }
        return false;
    }
}
