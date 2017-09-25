package cn.com.allunion.common.criterion.jpa;

import cn.com.allunion.common.support.service.criterion.AbstractTwoValueCriterion;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * not between and 两个值的条件
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/9.
 * @copyright http://www.all-union.com.cn/
 */
public class NotBetweenCriterionForJPA extends AbstractTwoValueCriterion<List<Object>> {

    public NotBetweenCriterionForJPA() {}

    public NotBetweenCriterionForJPA(String property, Object value1, Object value2) {
        this.property = property;
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public Object adapt(List<Object> object) {
        StringBuilder sqlBuilder = new StringBuilder() ;
        sqlBuilder.append(" obj.").append(property).append(" NOT BETWEEN ?").append(object.size()+1)
                .append(" AND ?").append(object.size()+2);
        object.add(value1);
        object.add(value2);
        return sqlBuilder;
    }
}
