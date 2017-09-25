package cn.com.allunion.common;

/**
 * 字符串工具类
 * @author YangJie
 *
 */
public class TextUtils {
    /**
	 * 判断字符串是否为null，或者为空字符串（trim()之后）
	 */
	public static boolean isNullOrEmpty(String value) {
		return null == value || "".equals(value.trim()) ;
	}


	/**
	 * 给指定的字符串前面补零
	 * @param length 补零后的长度
	 * @param source 需要补零的长符串
	 * @return 补零后的字符串
	 */
    public static String fillZero(int length, String source) {//7
		StringBuilder result = new StringBuilder(source);
		for(int i=result.length(); i<length ; i++){
			result.insert(0, '0');
		}
		return result.toString();
	}
}