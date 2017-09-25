package com.payjoy.dao;

import cn.com.allunion.common.GenericsUtils;
import cn.com.allunion.common.page.QueryResult;
import cn.com.allunion.common.support.service.criterion.Criteria;
import cn.com.allunion.common.support.service.criterion.CriteriaBuilder;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * 业务处理抽象实现类，这里提供一个抽象实现，这个时候还不知道T到底是哪个对象
 * @author YangJie
 * @param <T> 实体类
 */

@Transactional(readOnly = true)
public abstract class DAOSupport<T> implements IDAO<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DAOSupport.class) ;

    @PersistenceContext
    protected EntityManager entityManager ;

    protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this.getClass()) ;

    /**
     * 保存实体对象
     * @param entity 实体对象
     */
    @Override @Transactional
    public void save(T entity) {
        this.entityManager.persist(entity) ;
    }

    @Override @Transactional
    public void clear(){
        entityManager.clear();
    }

    /**
     * 根据实体标识属性（可变数组）删除实体，
     * @param entityIds 实体标识属性可变数组
     */
    @Override @Transactional
    public void delete(Serializable... entityIds) {
        for(Object id : entityIds){
            entityManager.remove(entityManager.getReference(this.entityClass, id));
        }
//        this.entityManager.remove(this.entityManager.getReference(this.entityClass, entityId)) ;
    }

    /**
     * 更新实体
     * @param entity 要更新的实体对象
     */
    @Override @Transactional
    public void update(T entity) {
        this.entityManager.merge(entity) ;
    }

    /**
     * 根据实体对象的标识属性查找实体
     * @param entityId 实体的标识属性
     * @return 查找到的实体对象
     */
    @Override
    public T find(Serializable entityId) {
        return this.entityManager.find(this.entityClass, entityId) ;
    }

    @Override
    public T find(Criteria criteria) {
        return find(CriteriaBuilder.buildOr(criteria));
    }

    @Override
    public T find(List<Criteria> orCriterias) {
        List<Object> params = new ArrayList<Object>();
        // 构建条件子句
        String whereString = CollectionUtils.isNotEmpty(orCriterias)  ? " WHERE " + buildWhereSqlFromCriteria(orCriterias, params) : "" ;

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("where sql: {}", whereString);
        }

        Query query = entityManager.createQuery("SELECT obj FROM " + getEntityName() + " obj " + whereString) ;

        // 设置查询参数
        setQueryParameter(query, params.toArray()) ;

        List<T> resultList = query.getResultList() ;

        if (CollectionUtils.isNotEmpty(resultList)) {
            return resultList.get(0) ;
        }

        return null ;
    }

    @Override
    public T find(String jpqlWhere, Object[] params) {
        // 构建条件子句
        String whereString = null!=jpqlWhere && !"".equals(jpqlWhere.trim()) ? " WHERE " + jpqlWhere : "" ;

        // 取得总记录条数
        Query query = entityManager.createQuery("SELECT obj FROM " + getEntityName() + " obj " + whereString) ;
        // 设置查询参数
        setQueryParameter(query, params) ;

        List<T> entityList = query.getResultList() ;

        if (CollectionUtils.isNotEmpty(entityList)) {
            return entityList.get(0) ;
        }

        return null ;
    }

    @Override
    public T get(String jpqlWhere, Object[] params) {
        return find(jpqlWhere, params);
    }

    /**
     * 根据实体对象的标识属性查找实体
     * @param entityId 实体的标识属性
     * @return 查找到的实体对象
     */
    @Override
    public T get(Serializable entityId) {
        return this.entityManager.find(this.entityClass, entityId) ;
    }

    @Override
    public T get(Criteria criteria) {
        return find(criteria);
    }

    @Override
    public T get(List<Criteria> orCriterias) {
        return find(orCriterias);
    }

    /**
     * 得到总的实体对象数量
     * @return 实体对象数量
     */
    @Override
    public long getCount() {
        return (Long) this.entityManager.createQuery("select count(obj) from " + getEntityName() + " obj").getSingleResult() ;
    }

    /**
     * 获取商品的数量
     *
     * @param jpqlWhere 条件
     * @param params    参数
     * @return 数量
     */
    @Override
    public long getCount(String jpqlWhere, Object[] params) {
        // 构建条件子句
        String whereString = null!=jpqlWhere && !"".equals(jpqlWhere.trim()) ? " WHERE " + jpqlWhere : "" ;

        // 取得总记录条数
        Query query = entityManager.createQuery("SELECT count(obj) FROM " + getEntityName() + " obj " + whereString) ;
        // 设置查询参数
        setQueryParameter(query, params) ;

        return (Long) query.getSingleResult() ;
    }

    @Override
    public long getCount(Criteria criteria) {
        // 占位符参数集合
        List<Object> params = new ArrayList<Object>();

        // 条件集合
        List<Criteria> orCriterias = new ArrayList<Criteria>();
        orCriterias.add(criteria);

        // 构建条件子句
        String whereString = CollectionUtils.isNotEmpty(orCriterias)  ? " WHERE " + buildWhereSqlFromCriteria(orCriterias, params) : "" ;

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("where sql: {}", whereString);
        }

        Query query = entityManager.createQuery("SELECT count(obj) FROM " + getEntityName() + " obj " + whereString) ;

        // 设置查询参数
        setQueryParameter(query, params.toArray()) ;

        return (Long) query.getSingleResult();
    }

    /**
     * 获取实体名称，默认为类的简单名称，如果配置了name属性，那么实体名称发生改变
     * @return 实体名称
     */
    public String getEntityName() {
        String entityName = this.entityClass.getSimpleName() ;

        // 使用反射技术获取标记在EntityClass上的注解
        Entity entity = this.entityClass.getAnnotation(Entity.class) ;
        if (null != entity.name() && !"".equals(entity.name())) {
            entityName = entity.name() ;
        }

        return entityName ;
    }


    /**
     * 取得所有的记录
     * @return 查询到的结果集
     */
    @Override
    public QueryResult<T> getScrollData() {
        return getScrollData(-1, -1, null, null, null) ;
    }

    /**
     * 根据当前页和页容量取得的记录条数取得分页数据
     * @param pagination 当前页，如果为-1那么就查找所有的记录
     * @param maxResult 要取得的记录条数，如果为-1那么就查找所有的记录
     * @return 查询到的结果集
     */
    @Override
    public QueryResult<T> getScrollData(int pagination, int maxResult) {
        return getScrollData(pagination, maxResult, null, null, null) ;
    }

    /**
     * 根据当前页和页容量取得的记录条数取得分页数据
     * @param pagination 当前页，如果为-1那么就查找所有的记录
     * @param maxResult 要取得的记录条数，如果为-1那么就查找所有的记录
     * @return 查询到的结果集
     */
    @Override
    public QueryResult<T> getScrollData(int pagination, int maxResult, LinkedHashMap<String, String> orderby) {
        return getScrollData(pagination, maxResult, null, null, orderby) ;
    }

    /**
     * 根据当前页和页容量取得的记录条数以及字段的排序情况取得分页数据
     * @param pagination 当前页，如果为-1那么就查找所有的记录
     * @param maxResult 要取得的记录条数，如果为-1那么就查找所有的记录
     * @param where 查找数据条件子句（不包含where关键字）： obj.username=?1 and obj.email=?2，这里只支持位置索引，而且位置索引从1开始，并且必须连续
     * @param params 条件参数，对应从1开始的位置索引
     * @return 查询到的结果集
     */
    @Override
    public QueryResult<T> getScrollData(int pagination, int maxResult, String where, Object[] params) {
        return getScrollData(pagination, maxResult, where, params, null) ;
    }

    /**
     * 根据当前页和页容量取得的记录条数以及字段的排序情况取得分页数据
     * @param pagination 当前页，如果为-1那么就查找所有的记录
     * @param maxResult 要取得的记录条数，如果为-1那么就查找所有的记录
     * @param where 查找数据条件子句（不包含where关键字）： obj.username=?1 and obj.email=?2，这里只支持位置索引，而且位置索引从1开始，并且必须连续
     * @param params 条件参数，对应从1开始的位置索引
     * @param orderby 字段的排序情况：
     * 		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>() ;
     * 		orderby.put("username", "asc") ;
     * 		orderby.put("email", "desc") ;
     * @return 查询到的结果集
     */
    @Override
    public QueryResult<T> getScrollData(int pagination, int maxResult, String where, Object[] params, LinkedHashMap<String, String> orderby) {

        QueryResult<T> queryResult = new QueryResult<T>() ;

        // 构建条件子句
        String whereString = null!=where && !"".equals(where.trim()) ? " WHERE " + where : "" ;

        Query query = entityManager.createQuery("SELECT obj FROM " + getEntityName() + " obj " + whereString + buildOrderby(orderby)) ;

        // 设置分页属性
        setPaging(pagination, maxResult, query) ;

        // 设置查询参数
        setQueryParameter(query, params) ;

        queryResult.setResultList(query.getResultList()) ;

        // 取得总记录条数
        query = entityManager.createQuery("SELECT count(obj) FROM " + getEntityName() + " obj " + whereString) ;
        // 设置查询参数
        setQueryParameter(query, params) ;

        queryResult.setTotalRecord((Long) query.getSingleResult()); ;

        return queryResult ;
    }

    /**
     * 设置分页
     * @param pagination 当前页，从1开始
     * @param maxResult 每页最大记录条数
     * @param query
     */
    protected void setPaging(int pagination, int maxResult, Query query) {
        if (-1 != pagination && -1 != maxResult) {
            int startResult = (pagination-1)*maxResult;
            query.setFirstResult(startResult).setMaxResults(maxResult) ;
        }
    }


    /**
     * 根据给定的排序字段以及顺序构建排序子句
     * @param orderby 配需的字段以及排序顺序
     * @return 构建好的排序子句 order by obj.username asc, obj.email desc
     */
    public static String buildOrderby(LinkedHashMap<String, String> orderby) {
        StringBuilder builder = new StringBuilder() ;

        if (null != orderby && !orderby.isEmpty()) { // 给定的排序字段集合不为null，而且集合不为空
            builder.append(" ORDER BY ") ;
            for (Map.Entry<String, String> entry : orderby.entrySet()) {
                builder.append(" obj.").append(entry.getKey()).append(" ").append(entry.getValue()).append(',') ;
            }
            builder.deleteCharAt(builder.length() -1 ) ; // 删除最后多余的 ','
        }

        return builder.toString() ;
    }

    /**
     * 为查询对象设置条件参数
     * @param query 查询对象
     * @param params 条件参数数组
     */
    public static void setQueryParameter(Query query, Object[] params) {
        if (null != params) { // 参数数组不为空
            for(int i=0; i<params.length; i++) {
                query.setParameter(i+1, params[i]) ;
            }
        }
    }

    @Override
    public QueryResult<T> getScrollData(int pagination, int maxResult, Criteria criteria, LinkedHashMap<String, String> orderBy) {
        return getScrollData(pagination, maxResult, CriteriaBuilder.buildOr(criteria), orderBy) ;
    }

    @Override
    public QueryResult<T> getScrollData(int pagination, int maxResult, Criteria criteria) {
        return getScrollData(pagination, maxResult, criteria, null) ;
    }

    @Override
    public QueryResult<T> getScrollData(int pagination, int maxResult, List<Criteria> orCriterias) {
        return getScrollData(pagination, maxResult, orCriterias, null) ;
    }

    @Override
    public QueryResult<T> getScrollData(int pagination, int maxResult, List<Criteria> orCriterias, LinkedHashMap<String, String> orderby) {

        QueryResult<T> queryResult = new QueryResult<T>() ;

        List<Object> params = new ArrayList<Object>();
        // 构建条件子句
        String whereString = CollectionUtils.isNotEmpty(orCriterias)  ? " WHERE " + buildWhereSqlFromCriteria(orCriterias, params) : "" ;

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("where sql: {}", whereString);
        }

        Query query = entityManager.createQuery("SELECT obj FROM " + getEntityName() + " obj " + whereString + buildOrderby(orderby)) ;
        // 设置分页属性
        setPaging(pagination, maxResult, query);

        // 设置查询参数
        setQueryParameter(query, params.toArray()) ;

        queryResult.setResultList(query.getResultList()) ;

        // 取得总记录条数
        query = entityManager.createQuery("SELECT count(obj) FROM " + getEntityName() + " obj " + whereString) ;
        // 设置查询参数
        setQueryParameter(query, params.toArray()) ;

        queryResult.setTotalRecord((Long) query.getSingleResult()); ;

        return queryResult ;
    }

    /**
     * 构建where子句
     * @param orCriteriaList 条件集合
     */
    public static String buildWhereSqlFromCriteria(List<Criteria> orCriteriaList, List<Object> params) {
        // 处理查询条件
        if (CollectionUtils.isNotEmpty(orCriteriaList)) {
            StringBuilder whereBuilder = new StringBuilder() ;
            for (int i=0; i<orCriteriaList.size(); ++i) {
                // 如果大于1个的情况下，那么表示 or 操作
                if (i > 0) {
                    whereBuilder.append(" OR ") ;
                }

                whereBuilder.append(" ( ") ;
                Criteria orCriteria = orCriteriaList.get(i);

                int count = 0 ;
                for (Criteria.Criterion c : orCriteria.getCriterionList()) {
                    if (count > 0) {
                        whereBuilder.append(" AND ") ;
                    }
                    // 适配具体产品的条件实现
                    whereBuilder.append(c.adapt(params));

                    ++ count;
                }

                whereBuilder.append(" ) ") ;
            }

            return whereBuilder.toString();
        }

        return "" ;
    }
}
