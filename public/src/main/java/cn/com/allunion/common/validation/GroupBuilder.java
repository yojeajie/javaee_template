package cn.com.allunion.common.validation;

import cn.com.allunion.common.validation.bean.number.NumberOrValidationGroup;
import cn.com.allunion.common.validation.bean.number.NumberValidationGroup;
import cn.com.allunion.common.validation.bean.string.StringOrValidationGroup;
import cn.com.allunion.common.validation.bean.string.StringValidationGroup;
import cn.com.allunion.common.validation.bean.date.DateOrValidationGroup;
import cn.com.allunion.common.validation.bean.date.DateValidationGroup;

import java.util.Date;

/**
 * 验证组 构建工具类
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/27.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class GroupBuilder {
    /**
     * 构建 字符串验证组，各验证之间是与的关系
     * @param object 要验证的字符串对象
     * @return 字符串验证对象组
     */
    public static StringValidationGroup build(String object) {
        StringValidationGroup group = new StringValidationGroup(object);
        return group ;
    }

    /**
     * 构建 字符串验证组，各验证之间是或的关系
     * @param object 要验证的字符串对象
     * @return 字符串验证对象组
     */
    public static StringValidationGroup buildOr(String object) {
        StringValidationGroup group = new StringOrValidationGroup(object);
        return group ;
    }

    /**
     * 构建 Byte类型数值验证组，各验证之间是或的关系
     * @param object 要验证的数值对象
     * @return 数值验证对象组
     */
    public static NumberValidationGroup<Byte> buildOr(Byte object) {
        NumberValidationGroup<Byte> group = new NumberOrValidationGroup<Byte>(object) ;
        return group ;
    }

    /**
     * 构建 Short类型数值验证组，各验证之间是或的关系
     * @param object 要验证的数值对象
     * @return 数值验证对象组
     */
    public static NumberValidationGroup<Short> buildOr(Short object) {
        NumberValidationGroup<Short> group = new NumberOrValidationGroup<Short>(object) ;
        return group ;
    }

    /**
     * 构建 Integer类型数值验证组，各验证之间是或的关系
     * @param object 要验证的数值对象
     * @return 数值验证对象组
     */
    public static NumberValidationGroup<Integer> buildOr(Integer object) {
        NumberValidationGroup<Integer> group = new NumberOrValidationGroup<Integer>(object) ;
        return group ;
    }

    /**
     * 构建 Long类型数值验证组，各验证之间是或的关系
     * @param object 要验证的数值对象
     * @return 数值验证对象组
     */
    public static NumberValidationGroup<Long> buildOr(Long object) {
        NumberValidationGroup<Long> group = new NumberOrValidationGroup<Long>(object) ;
        return group ;
    }

    /**
     * 构建 Float类型数值验证组，各验证之间是或的关系
     * @param object 要验证的数值对象
     * @return 数值验证对象组
     */
    public static NumberValidationGroup<Float> buildOr(Float object) {
        NumberValidationGroup<Float> group = new NumberOrValidationGroup<Float>(object) ;
        return group ;
    }

    /**
     * 构建 Double类型数值验证组，各验证之间是或的关系
     * @param object 要验证的数值对象
     * @return 数值验证对象组
     */
    public static NumberValidationGroup<Double> buildOr(Double object) {
        NumberValidationGroup<Double> group = new NumberOrValidationGroup<Double>(object) ;
        return group ;
    }

    /**
     * 构建 Byte类型数值验证组，各验证之间是与的关系
     * @param object 要验证的数值对象
     * @return 数值验证对象组
     */
    public static NumberValidationGroup<Byte> build(Byte object) {
        NumberValidationGroup<Byte> group = new NumberValidationGroup<Byte>(object) ;
        return group ;
    }

    /**
     * 构建 Short类型数值验证组，各验证之间是与的关系
     * @param object 要验证的数值对象
     * @return 数值验证对象组
     */
    public static NumberValidationGroup<Short> build(Short object) {
        NumberValidationGroup<Short> group = new NumberValidationGroup<Short>(object) ;
        return group ;
    }

    /**
     * 构建 Integer类型数值验证组，各验证之间是与的关系
     * @param object 要验证的数值对象
     * @return 数值验证对象组
     */
    public static NumberValidationGroup<Integer> build(Integer object) {
        NumberValidationGroup<Integer> group = new NumberValidationGroup<Integer>(object) ;
        return group ;
    }

    /**
     * 构建 Long类型数值验证组，各验证之间是与的关系
     * @param object 要验证的数值对象
     * @return 数值验证对象组
     */
    public static NumberValidationGroup<Long> build(Long object) {
        NumberValidationGroup<Long> group = new NumberValidationGroup<Long>(object) ;
        return group ;
    }

    /**
     * 构建 Float类型数值验证组，各验证之间是与的关系
     * @param object 要验证的数值对象
     * @return 数值验证对象组
     */
    public static NumberValidationGroup<Float> build(Float object) {
        NumberValidationGroup<Float> group = new NumberValidationGroup<Float>(object) ;
        return group ;
    }

    /**
     * 构建 Double类型数值验证组，各验证之间是与的关系
     * @param object 要验证的数值对象
     * @return 数值验证对象组
     */
    public static NumberValidationGroup<Double> build(Double object) {
        NumberValidationGroup<Double> group = new NumberValidationGroup<Double>(object) ;
        return group ;
    }

    /**
     * 构建 日期对象 验证组，各验证之间是与的关系
     * @param object 要验证的日期对象
     * @return 字符串验证对象组
     */
    public static DateValidationGroup build(Date object) {
        DateValidationGroup group = new DateValidationGroup(object);
        return group ;
    }

    /**
     * 构建 日期对象 验证组，各验证之间是或的关系
     * @param object 要验证的日期对象
     * @return 字符串验证对象组
     */
    public static DateValidationGroup buildOr(Date object) {
        DateValidationGroup group = new DateOrValidationGroup(object);
        return group ;
    }
}
