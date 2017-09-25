package cn.com.allunion.common.criterion.mybatis.mapper;

import cn.com.allunion.common.support.service.criterion.AbstractCriterion;
import cn.com.allunion.common.support.service.criterion.AbstractTwoValueCriterion;
import tk.mybatis.mapper.entity.Example;

/**
 * not between and 两个值的条件
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/9.
 * @copyright http://www.all-union.com.cn/
 */
public class NotBetweenCriterionForMapper extends AbstractTwoValueCriterion<Example.Criteria> {

    public NotBetweenCriterionForMapper() {}

    public NotBetweenCriterionForMapper(String property, Object value1, Object value2) {
        this.property = property;
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public Object adapt(Example.Criteria object) {
        return object.andNotBetween(property, value1, value2);
    }
}
