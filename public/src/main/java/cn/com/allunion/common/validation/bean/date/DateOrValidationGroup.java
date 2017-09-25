package cn.com.allunion.common.validation.bean.date;

import cn.com.allunion.common.validation.Validation;

import java.util.Date;

/**
 * 日期 验证类组合
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/6/3.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class DateOrValidationGroup extends DateValidationGroup {

    public DateOrValidationGroup(Date date) {
        super(date);
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
