package cn.com.allunion.common.exception;

/**
 * 接口响应异常
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/9/2.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class ApiResponseException extends BizException {

    public ApiResponseException() {}

    public ApiResponseException(String msg) {
        super(msg);
    }

    public ApiResponseException(int bizStatus, String msg) {
        super(bizStatus, msg);
    }
}