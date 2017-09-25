package cn.com.allunion.common.enums;

/**
 * 性别枚举类
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/6/30.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public enum Gender {
    MALE {
        @Override
        public String getName() {
            return "男";
        }
    },
    FEMALE {
        @Override
        public String getName() {
            return "女";
        }
    },
    SECRECY {
        @Override
        public String getName() {
            return "保密";
        }
    };

    /**
     * 获取枚举代表意思
     * @return 枚举值代表意思
     */
    public abstract String getName();

    /**
     * 将字符串转化为Gender枚举对象
     * @param value 字符串参数
     * @return Gender枚举对象
     */
    public static Gender parseGender(String value) {
        if (MALE.toString().equals(value)) {
            return Gender.MALE;
        } else if (FEMALE.toString().equals(value)) {
            return FEMALE;
        } else {
            return null;
        }
    }
}