package cn.com.allunion.common.validation.bean;

import cn.com.allunion.common.validation.Validation;

/**
 * 验证类抽象实现
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/26.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public abstract class AbstractValidation<T> implements Validation {
    /**
     * 验证的对象
     */
    protected T object;
    /**
     * 验证未通过提示消息
     */
    protected String errorTip ;

    public AbstractValidation() {
    }

    public AbstractValidation(T object, String errorTip) {
        this.object = object;
        this.errorTip = errorTip;
    }

    @Override
    public String getErrorTip() {
        return errorTip;
    }

    public void setErrorTip(String errorTip) {
        this.errorTip = errorTip;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
