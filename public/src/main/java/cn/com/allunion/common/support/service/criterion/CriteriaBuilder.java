package cn.com.allunion.common.support.service.criterion;

import java.util.ArrayList;
import java.util.List;

/**
 * 条件构建器对象
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/10.
 * @copyright http://www.all-union.com.cn/
 */
public abstract class CriteriaBuilder {
    public static List<Criteria> buildOr(Criteria... criterias) {
        if (null != criterias) {
            List<Criteria> criteriaList = new ArrayList<Criteria>(criterias.length);
            for (Criteria c : criterias) {
                criteriaList.add(c);
            }

            return criteriaList ;
        }

        return null ;
    }

    /**
     * 构建查询条件
     * @return
     */
    protected abstract Criteria build() ;
}
