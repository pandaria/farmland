package com.pandaria.farmland.toolkits.utils;

import com.google.common.io.Resources;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class ResourceUtil {
    private static Logger logger = LoggerFactory.getLogger(ResourceUtil.class);

    public static Properties readProperties(String filePath) {
        if (StringUtils.isBlank(filePath)) {
            return null;
        }
        Properties prop = null;
        try {
            URL url = Resources.getResource(filePath);
            File propFile = new File(url.toURI());
            prop = new Properties();
            prop.load(new FileReader(propFile));
            return prop;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
