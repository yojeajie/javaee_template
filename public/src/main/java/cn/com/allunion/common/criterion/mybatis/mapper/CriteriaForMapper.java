package cn.com.allunion.common.criterion.mybatis.mapper;

import cn.com.allunion.common.support.service.criterion.Criteria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 服务层支撑条件类对象，该类是一个抽象条件的描述对象
 *      使用方法如下：
 *      <code>
 *      Criteria criteria = new Criteria() ;
 *      criteria.EqualTo("name", "xxxxx") ; // 表示name属性等于字符串 "xxxxx"
 *      criteria.Like("desc", "yyyy%") ;     // 表示desc属性字符串 like "yyyy%"
 *      // 也可以这么写
 *      criteria.EqualTo("name", "xxxxx").Like("desc", "yyyy%") ;
 *      <code/>
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/9.
 * @copyright http://www.all-union.com.cn/
 */
public class CriteriaForMapper implements Criteria {
    private List<Criteria.Criterion> criterionList = new ArrayList<>() ;

    /**
     * 获取本对象
     * @return 本对象引用
     */
    public Criteria getSelf() {
        return this;
    }

    /**
     * 等于条件
     * @param property 实体类属性名称
     * @param value 等于的值
     * @return 条件对象
     */
    public Criteria EqualTo(String property, Object value) {
        criterionList.add(new EqualToCriterionForMapper(property, value));
        return getSelf() ;
    }

    /**
     * 等于条件
     * @param property 实体类属性名称
     * @param value 等于的值
     * @return 条件对象
     */
    public Criteria NotEqualTo(String property, Object value) {
        criterionList.add(new NotEqualToCriterionForMapper(property, value));
        return getSelf() ;
    }

    /**
     * 字段为空条件
     * @param property 实体类属性名称
     * @return 条件对象
     */
    public Criteria IsNull(String property) {
        criterionList.add(new NullCriterionForMapper(property));
        return getSelf() ;
    }

    /**
     * 字段不为空条件
     * @param property 实体类属性名称
     * @return 条件对象
     */
    public Criteria IsNotNull(String property) {
        criterionList.add(new NotNullCriterionForMapper(property));
        return getSelf() ;
    }

    /**
     * 大于 > 条件
     * @param property 实体类属性名称
     * @param value 大于的值
     * @return 条件对象
     */
    public Criteria GreaterThan(String property, Object value) {
        criterionList.add(new GreaterThanCriterionForMapper(property, value));
        return getSelf() ;
    }

    /**
     * 大于等于 >= 条件
     * @param property 实体类属性名称
     * @param value 大于等于的值
     * @return 条件对象
     */
    public Criteria GreaterThanOrEqualTo(String property, Object value) {
        criterionList.add(new GreaterThanOrEqualToCriterionForMapper(property, value));
        return getSelf() ;
    }

    /**
     * 小于 < 条件
     * @param property 实体类属性名称
     * @param value 小于的值
     * @return 条件对象
     */
    public Criteria LessThan(String property, Object value) {
        criterionList.add(new LessThanCriterionForMapper(property, value));
        return getSelf() ;
    }

    /**
     * 小于等于 <= 条件
     * @param property 实体类属性名称
     * @param value 小于等于的值
     * @return 条件对象
     */
    public Criteria LessThanOrEqualTo(String property, Object value) {
        criterionList.add(new LessThanOrEqualToCriterionForMapper(property, value));
        return getSelf() ;
    }

    /**
     * LIKE 条件
     * @param property 实体类属性名称
     * @param value LIKE 的值
     * @return 条件对象
     */
    public Criteria Like(String property, String value) {
        criterionList.add(new LikeCriterionForMapper(property, value));
        return getSelf() ;
    }

    /**
     * NOT LIKE 条件
     * @param property 实体类属性名称
     * @param value NOT LIKE 的值
     * @return 条件对象
     */
    public Criteria NotLike(String property, String value) {
        criterionList.add(new NotLikeCriterionForMapper(property, value));
        return getSelf() ;
    }

    /**
     * IN 条件
     * @param property 实体类属性名称
     * @param values IN 的值集合
     * @return 条件对象
     */
    public Criteria In(String property, Collection<?> values) {
        criterionList.add(new InCriterionForMapper(property, values));
        return getSelf() ;
    }

    /**
     * NOT IN 条件
     * @param property 实体类属性名称
     * @param values NOT IN 的值
     * @return 条件对象
     */
    public Criteria NotIn(String property, Collection<?> values) {
        criterionList.add(new NotInCriterionForMapper(property, values));
        return getSelf() ;
    }

    /**
     * BETWEEN AND 条件
     * @param property 实体类属性名称
     * @param value1 between 后的值
     * @param value2 and 后的值
     * @return 条件对象
     */
    public Criteria Between(String property, Object value1, Object value2) {
        criterionList.add(new BetweenCriterionForMapper(property, value1, value2));
        return getSelf() ;
    }

    /**
     * NOT BETWEEN AND 条件
     * @param property 实体类属性名称
     * @param value1 between 后的值
     * @param value2 and 后的值
     * @return 条件对象
     */
    public Criteria NotBetween(String property, Object value1, Object value2) {
        criterionList.add(new NotBetweenCriterionForMapper(property, value1, value2));
        return getSelf() ;
    }

    public List<Criterion> getCriterionList() {
        return criterionList;
    }
}
