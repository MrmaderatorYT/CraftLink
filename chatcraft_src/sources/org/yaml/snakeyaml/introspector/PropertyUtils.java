package org.yaml.snakeyaml.introspector;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.yaml.snakeyaml.error.YAMLException;

/* loaded from: classes.dex */
public class PropertyUtils {
    private final Map<Class<?>, Map<String, Property>> propertiesCache = new HashMap();
    private final Map<Class<?>, Set<Property>> readableProperties = new HashMap();
    private BeanAccess beanAccess = BeanAccess.DEFAULT;
    private boolean allowReadOnlyProperties = false;

    protected Map<String, Property> getPropertiesMap(Class<?> cls, BeanAccess beanAccess) {
        if (this.propertiesCache.containsKey(cls)) {
            return this.propertiesCache.get(cls);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            for (Field field : superclass.getDeclaredFields()) {
                int modifiers = field.getModifiers();
                if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers) && !linkedHashMap.containsKey(field.getName())) {
                    linkedHashMap.put(field.getName(), new FieldProperty(field));
                }
            }
        }
        this.propertiesCache.put(cls, linkedHashMap);
        return linkedHashMap;
    }

    public Set<Property> getProperties(Class<? extends Object> cls) {
        return getProperties(cls, this.beanAccess);
    }

    public Set<Property> getProperties(Class<? extends Object> cls, BeanAccess beanAccess) {
        if (this.readableProperties.containsKey(cls)) {
            return this.readableProperties.get(cls);
        }
        Set<Property> setCreatePropertySet = createPropertySet(cls, beanAccess);
        this.readableProperties.put(cls, setCreatePropertySet);
        return setCreatePropertySet;
    }

    protected Set<Property> createPropertySet(Class<? extends Object> cls, BeanAccess beanAccess) {
        TreeSet treeSet = new TreeSet();
        for (Property property : getPropertiesMap(cls, beanAccess).values()) {
            if (property.isReadable() && (this.allowReadOnlyProperties || property.isWritable())) {
                treeSet.add(property);
            }
        }
        return treeSet;
    }

    public Property getProperty(Class<? extends Object> cls, String str) {
        return getProperty(cls, str, this.beanAccess);
    }

    public Property getProperty(Class<? extends Object> cls, String str, BeanAccess beanAccess) {
        Property property = getPropertiesMap(cls, beanAccess).get(str);
        if (property != null && property.isWritable()) {
            return property;
        }
        throw new YAMLException("Unable to find property '" + str + "' on class: " + cls.getName());
    }

    public void setBeanAccess(BeanAccess beanAccess) {
        if (this.beanAccess != beanAccess) {
            this.beanAccess = beanAccess;
            this.propertiesCache.clear();
            this.readableProperties.clear();
        }
    }

    public void setAllowReadOnlyProperties(boolean z) {
        if (this.allowReadOnlyProperties != z) {
            this.allowReadOnlyProperties = z;
            this.readableProperties.clear();
        }
    }
}
