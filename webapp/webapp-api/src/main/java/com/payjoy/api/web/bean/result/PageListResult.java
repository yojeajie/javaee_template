package com.payjoy.api.web.bean.result;

import cn.com.allunion.common.page.QueryResult;

import java.util.List;

/**
 * 分页集合型数据返回结果集
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/12/19.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class PageListResult<T> {
    /**
     * 查询到的结果集
     */
    private List<T> items;

    /**
     * 当前页码，从1开始
     */
    private int page = 1;

    /**
     * 每页最大记录数，每页显示 数据条目数量 <= maxCount
     */
    private int maxCount = 12;

    /**
     * 总页数
     */
    private long totalPage = 1 ;

    /**
     * 总记录数
     */
    private long totalRecord;

    /**
     * 新 PageListResult 对象
     * @param maxCount 每页显示的最大记录数
     * @param page 当前页码
     */
    public PageListResult(int maxCount, int page) {
        this.maxCount = maxCount;
        this.page = page;
    }

    /**
     * 设置分页查询结果集
     * @param result 查询结果集
     * @param totalRecord 总记录数量
     */
    public void setQueryResult(List<T> result, long totalRecord) {
        setTotalRecord(totalRecord);
        setItems(result);
    }

    /**
     * 设置分页查询结果集
     * @param queryResult 查询结果集
     */
    public void setQueryResult(QueryResult<T> queryResult) {
        setTotalRecord(queryResult.getTotalRecord());
        setItems(queryResult.getResultList());
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public long getTotalPage() {
        return totalPage;
    }

    protected void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    protected void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
        setTotalPage(this.totalRecord % this.maxCount == 0 ? this.totalRecord / this.maxCount : this.totalRecord / this.maxCount + 1);
    }
}
