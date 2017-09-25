package cn.com.allunion.common.criterion.mybatis.mapper;

import cn.com.allunion.common.support.service.criterion.AbstractCriterion;
import tk.mybatis.mapper.entity.Example;

import java.util.Collection;

/**
 * NOT IN 的条件
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/9.
 * @copyright http://www.all-union.com.cn/
 */
public class NotInCriterionForMapper extends AbstractCriterion<Example.Criteria> {
    /**
     * 属性名称
     */
    protected String property ;

    /**
     * 集合值
     */
    protected Collection<?> value ;

    public NotInCriterionForMapper() {}

    public NotInCriterionForMapper(String property, Collection<?> value) {
        this.property = property;
        this.value = value;
    }

    @Override
    public Object adapt(Example.Criteria object) {
        return object.andNotIn(property, value);
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Collection<?> getValue() {
        return value;
    }

    public void setValue(Collection<?> value) {
        this.value = value;
    }
}
