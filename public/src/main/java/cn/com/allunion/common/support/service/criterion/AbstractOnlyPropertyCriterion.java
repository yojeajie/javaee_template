package cn.com.allunion.common.support.service.criterion;

import cn.com.allunion.common.support.service.criterion.AbstractCriterion;

/**
 * 抽象的，仅有属性表达的条件
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/9.
 * @copyright http://www.all-union.com.cn/
 */
public abstract class AbstractOnlyPropertyCriterion<T> extends AbstractCriterion<T> {
    /**
     * 属性
     */
    protected String property ;

    public AbstractOnlyPropertyCriterion() {}

    public AbstractOnlyPropertyCriterion(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
