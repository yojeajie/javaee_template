package cn.com.allunion.common.criterion.mybatis.mapper;

import cn.com.allunion.common.support.service.criterion.Criteria;
import cn.com.allunion.common.support.service.criterion.CriteriaBuilder;

/**
 * 通用mapper实现的组合条件构建工具类
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/10.
 * @copyright http://www.all-union.com.cn/
 */
public class CriteriaForMapperBuilder extends CriteriaBuilder {

    /**
     * 获取组合条件 通用mapper实现类
     * @return 组合条件对象
     */
    public Criteria build() {
        return new CriteriaForMapper() ;
    }

}
