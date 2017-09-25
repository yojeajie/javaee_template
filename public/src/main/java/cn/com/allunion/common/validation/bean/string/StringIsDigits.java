package cn.com.allunion.common.validation.bean.string;

import cn.com.allunion.common.validation.RegExpConstants;
import cn.com.allunion.common.validation.bean.AbstractValidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串为数字字符串
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/26.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class StringIsDigits extends AbstractValidation<String> {

    public StringIsDigits(String property, String errorTip) {
        this.object = property ;
        this.errorTip = errorTip ;
    }

    @Override
    public boolean validate() {
        if (null == object || object.length() == 0) {
            return false ;
        }

        Pattern pattern = Pattern.compile(RegExpConstants.REGEXP_DIGITS);
        Matcher matcher = pattern.matcher(object);
        return matcher.matches();
    }
}
