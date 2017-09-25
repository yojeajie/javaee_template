package com.payjoy.api.web.bean.result;

import cn.com.allunion.common.page.QueryResult;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合型数据不分页返回结果集
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/12/19.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class ListResult<T> {
    /**
     * 查询到的结果集
     */
    private List<T> items;

    /**
     * 总记录数
     */
    private long itemCount;

    public ListResult() {
        this.items = new ArrayList<T>();
        this.itemCount = 0 ;
    }

    public ListResult(QueryResult<T> queryResult) {
        if (null != queryResult) {
            this.items = queryResult.getResultList();
            this.itemCount = queryResult.getTotalRecord();
        }
    }

    public ListResult(List<T> items) {
        this.items = items;
        this.itemCount = null != this.items ? this.items.size() : 0;
    }

    /**
     * 基于查询结果集构建 集合返回结果集
     * @param queryResult 查询结果集，一般为业务逻辑层返回
     * @param <E> 支持泛型
     * @return 返回结果集
     */
    public static <E> ListResult<E> build(QueryResult<E> queryResult) {
        return new ListResult<E>(queryResult) ;
    }

    /**
     * 基于查询结果集构建 集合返回结果集
     * @param queryList 查询结果集合，一般为业务逻辑层返回
     * @param <E> 支持泛型
     * @return 返回结果集
     */
    public static <E> ListResult<E> build(List<E> queryList) {
        return new ListResult<E>(queryList) ;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
        this.itemCount = null != this.items ? this.items.size() : 0;
    }

    public long getItemCount() {
        return itemCount;
    }
}
