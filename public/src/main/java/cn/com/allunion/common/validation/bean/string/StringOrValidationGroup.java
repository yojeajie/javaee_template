package cn.com.allunion.common.validation.bean.string;

import cn.com.allunion.common.validation.Validation;

/**
 * 符串验证类组合，验证条件之间是或的关系
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/27.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class StringOrValidationGroup extends StringValidationGroup {
    public StringOrValidationGroup(String object) {
        super(object);
    }

    @Override
    public boolean validate() {
        if (validationList.size() > 0) {
            for (Validation v : validationList) {
                if (v.validate()) {
                    return true ;
                }
            }
            return false;
        }

        return true ;
    }
}
