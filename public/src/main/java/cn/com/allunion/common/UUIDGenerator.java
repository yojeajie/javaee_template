package cn.com.allunion.common;

import java.util.UUID;

/**
 * UUID生成工具类
 * Created by YangJie on 2016/4/18.
 */
public class UUIDGenerator {
    /**
     * 随机生成UUID，生成UUID字符串中不包含 “-” 字符
     * @return UUID字符串
     */
    public static String generatorRandomUUID(){
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        return uuid.replaceAll("-", "");
    }
}
