package cn.com.allunion.common.validation.bean.date;

import cn.com.allunion.common.validation.bean.AbstractValidation;

import java.util.Date;

/**
 * 日期在给定条件日期之前 验证类
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/6/3.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class DateBeforeValidation extends AbstractValidation<Date> {

    /**
     * 条件 date
     */
    private Date afterDate ;

    public DateBeforeValidation(Date object, Date afterDate, String errorTip) {
        super(object, errorTip);
        this.afterDate = afterDate;
    }

    @Override
    public boolean validate() {
        if (null == object || null == afterDate) {
            return false ;
        }
        return object.before(afterDate);
    }
}
