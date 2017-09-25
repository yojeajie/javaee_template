package cn.com.allunion.common.criterion.mybatis.mapper;

import cn.com.allunion.common.support.service.criterion.AbstractOneValueCriterion;
import tk.mybatis.mapper.entity.Example;

/**
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/9.
 * @copyright http://www.all-union.com.cn/
 */
public class NotEqualToCriterionForMapper extends AbstractOneValueCriterion<Example.Criteria> {
    public NotEqualToCriterionForMapper() {
    }

    public NotEqualToCriterionForMapper(String property, Object value) {
        super(property, value);
    }

    @Override
    public Object adapt(Example.Criteria object) {
        return object.andNotEqualTo(property, value);
    }
}
