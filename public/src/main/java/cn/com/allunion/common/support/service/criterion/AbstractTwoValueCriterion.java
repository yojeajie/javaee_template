package cn.com.allunion.common.support.service.criterion;

/**
 * 两个值的条件
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/9.
 * @copyright http://www.all-union.com.cn/
 */
public abstract class AbstractTwoValueCriterion<T> extends AbstractCriterion<T> {
    /**
     * 属性名称
     */
    protected String property ;

    /**
     * 第一个值
     */
    protected Object value1 ;

    /**
     * 第二个值
     */
    protected Object value2 ;

    public AbstractTwoValueCriterion() {}

    public AbstractTwoValueCriterion(String property, Object value1, Object value2) {
        this.property = property;
        this.value1 = value1 ;
        this.value2 = value2 ;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Object getValue1() {
        return value1;
    }

    public void setValue1(Object value1) {
        this.value1 = value1;
    }

    public Object getValue2() {
        return value2;
    }

    public void setValue2(Object value2) {
        this.value2 = value2;
    }
}
