package cn.com.allunion.common.fastjson;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * fastjson java.util.Date 类型反序列化扩展类
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/7/21.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public class ExtDateFormatDeserializer extends AbstractDateDeserializer {
  
    private String dateFormat;

    public ExtDateFormatDeserializer(String dateFormat) {
        super();
        this.dateFormat = dateFormat;
    }

    @Override
    protected <T> T cast(DefaultJSONParser parser, java.lang.reflect.Type clazz, Object fieldName, Object value) {
        if (dateFormat == null) {
            return null;
        }
        if (value instanceof String) {
            String strVal = (String) value;
            if (strVal.length() == 0) {
                return null;
            }

            try {
                return (T) new SimpleDateFormat(dateFormat).parse((String)value);
            } catch (ParseException e) {
            }
        }
        throw new JSONException("parse string to date object error, dateFormat: " + dateFormat
                + ", fieldName: " + fieldName + ", value: " + value);
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}