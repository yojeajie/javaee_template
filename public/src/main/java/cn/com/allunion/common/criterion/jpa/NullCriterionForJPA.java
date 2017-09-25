package cn.com.allunion.common.criterion.jpa;

import cn.com.allunion.common.support.service.criterion.AbstractOnlyPropertyCriterion;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 为空条件
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/9.
 * @copyright http://www.all-union.com.cn/
 */
public class NullCriterionForJPA extends AbstractOnlyPropertyCriterion<List<Object>> {
    public NullCriterionForJPA() {
    }

    public NullCriterionForJPA(String property) {
        super(property);
    }

    @Override
    public Object adapt(List<Object> object) {
        return new StringBuffer().append(" obj.").append(property).append(" IS NULL") ;
    }
}
