package cn.com.allunion.common.validation.bean.string;

import cn.com.allunion.common.validation.bean.AbstractValidation;

/**
 * 控制字符串校验
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/27.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class StringEmpty extends AbstractValidation<String> {
    public StringEmpty(String object, String errorTip) {
        super(object, errorTip);
    }

    @Override
    public boolean validate() {
        if (null == object || object.length() == 0) {
            return true ;
        }
        return false;
    }
}
