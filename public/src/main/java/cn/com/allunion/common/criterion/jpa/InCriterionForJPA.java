package cn.com.allunion.common.criterion.jpa;

import cn.com.allunion.common.support.service.criterion.AbstractCriterion;
import tk.mybatis.mapper.entity.Example;

import java.util.Collection;
import java.util.List;

/**
 * IN 的条件
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/9.
 * @copyright http://www.all-union.com.cn/
 */
public class InCriterionForJPA extends AbstractCriterion<List<Object>> {
    /**
     * 属性名称
     */
    protected String property ;

    /**
     * 集合值
     */
    protected Collection<?> value ;

    public InCriterionForJPA() {}

    public InCriterionForJPA(String property, Collection<?> value) {
        this.property = property;
        this.value = value;
    }

    @Override
    public Object adapt(List<Object> object) {
        StringBuilder sqlBuilder = new StringBuilder().append(" obj.").append(property).append(" IN (");
        for (int i=0; i<value.size(); ++i) {
            if (i>0) {
                sqlBuilder.append(',');
            }
            sqlBuilder.append(" ?").append(object.size()+i+1);
        }
        sqlBuilder.append(" )") ;
        object.addAll(value);
        return sqlBuilder ;
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
