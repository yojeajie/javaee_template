package cn.com.allunion.common.criterion.jpa;

import cn.com.allunion.common.support.service.criterion.AbstractOneValueCriterion;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * not like模糊查询条件
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/9.
 * @copyright http://www.all-union.com.cn/
 */
public class NotLikeCriterionForJPA extends AbstractOneValueCriterion<List<Object>> {
    public NotLikeCriterionForJPA() {
    }

    public NotLikeCriterionForJPA(String property, Object value) {
        super(property, value);
    }

    @Override
    public Object adapt(List<Object> object) {
        object.add(value);
        return new StringBuilder().append(" obj.").append(property).append(" NOT LIKE ?").append(object.size()) ;
    }
}
