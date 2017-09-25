package cn.com.allunion.common.fastjson;

import com.alibaba.fastjson.serializer.PropertyFilter;

/**
 * fastjson类库相关的工具集
 * Created by YangJie on 2015/7/3.
 */
public class FastjsonUtils {
    /**
     * 创建一个 fastjson序列化对象时，忽略对象属性的过滤器对象
     * 示例：
     *      JSON.toJSONString(obj, FastjsonUtils.newIgnorePropertyFilter("propName1", "propName2"[,...]))
     * @param ignorePropertiesName 序列化时要忽略的属性名称可变参数
     * @return 过滤器对象
     */
    public static PropertyFilter newIgnorePropertyFilter(String... ignorePropertiesName) {
        return new IgnorePropertyFilter(ignorePropertiesName) ;
    }

    /**
     * 创建一个 fastjson序列化对象时，只接受对象属性的过滤器对象
     * 示例：
     *      JSON.toJSONString(obj, FastjsonUtils.newApplyPropertyFilter("propName1", "propName2"[,...]))
     * @param applyPropertiesName 序列化时要接受的属性名称可变参数
     * @return 过滤器对象
     */
    public static PropertyFilter newApplyPropertyFilter(String... applyPropertiesName) {
        return new ApplyPropertyFilter(applyPropertiesName) ;
    }

}
