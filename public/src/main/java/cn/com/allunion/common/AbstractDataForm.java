package cn.com.allunion.common;

/**
 * 抽象数据form，用来接收web前端请求数据
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/6/21.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class AbstractDataForm {
    /**
     * 接口标识
     */
    private String marked ;

    /**
     * 模块接口识别标识
     */
    private String code;

    /**
     * 接口版本号
     */
    private String version ;

    /**
     * 接口参数封装字符串
     */
    private String jsonStr ;

    /**
     * jsonp支持回调字符串
     */
    private String callbackparam ;

    public String getMarked() {
        return marked;
    }

    public void setMarked(String marked) {
        this.marked = marked;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getJsonStr() {
        return jsonStr;
    }

    public void setJsonStr(String jsonStr) {
        this.jsonStr = jsonStr;
    }

    public String getCallbackparam() {
        return callbackparam;
    }

    public void setCallbackparam(String callbackparam) {
        this.callbackparam = callbackparam;
    }
}
