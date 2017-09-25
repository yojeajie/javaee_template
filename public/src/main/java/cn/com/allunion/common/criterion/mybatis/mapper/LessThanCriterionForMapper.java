package cn.com.allunion.common.criterion.mybatis.mapper;

import cn.com.allunion.common.support.service.criterion.AbstractOneValueCriterion;
import tk.mybatis.mapper.entity.Example;

/**
 * 小于条件
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/9.
 * @copyright http://www.all-union.com.cn/
 */
public class LessThanCriterionForMapper extends AbstractOneValueCriterion<Example.Criteria> {
    public LessThanCriterionForMapper() {
    }

    public LessThanCriterionForMapper(String property, Object value) {
        super(property, value);
    }


    @Override
    public Object adapt(Example.Criteria object) {
        return object.andLessThan(property, value);
    }
}
