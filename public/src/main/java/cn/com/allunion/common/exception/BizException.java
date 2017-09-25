package cn.com.allunion.common.exception;

/**
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2017/1/4.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class BizException extends RuntimeException {
    /**
     * 响应业务状态码
     */
    protected int bizStatus ;

    public BizException() {}

    public BizException(String msg) {
        super(msg);
    }

    public BizException(int bizStatus, String msg) {
        super(msg);
        this.bizStatus = bizStatus;
    }

    public int getBizStatus() {
        return bizStatus;
    }

    public void setBizStatus(int bizStatus) {
        this.bizStatus = bizStatus;
    }
}
