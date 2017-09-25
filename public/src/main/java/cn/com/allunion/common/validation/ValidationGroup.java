package cn.com.allunion.common.validation;

/**
 * 验证组接口
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/27.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public interface ValidationGroup extends Validation {
    /**
     * 设置验证未通过提示
     * @return 验证未通过提示
     */
    void setErrorTip(String errorTip) ;
}
