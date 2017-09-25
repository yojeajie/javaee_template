package cn.com.allunion.common.exception;

/**
 * 接口访问异常
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/9/2.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class ApiRequestException extends BizException {
    public ApiRequestException() {}

    public ApiRequestException(String msg) {
        super(msg);
        this.bizStatus = -1 ;
    }
}