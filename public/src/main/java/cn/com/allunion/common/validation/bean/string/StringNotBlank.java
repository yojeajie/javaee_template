package cn.com.allunion.common.validation.bean.string;

import cn.com.allunion.common.validation.bean.AbstractValidation;

/**
 * 字符串不为  null， 不为空字符串"" 不都为空格 验证
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/26.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class StringNotBlank extends AbstractValidation<String> {
    public StringNotBlank(String property, String errorTip) {
        this.object = property ;
        this.errorTip = errorTip ;
    }

    @Override
    public boolean validate() {
        return !(new StringBlank(object, errorTip).validate()) ;
    }
}
