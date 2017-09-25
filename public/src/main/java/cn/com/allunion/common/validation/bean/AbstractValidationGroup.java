package cn.com.allunion.common.validation.bean;

import cn.com.allunion.common.validation.Validation;
import cn.com.allunion.common.validation.ValidationGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证组类抽象实现
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/27.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public abstract class AbstractValidationGroup implements ValidationGroup {
    /**
     * 验证对象集合
     */
    protected List<Validation> validationList = new ArrayList<>();

    /**
     * 验证未通过提示消息
     */
    protected String errorTip ;

    @Override
    public String getErrorTip() {
        return errorTip;
    }

    @Override
    public void setErrorTip(String errorTip) {
        this.errorTip = errorTip;
    }
}
