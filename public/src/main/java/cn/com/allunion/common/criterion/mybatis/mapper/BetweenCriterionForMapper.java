package cn.com.allunion.common.criterion.mybatis.mapper;

import cn.com.allunion.common.support.service.criterion.AbstractTwoValueCriterion;
import tk.mybatis.mapper.entity.Example;

/**
 * between and 两个值的条件
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/9.
 * @copyright http://www.all-union.com.cn/
 */
public class BetweenCriterionForMapper extends AbstractTwoValueCriterion<Example.Criteria> {

    public BetweenCriterionForMapper() {
    }

    public BetweenCriterionForMapper(String property, Object value1, Object value2) {
        super(property, value1, value2);
    }


    @Override
    public Object adapt(Example.Criteria object) {
        return object.andBetween(property, value1, value2);
    }
}
