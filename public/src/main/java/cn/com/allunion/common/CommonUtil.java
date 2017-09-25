package cn.com.allunion.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 公共工具类
 * @author zhang.xu
 * @email zhang.xu@all-union.com.cn
 * @date 2017/1/5
 */
public class CommonUtil {
    /**
     * 生成指定位数的随机数
     * @param length
     * @return
     */
    public static String getRndNum(int length){
        String s="";
        for(int i=0;i<length;i++){
            s+=new Random().nextInt(10);
        }
        return s;
    }

    public static List<NameValuePair> exchangeJSONHttpValuePair(String jsonStr)throws JSONException {
        JSONObject jsonObj = JSON.parseObject(jsonStr);
        return exchangeJSONHttpValuePair(jsonObj);
    }
    public static List<NameValuePair> exchangeJSONHttpValuePair(JSONObject json)throws JSONException {
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        for (Map.Entry<String, Object> entry : json.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            parameters.add(new BasicNameValuePair(key,value));
        }
        return parameters;
    }

    public static void main(String[] args){
       System.out.println(getRndNum(6));
    }

}
