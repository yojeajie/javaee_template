package cn.com.allunion.common.handler;

import org.springframework.core.Conventions;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 请求封装对象
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/12.
 * @copyright http://www.all-union.com.cn/
 */
public class Request extends LinkedHashMap<String, Object> {
    /**
     * 请求类型标识
     */
    private String mark ;

    /**
     * Construct a new, empty {@code Request}.
     */
    public Request() {
    }

    /**
     * Construct a new {@code Request} containing the supplied attribute
     * under the supplied name.
     * @see #addAttribute(String, Object)
     */
    public Request(String attributeName, Object attributeValue) {
        addAttribute(attributeName, attributeValue);
    }

    /**
     * Construct a new {@code Request} containing the supplied attribute.
     * Uses attribute name generation to generate the key for the supplied model
     * object.
     * @see #addAttribute(Object)
     */
    public Request(Object attributeValue) {
        addAttribute(attributeValue);
    }


    /**
     * Add the supplied attribute under the supplied name.
     * @param attributeName the name of the model attribute (never {@code null})
     * @param attributeValue the model attribute value (can be {@code null})
     */
    public Request addAttribute(String attributeName, Object attributeValue) {
        Assert.notNull(attributeName, "Model attribute name must not be null");
        put(attributeName, attributeValue);
        return this;
    }

    /**
     * Add the supplied attribute to this {@code Map} using a
     * {@link Conventions#getVariableName generated name}.
     * <p><emphasis>Note: Empty {@link Collection Collections} are not added to
     * the model when using this method because we cannot correctly determine
     * the true convention name. View code should check for {@code null} rather
     * than for empty collections as is already done by JSTL tags.</emphasis>
     * @param attributeValue the model attribute value (never {@code null})
     */
    public Request addAttribute(Object attributeValue) {
        Assert.notNull(attributeValue, "Model object must not be null");
        if (attributeValue instanceof Collection && ((Collection<?>) attributeValue).isEmpty()) {
            return this;
        }
        return addAttribute(Conventions.getVariableName(attributeValue), attributeValue);
    }

    /**
     * Copy all attributes in the supplied {@code Collection} into this
     * {@code Map}, using attribute name generation for each element.
     * @see #addAttribute(Object)
     */
    public Request addAllAttributes(Collection<?> attributeValues) {
        if (attributeValues != null) {
            for (Object attributeValue : attributeValues) {
                addAttribute(attributeValue);
            }
        }
        return this;
    }

    /**
     * Copy all attributes in the supplied {@code Map} into this {@code Map}.
     * @see #addAttribute(String, Object)
     */
    public Request addAllAttributes(Map<String, ?> attributes) {
        if (attributes != null) {
            putAll(attributes);
        }
        return this;
    }

    /**
     * Copy all attributes in the supplied {@code Map} into this {@code Map},
     * with existing objects of the same name taking precedence (i.e. not getting
     * replaced).
     */
    public Request mergeAttributes(Map<String, ?> attributes) {
        if (attributes != null) {
            for (Map.Entry<String, ?> entry : attributes.entrySet()) {
                String key = entry.getKey();
                if (!containsKey(key)) {
                    put(key, entry.getValue());
                }
            }
        }
        return this;
    }

    /**
     * Does this model contain an attribute of the given name?
     * @param attributeName the name of the model attribute (never {@code null})
     * @return whether this model contains a corresponding attribute
     */
    public boolean containsAttribute(String attributeName) {
        return containsKey(attributeName);
    }



    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
