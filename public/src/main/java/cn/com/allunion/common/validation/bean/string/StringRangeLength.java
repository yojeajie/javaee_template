package cn.com.allunion.common.validation.bean.string;

import cn.com.allunion.common.validation.bean.AbstractValidation;

/**
 * 字符串长度区间验证
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/26.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class StringRangeLength extends AbstractValidation<String> {

    /**
     * 下限长度
     */
    private int lowerLimitLength ;

    /**
     * 上限长度
     */
    private int upperLimitLength ;

    public StringRangeLength(String property, int lowerLimitLength, int upperLimitLength, String errorTip) {
        this.object = property ;
        this.lowerLimitLength = lowerLimitLength;
        this.upperLimitLength = upperLimitLength;
        this.errorTip = errorTip ;
    }

    @Override
    public boolean validate() {
        if (null != object) {
            return object.length() >= lowerLimitLength && object.length() <= upperLimitLength ;
        }
        return false;
    }
}
