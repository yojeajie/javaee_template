package cn.com.allunion.common.validation.bean;

import cn.com.allunion.common.validation.Validation;

/**
 * 验证对象不为null
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/26.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class NotNull implements Validation {
    /**
     * 要验证的属性
     */
    private Object object;

    /**
     * 错误提示信息
     */
    private String errorTip ;

    public NotNull(Object object, String errorTip) {
        this.object = object;
        this.errorTip = errorTip ;
    }

    @Override
    public boolean validate() {
        return object != null;
    }

    @Override
    public String getErrorTip() {
        return errorTip;
    }
}
