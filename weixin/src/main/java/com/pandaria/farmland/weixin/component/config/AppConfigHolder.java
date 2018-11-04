package com.pandaria.farmland.weixin.component.config;

import com.pandaria.farmland.toolkits.utils.JsonUtil;
import com.pandaria.farmland.weixin.component.AppConstants;
import com.pandaria.farmland.weixin.entity.AppConfigEntity;

public class AppConfigHolder implements AppConstants {

    private static volatile AppConfigEntity appConfigEntity;

    private AppConfigHolder() { }

    public static AppConfigEntity getConfigObject() {
        if (appConfigEntity == null) {
            synchronized (AppConfigHolder.class) {
                if (appConfigEntity == null) {
                    appConfigEntity = new AppConfigEntity();
                    appConfigEntity.setAppId(get(APP_ID_KEY));
                    appConfigEntity.setAppSecret(get(APP_SECRET_KEY));
                    appConfigEntity.setEncodingAESKey(get(ENCODING_AES_KEY));
                    appConfigEntity.setToken(get(TOKEN_KEY));
                    appConfigEntity.setApiKey(get(API_KEY));
                    appConfigEntity.setMerchantId(get(MERCHANT_ID_KEY));
                }
            }
        }
        return appConfigEntity;
    }

    public static String get(String key) {
        return ConfigHolder.get(APP_CONFIG_FILE,key);
    }
}
