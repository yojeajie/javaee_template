package cn.com.allunion.common.support.service.criterion;

import java.util.Collection;
import java.util.List;

/**
 * and 条件 组合 接口
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/10.
 * @copyright http://www.all-union.com.cn/
 */
public interface Criteria {
    /**
     * 获取本对象
     * @return 本对象引用
     */
    Criteria getSelf() ;

    /**
     * 等于条件
     * @param property 实体类属性名称
     * @param value 等于的值
     * @return 条件对象
     */
    Criteria EqualTo(String property, Object value) ;

    /**
     * 等于条件
     * @param property 实体类属性名称
     * @param value 等于的值
     * @return 条件对象
     */
    Criteria NotEqualTo(String property, Object value) ;

    /**
     * 字段为空条件
     * @param property 实体类属性名称
     * @return 条件对象
     */
    Criteria IsNull(String property);

    /**
     * 字段不为空条件
     * @param property 实体类属性名称
     * @return 条件对象
     */
    Criteria IsNotNull(String property) ;

    /**
     * 大于 > 条件
     * @param property 实体类属性名称
     * @param value 大于的值
     * @return 条件对象
     */
    Criteria GreaterThan(String property, Object value) ;

    /**
     * 大于等于 >= 条件
     * @param property 实体类属性名称
     * @param value 大于等于的值
     * @return 条件对象
     */
    Criteria GreaterThanOrEqualTo(String property, Object value) ;

    /**
     * 小于 < 条件
     * @param property 实体类属性名称
     * @param value 小于的值
     * @return 条件对象
     */
    Criteria LessThan(String property, Object value);

    /**
     * 小于等于 <= 条件
     * @param property 实体类属性名称
     * @param value 小于等于的值
     * @return 条件对象
     */
    Criteria LessThanOrEqualTo(String property, Object value) ;

    /**
     * LIKE 条件
     * @param property 实体类属性名称
     * @param value LIKE 的值
     * @return 条件对象
     */
    Criteria Like(String property, String value) ;

    /**
     * NOT LIKE 条件
     * @param property 实体类属性名称
     * @param value NOT LIKE 的值
     * @return 条件对象
     */
    Criteria NotLike(String property, String value) ;

    /**
     * IN 条件
     * @param property 实体类属性名称
     * @param values IN 的值集合
     * @return 条件对象
     */
    Criteria In(String property, Collection<?> values) ;

    /**
     * NOT IN 条件
     * @param property 实体类属性名称
     * @param values NOT IN 的值
     * @return 条件对象
     */
    Criteria NotIn(String property, Collection<?> values) ;

    /**
     * BETWEEN AND 条件
     * @param property 实体类属性名称
     * @param value1 between 后的值
     * @param value2 and 后的值
     * @return 条件对象
     */
    Criteria Between(String property, Object value1, Object value2) ;

    /**
     * NOT BETWEEN AND 条件
     * @param property 实体类属性名称
     * @param value1 between 后的值
     * @param value2 and 后的值
     * @return 条件对象
     */
    Criteria NotBetween(String property, Object value1, Object value2);

    /**
     * 获取单个条件集合
     * @return 单个条件集合
     */
    List<Criterion> getCriterionList();

    /**
     * 单个条件
     * @param <T> 条件要适配的对象
     */
    interface Criterion<T> {
        /**
         * 适配操作，将当前的抽象条件适配到具体的条件对象
         * @param object 要适配的对象
         * @return 适配操作后返回值对象
         */
        Object adapt(T object) ;
    }
}
