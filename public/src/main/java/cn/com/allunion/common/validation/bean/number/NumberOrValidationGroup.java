package cn.com.allunion.common.validation.bean.number;

import cn.com.allunion.common.validation.Validation;

/**
 * 数值验证类组合，验证条件之间是或的关系
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/27.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class NumberOrValidationGroup<T extends Number> extends NumberValidationGroup<T> {
    public NumberOrValidationGroup(T object) {
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
