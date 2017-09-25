package cn.com.allunion.common.validation.bean.string;

import cn.com.allunion.common.validation.bean.AbstractValidation;

/**
 * 字符串最小长度验证
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/26.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class StringMinLength extends AbstractValidation<String> {

    /**
     * 长度
     */
    private int minLength ;

    public StringMinLength(String property, int minLength, String errorTip) {
        this.object = property ;
        this.minLength = minLength ;
        this.errorTip = errorTip ;
    }

    @Override
    public boolean validate() {
        if (null != object) {
            return object.length() >= minLength ;
        }
        return false;
    }
}
