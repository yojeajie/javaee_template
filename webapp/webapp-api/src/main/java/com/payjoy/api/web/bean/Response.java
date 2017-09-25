package com.payjoy.api.web.bean;

/**
 * 业务接口响应数据
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/12/19.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class Response<T> {
    /**
     * 响应业务状态，0：表示成功
     */
    private int status;

    /**
     * 响应消息，成功返回OK，否者返回错误消息
     */
    private String errMsg;

    /**
     * 数据载体对象
     */
    private T payload;

    /**
     * 新建响应对象
     * @param status 状态码
     * @param errMsg 错误信息
     * @param payload 数据
     */
    public Response(int status, String errMsg, T payload) {
        this.status = status;
        this.errMsg = errMsg;
        this.payload = payload;
    }

    public Response(T data) {
        this(0, "OK", data);
    }

    public static Response build(int status, String msg) {
        return new Response(status, msg, null);
    }

    public static Response build(int status, String msg, Object data) {
        return new Response(status, msg, data);
    }

    public static Response ok(Object data) {
        return new Response(data);
    }

    public static Response ok() {
        return new Response(null);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
