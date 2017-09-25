package cn.com.allunion.common.fastjson;

import com.alibaba.fastjson.serializer.PropertyFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * 针对fastjson序列化时，接受指定名称的属性
 * 使用示例：
 *      JSON.toJSONString(obj, new ApplyPropertyFilter("propertyName1", "propertyName2"[,...])) ;
 * Created by YangJie on 2015/7/3.
 */
public class ApplyPropertyFilter implements PropertyFilter {
    /**
     * 要序列化的属性名称集合
     */
    private List<String> applyPropertis = null ;

    public ApplyPropertyFilter(String... propertyNames) {
        if(propertyNames.length > 0) {
            applyPropertis = new ArrayList<String>(propertyNames.length) ;

            for(String s : propertyNames) {
                applyPropertis.add(s) ;
            }
        }
    }

    @Override
    public boolean apply(Object object, String name, Object value) {
        if(null == applyPropertis) {
            return false ;
        }

        if(applyPropertis.contains(name)) {
            return true ;
        }

        return false ;
    }
}
