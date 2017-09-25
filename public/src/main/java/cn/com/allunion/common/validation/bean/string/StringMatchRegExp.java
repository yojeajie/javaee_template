package cn.com.allunion.common.validation.bean.string;

import cn.com.allunion.common.validation.bean.AbstractValidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串匹配正则表达式
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/26.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class StringMatchRegExp extends AbstractValidation<String> {
    /**
     * 正则表达式
     */
    private String regExp ;

    public StringMatchRegExp(String object, String regExp, String errorTip) {
        this.object = object;
        this.regExp = regExp ;
        this.errorTip = errorTip ;
    }

    @Override
    public boolean validate() {
        if (null == object || object.length() == 0) {
            return false ;
        }

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(object);
        return matcher.matches();
    }
}
