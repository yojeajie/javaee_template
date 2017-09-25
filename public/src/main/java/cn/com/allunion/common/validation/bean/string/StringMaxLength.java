package cn.com.allunion.common.validation.bean.string;

import cn.com.allunion.common.validation.bean.AbstractValidation;

/**
 * 字符串最大长度验证
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/26.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class StringMaxLength extends AbstractValidation<String> {

    /**
     * 长度
     */
    private int maxLength;

    public StringMaxLength(String property, int maxLength, String errorTip) {
        this.object = property ;
        this.maxLength = maxLength;
        this.errorTip = errorTip ;
    }

    @Override
    public boolean validate() {
        if (null != object) {
            return object.length() <= maxLength;
        }
        return false;
    }
}
