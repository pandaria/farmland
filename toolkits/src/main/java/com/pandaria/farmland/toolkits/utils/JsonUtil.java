package com.pandaria.farmland.toolkits.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;

public class JsonUtil {

    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    public static String objectToString (Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();
        try {
            JsonGenerator jsonGenerator = objectMapper.getFactory().createGenerator(stringWriter);
            jsonGenerator.writeObject(obj);
            return stringWriter.toString();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }
    }

    public static <T> T stringToObject (String input, Class<T> classType) {
        if (StringUtils.isBlank(input) || classType == null) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            T result = objectMapper.readValue(input, classType);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }
    }

    public static <T> T fileToObject(String input, Class<T> classType) {
        if (StringUtils.isBlank(input) || classType == null) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource(input);

        try {
            T result = objectMapper.readValue(url, classType);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }
    }
}
