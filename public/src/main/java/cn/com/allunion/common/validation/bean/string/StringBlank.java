package cn.com.allunion.common.validation.bean.string;

import cn.com.allunion.common.validation.bean.AbstractValidation;

/**
 * 字符串为  null， 为空字符串"" 都为空格 验证
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/31.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class StringBlank extends AbstractValidation<String> {
    public StringBlank(String property, String errorTip) {
        this.object = property ;
        this.errorTip = errorTip ;
    }

    @Override
    public boolean validate() {
        int strLen;
        if (object == null || (strLen = object.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(object.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
}
