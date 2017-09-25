package cn.com.allunion.common.page;

import java.util.List;

public class PageView<T> {
    /**
     * 分页数据
     */
    private List<T> records;
    /**
     * 页码开始索引和结束索引
     */
    private PageIndex pageIndex;
    /**
     * 总页数
     */
    private long totalPage = 1;
    /**
     * 每页显示记录数
     */
    private int maxResult = 12;
    /**
     * 当前页
     */
    private int currentPage = 1;
    /**
     * 总记录数
     */
    private long totalRecord;
    /**
     * 页码数量
     */
    private int pageCode = 9;

    /**
     * 新PageView对象
     * @param maxResult 每页显示的最大记录数
     * @param currentPage 当前页码
     */
    public PageView(int maxResult, int currentPage) {
        this.maxResult = maxResult;
        this.currentPage = currentPage;
    }

    /**
     * 新PageView对象
     * @param maxResult 每页显示的最大记录数
     * @param currentPage 当前页码
     * @param pageCode 要显示的页码数量
     */
    public PageView(int maxResult, int currentPage, int pageCode) {
        this.maxResult = maxResult;
        this.currentPage = currentPage;
        this.pageCode = pageCode ;
    }

    /**
     * 要获取记录的开始索引
     */
    public int getFirstResult() {
        return (this.currentPage - 1) * this.maxResult;
    }

    /**
     * 设置分页查询结果集
     * @param result 查询结果集
     * @param totalRecord 总记录数量
     */
    public void setQueryResult(List<T> result, long totalRecord) {
        setTotalRecord(totalRecord);
        setRecords(result);
    }

    /**
     * 设置分页查询结果集
     * @param queryResult 查询结果集
     */
    public void setQueryResult(QueryResult<T> queryResult) {
        setTotalRecord(queryResult.getTotalRecord());
        setRecords(queryResult.getResultList());
    }

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
        setTotalPage(this.totalRecord % this.maxResult == 0 ? this.totalRecord / this.maxResult : this.totalRecord / this.maxResult + 1);
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public PageIndex getPageIndex() {
        return pageIndex;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
        this.pageIndex = PageIndex.getPageIndex(pageCode, currentPage, totalPage);
    }

    public int getMaxResult() {
        return maxResult;
    }

    public int getCurrentPage() {
        return currentPage;
    }

}