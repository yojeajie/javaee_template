package cn.com.allunion.common.support.service.criterion;

import cn.com.allunion.common.support.service.criterion.AbstractCriterion;

/**
 * 一个值的条件
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/9.
 * @copyright http://www.all-union.com.cn/
 */
public abstract class AbstractOneValueCriterion<T> extends AbstractCriterion<T> {
    /**
     * 属性名称
     */
    protected String property ;

    /**
     * 单个值
     */
    protected Object value ;

    public AbstractOneValueCriterion() {}

    public AbstractOneValueCriterion(String property, Object value) {
        this.property = property;
        this.value = value;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
