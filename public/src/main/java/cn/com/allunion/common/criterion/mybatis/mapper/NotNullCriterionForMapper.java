package cn.com.allunion.common.criterion.mybatis.mapper;

import cn.com.allunion.common.support.service.criterion.AbstractOnlyPropertyCriterion;
import tk.mybatis.mapper.entity.Example;

/**
 * 不为空条件
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/9.
 * @copyright http://www.all-union.com.cn/
 */
public class NotNullCriterionForMapper extends AbstractOnlyPropertyCriterion<Example.Criteria> {
    public NotNullCriterionForMapper() {
    }

    public NotNullCriterionForMapper(String property) {
        super(property);
    }


    @Override
    public Object adapt(Example.Criteria object) {
        return object.andIsNotNull(property);
    }
}
