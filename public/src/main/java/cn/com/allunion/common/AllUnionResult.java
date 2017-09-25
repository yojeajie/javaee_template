package cn.com.allunion.common;

import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang.StringUtils;

/**
 * 自定义响应结构
 * Created by YangJie on 2016/4/19.
 */
public class AllUnionResult {
    /**
     * 响应业务状态，0：表示成功
     */
    @JSONField(name = "rspCode")
    private int status;

    /**
     * 响应消息，成功返回OK，否者返回出错消息
     */
    @JSONField(name = "rspDesc")
    private String msg;

    /**
     * 响应中的数据
     */
    private Object data;

    public static AllUnionResult build(int status, String msg) {
        return new AllUnionResult(status, msg, null);
    }

    public static AllUnionResult build(int status, String msg, Object data) {
        return new AllUnionResult(status, msg, data);
    }

    public static AllUnionResult ok(Object data) {
        return new AllUnionResult(data);
    }

    public static AllUnionResult ok() {
        return new AllUnionResult(null);
    }

    public static Object okJSONP(String callback) {
        return okJSONP(callback, null) ;
    }

    public static Object okJSONP(String callback, Object data) {
        AllUnionResult result = new AllUnionResult(data) ;
        if (StringUtils.isEmpty(callback)) {
            return result ;
        } else {
            JSONPObject jsonpObject = new JSONPObject(callback) ;
            jsonpObject.addParameter(result);
            return jsonpObject ;
        }
    }

    public static Object buildJSONP(String callback, int status, String msg) {
        return buildJSONP(callback, status, msg, null) ;
    }

    public static Object buildJSONP(String callback, int status, String msg, Object data) {
        AllUnionResult result = new AllUnionResult(status, msg, data);
        if (StringUtils.isEmpty(callback)) {
            return result ;
        } else {
            JSONPObject jsonpObject = new JSONPObject(callback) ;
            jsonpObject.addParameter(result);
            return jsonpObject ;
        }
    }

    public AllUnionResult() {
    }

    public AllUnionResult(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public AllUnionResult(Object data) {
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
