package cn.com.allunion.common.validation;

/**
 * 正则表达式常亮工具类
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/27.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class RegExpConstants {
    /**
     * 邮箱正则表达式
     */
    public static final String REGEXP_EMAIL = "^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$" ;

    /**
     * 中文正则表达式
     */
    public static final String REGEXP_CHINESE = "^[\\u4e00-\\u9fa5]{0,}$" ;

    /**
     * 字符串为数值，负数和小数 正则表达式
     */
    public final static String REGEXP_NUMBER = "^(?:-?\\d+|-?\\d{1,3}(?:,\\d{3})+)?(?:\\.\\d+)?$" ;

    /**
     * 字符串为整数 正则表达式
     */
    public final static String REGEXP_DIGITS = "^\\d+$" ;

    /**
     * 字符串为整数 正则表达式
     */
    public final static String REGEXP_PHONE = "^1[3|4|5|7|8]\\d{9}$" ;

    /**
     * IP v4
     */
    public final static String REGEXP_IP_V4 = "\\\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\\\b" ;
}
