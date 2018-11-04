package com.pandaria.farmland.weixin.component.config;

import com.pandaria.farmland.toolkits.utils.ResourceUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class ConfigHolder {

    private ConfigHolder() {}

    private volatile static ConcurrentHashMap<String, Properties> propMap = new ConcurrentHashMap<>();

    public static String get(Properties p, String key) {
        if (p == null || StringUtils.isBlank(key)) {
            return null;
        }
        return p.getProperty(key);
    }

    public static String get(String configFileName, String key) {
        if (StringUtils.isBlank(configFileName) || StringUtils.isBlank(key)) {
            return null;
        }

        Properties prop = propMap.get(configFileName);

        if (prop == null) {
            prop = ResourceUtil.readProperties(configFileName);
            if (prop == null) {
                return null;
            } else {
                propMap.put(configFileName, prop);
            }
        }
        return get(prop, key);
    }

    public static String get(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        ConcurrentHashMap.KeySetView<String, Properties> keySet = propMap.keySet();
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()) {
            String tmpKey = it.next();
            Properties prop = propMap.get(tmpKey);
            String value = get(prop, key);
            if (StringUtils.isNotBlank(value)) {
                return value;
            } else {
                continue;
            }
        }
        return null;
    }

}
