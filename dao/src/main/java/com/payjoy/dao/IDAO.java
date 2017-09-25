package com.payjoy.dao;

import cn.com.allunion.common.page.QueryResult;
import cn.com.allunion.common.support.service.criterion.Criteria;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;


public interface IDAO<T> {
    /**
     * 获取记录总数
     *
     * @return
     */
    long getCount();

    /**
     * 获取实体数量
     *
     * @param jpqlWhere 条件
     * @param params    参数
     * @return 数量
     */
    long getCount(String jpqlWhere, Object[] params);

    /**
     * 根据条件获取实体记录数量
     * @param criteria 条件
     * @return 获取到的实体对象数量
     */
    long getCount(Criteria criteria);

    /**
     * 清除一级缓存的数据
     */
    void clear();

    /**
     * 保存实体
     *
     * @param entity 实体id
     */
    void save(T entity);

    /**
     * 更新实体
     *
     * @param entity 实体id
     */
    void update(T entity);

    /**
     * 删除实体
     *
     * @param entityIds 实体id数组
     */
    void delete(Serializable... entityIds);

    /**
     * 获取实体
     *
     * @param entityId 实体id
     * @return
     */
    T find(Serializable entityId);

    /**
     * 获取实体对象
     *
     * @param jpqlWhere 条件
     * @param params    参数
     * @return 实体对象
     */
    T find(String jpqlWhere, Object[] params) ;

    /**
     * 根据条件获取实体
     * @param criteria 条件
     * @return 找到的实体对象
     */
    T find(Criteria criteria) ;

    /**
     * 根据条件获取实体
     * @param orCriterias or条件
     * @return 找到的实体对象
     */
    T find(List<Criteria> orCriterias) ;

    /**
     * 获取实体
     *
     * @param entityId 实体id
     * @return
     */
    T get(Serializable entityId);

    /**
     * 获取实体对象
     *
     * @param jpqlWhere 条件
     * @param params    参数
     * @return 实体对象
     */
    T get(String jpqlWhere, Object[] params) ;

    /**
     * 根据条件获取实体
     * @param criteria 条件
     * @return 找到的实体对象
     */
    T get(Criteria criteria) ;

    /**
     * 根据条件获取实体
     * @param orCriterias or条件
     * @return 找到的实体对象
     */
    T get(List<Criteria> orCriterias) ;

    /**
     * 获取分页数据
     *
     * @param pagination 当前页
     * @param maxResult  需要获取的记录数
     * @param whereJpql  where条件子句
     * @param queryParams  查询占位符对应参数，其索引+1为其占用位置
     * @param orderBy  结果集排序参数
     * @return 查询到的结果集
     */
    QueryResult<T> getScrollData(int pagination, int maxResult, String whereJpql, Object[] queryParams, LinkedHashMap<String, String> orderBy);

    QueryResult<T> getScrollData(int pagination, int maxResult, String whereJpql, Object[] queryParams);

    QueryResult<T> getScrollData(int pagination, int maxResult, LinkedHashMap<String, String> orderBy);

    QueryResult<T> getScrollData(int pagination, int maxResult);

    QueryResult<T> getScrollData();

    QueryResult<T> getScrollData(int pagination, int maxResult, List<Criteria> orCriterias, LinkedHashMap<String, String> orderBy);

    QueryResult<T> getScrollData(int pagination, int maxResult, List<Criteria> orCriterias);

    QueryResult<T> getScrollData(int pagination, int maxResult, Criteria criteria, LinkedHashMap<String, String> orderBy);

    QueryResult<T> getScrollData(int pagination, int maxResult, Criteria criteria);
}
