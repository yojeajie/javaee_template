package cn.com.allunion.common.page;

import java.util.List;

/**
 * 分页 模型
 * @param <T> 实体类
 */
public class QueryResult<T> {
    /**
     * 查询到的结果集
     */
    private List<T> resultList;
    /**
     * 总记录数
     */
	private long totalRecord;

    public QueryResult() {}

    public QueryResult(List<T> resultList, long totalRecord) {
        this.resultList = resultList ;
        this.totalRecord = totalRecord ;
    }

	public List<T> getResultList() {
        return resultList;
    }
    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public long getTotalRecord() {
        return totalRecord;
    }
    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }
}