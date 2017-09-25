package cn.com.allunion.common.validation.bean.string;

import cn.com.allunion.common.validation.RegExpConstants;
import cn.com.allunion.common.validation.bean.AbstractValidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串为数值，负数和小数
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/26.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class StringIsNumber extends AbstractValidation<String> {

    public StringIsNumber(String property, String errorTip) {
        this.object = property ;
        this.errorTip = errorTip ;
    }

    @Override
    public boolean validate() {
        if (null == object || object.length() == 0) {
            return false ;
        }

        Pattern pattern = Pattern.compile(RegExpConstants.REGEXP_NUMBER);
        Matcher matcher = pattern.matcher(object);
        return matcher.matches();
    }
}
