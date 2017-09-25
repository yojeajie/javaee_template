package cn.com.allunion.common;

import cn.com.allunion.common.page.QueryResult;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 结果集转换对象
 *
 * @param <S> 源对象类型
 * @param <T> 目标对象类型
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/6/1.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class ResultConvertor<S, T> {

    protected Class<T> targetClass;

    /**
     * 构造方法
     *
     * @param clazz 目标对象的类型
     */
    public ResultConvertor(Class<T> clazz) {
        this.targetClass = clazz;
    }

    /**
     * 将源对象转化为目标对象
     *
     * @param source 源对象
     * @return 目标对象
     */
    public T convert(S source) throws InstantiationException, IllegalAccessException {
        if (null == source) {
            return null;
        }

        T target = targetClass.newInstance();
        BeanUtils.copyProperties(source, target);
        // 自定义的内部操作
        convertInternal(source, target);
        return target;
    }

    /**
     * 转换内部操作
     *
     * @param source 转化源对象
     * @param target 转化目标对象
     */
    protected void convertInternal(S source, T target) throws IllegalAccessException, InstantiationException {
    }

    /**
     * 将源对象集合转化为目标对象集合
     *
     * @param sList 源对象集合
     * @return 目标对象集合
     */
    public List<T> convert(Collection<S> sList) throws InstantiationException, IllegalAccessException {
        if (CollectionUtils.isEmpty(sList)) {
            return new ArrayList<>(0);
        }
        List<T> resultList = new ArrayList<>(sList.size());
        for (S s : sList) {
            resultList.add(convert(s));
        }

        return resultList;
    }

    /**
     * 将源对象查询结果集转化为目标对象查询结果集
     *
     * @param queryResult 源对象查询结果集
     * @return 目标对象查询结果集
     */
    public QueryResult<T> convert(QueryResult<S> queryResult) throws InstantiationException, IllegalAccessException {
        if (null == queryResult) {
            return null;
        }

        return new QueryResult<T>(convert(queryResult.getResultList()), queryResult.getTotalRecord());
    }
}
