package cn.com.allunion.common.validation.bean.date;

import cn.com.allunion.common.validation.bean.AbstractValidation;

import java.util.Date;

/**
 * 日期在给定条件日期之后 验证类
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/6/3.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class DateAfterValidation extends AbstractValidation<Date> {

    /**
     * 条件 date
     */
    private Date beforeDate;

    public DateAfterValidation(Date object, Date beforeDate, String errorTip) {
        super(object, errorTip);
        this.beforeDate = beforeDate;
    }

    @Override
    public boolean validate() {
        if (null == object || null == beforeDate) {
            return false ;
        }
        return object.after(beforeDate);
    }
}
