package cn.com.allunion.common.validation;

/**
 * 验证接口
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/26.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public interface Validation {
    /**
     * 验证方法
     * @return 验证通过返回true，否者返回false
     */
    boolean validate() ;

    /**
     * 获取错误提示，当验证失败后，可以调用该方法
     * @return 错误提示
     */
    String getErrorTip() ;
}
