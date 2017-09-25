package cn.com.allunion.common.criterion.jpa;

import cn.com.allunion.common.support.service.criterion.AbstractTwoValueCriterion;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * between and 两个值的条件
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/9.
 * @copyright http://www.all-union.com.cn/
 */
public class BetweenCriterionForJPA extends AbstractTwoValueCriterion<List<Object>> {

    public BetweenCriterionForJPA() {
    }

    public BetweenCriterionForJPA(String property, Object value1, Object value2) {
        super(property, value1, value2);
    }


    @Override
    public Object adapt(List<Object> params) {
        StringBuilder sqlBuilder = new StringBuilder() ;
        sqlBuilder.append(" obj.").append(property).append(" BETWEEN ?").append(params.size()+1)
                .append(" AND ?").append(params.size()+2);
        params.add(value1);
        params.add(value2);
        return sqlBuilder.toString();
    }
}
