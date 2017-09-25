package cn.com.allunion.common.validation.bean;

/**
 * 布尔条件 验证
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/6/3.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class BooleanValidation extends AbstractValidation<Boolean> {
    public BooleanValidation(Boolean object, String errorTip) {
        super(object, errorTip);
    }

    @Override
    public boolean validate() {
        return object;
    }
}
