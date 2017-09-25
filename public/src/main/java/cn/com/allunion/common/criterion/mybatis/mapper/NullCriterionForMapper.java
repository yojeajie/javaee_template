package cn.com.allunion.common.criterion.mybatis.mapper;

import cn.com.allunion.common.support.service.criterion.AbstractOnlyPropertyCriterion;
import tk.mybatis.mapper.entity.Example;

/**
 * 为空条件
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/9.
 * @copyright http://www.all-union.com.cn/
 */
public class NullCriterionForMapper extends AbstractOnlyPropertyCriterion<Example.Criteria> {
    public NullCriterionForMapper() {
    }

    public NullCriterionForMapper(String property) {
        super(property);
    }

    @Override
    public Object adapt(Example.Criteria object) {
        return object.andIsNull(property);
    }
}
