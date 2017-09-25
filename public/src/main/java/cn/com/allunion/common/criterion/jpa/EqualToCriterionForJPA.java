package cn.com.allunion.common.criterion.jpa;

import cn.com.allunion.common.support.service.criterion.AbstractOneValueCriterion;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 等于条件
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/9.
 * @copyright http://www.all-union.com.cn/
 */
public class EqualToCriterionForJPA extends AbstractOneValueCriterion<List<Object>> {
    public EqualToCriterionForJPA() {
    }

    public EqualToCriterionForJPA(String property, Object value) {
        super(property, value);
    }

    @Override
    public Object adapt(List<Object> object) {
        object.add(value);
        if (property.indexOf('.') == -1) {
            return new StringBuffer().append(" obj.").append(property).append(" = ?").append(object.size());
        } else {
            return new StringBuffer().append(" ").append(property).append(" = ?").append(object.size());
        }
    }
}
