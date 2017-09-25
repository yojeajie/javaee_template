package cn.com.allunion.common.fastjson;

import com.alibaba.fastjson.serializer.PropertyFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * 针对fastjson序列化时，过滤忽略属性
 * 使用示例：
 *      JSON.toJSONString(obj, new IgnorePropertyFilter("propertyName1", "propertyName2"[,...])) ;
 * Created by YangJie on 2015/7/3.
 */
public class IgnorePropertyFilter implements PropertyFilter {
    /**
     * 要忽略的属性名称集合
     */
    private List<String> ignorePropertis = null ;

    public IgnorePropertyFilter(String... propertyNames) {
        if(propertyNames.length > 0) {
            ignorePropertis = new ArrayList<String>(propertyNames.length) ;

            for(String s : propertyNames) {
                ignorePropertis.add(s) ;
            }
        }
    }

    @Override
    public boolean apply(Object object, String name, Object value) {
        if(null == ignorePropertis) {
            return true ;
        }

        if(ignorePropertis.contains(name)) {
            return false ;
        }

        return true ;
    }
}
