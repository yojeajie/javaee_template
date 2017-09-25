package cn.com.allunion.common.validation.bean.string;

import cn.com.allunion.common.validation.bean.AbstractValidation;

/**
 * 字符串不能为null或者空字符串
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/26.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class StringNotEmpty extends AbstractValidation<String> {
    public StringNotEmpty(String property, String errorTip) {
        this.object = property ;
        this.errorTip = errorTip ;
    }

    @Override
    public boolean validate() {
        return !(object == null || object.length() == 0 || "".equals(object.trim())) ;
    }
}
