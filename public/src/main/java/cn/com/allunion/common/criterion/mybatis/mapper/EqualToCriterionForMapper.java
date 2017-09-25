package cn.com.allunion.common.criterion.mybatis.mapper;

import cn.com.allunion.common.support.service.criterion.AbstractOneValueCriterion;
import tk.mybatis.mapper.entity.Example;

/**
 * 等于条件
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/9.
 * @copyright http://www.all-union.com.cn/
 */
public class EqualToCriterionForMapper extends AbstractOneValueCriterion<Example.Criteria> {
    public EqualToCriterionForMapper() {
    }

    public EqualToCriterionForMapper(String property, Object value) {
        super(property, value);
    }

    @Override
    public Object adapt(Example.Criteria object) {
        return object.andEqualTo(property, value);
    }
}
