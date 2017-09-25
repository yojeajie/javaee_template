package cn.com.allunion.common.handler;

/**
 * 响应封装对象
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/12.
 * @copyright http://www.all-union.com.cn/
 */
public class Response {
    /**
     * 响应业务状态，0：表示成功
     */
    private int status;

    /**
     * 响应消息，成功返回OK，否者返回出错消息
     */
    private String msg;

    /**
     * 响应中的数据行
     */
    private Object data;

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

    public Response() {
    }

    public Response(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Response(Object data) {
        this.status = 0;
        this.msg = "OK";
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
