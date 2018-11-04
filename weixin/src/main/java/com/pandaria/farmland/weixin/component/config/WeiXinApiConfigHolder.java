package com.pandaria.farmland.weixin.component.config;

import com.pandaria.farmland.weixin.component.WeiXinApiConstants;
import com.pandaria.farmland.weixin.entity.AppConfigEntity;
import org.apache.commons.lang3.StringUtils;

public class WeiXinApiConfigHolder implements WeiXinApiConstants {

    private WeiXinApiConfigHolder() {}

    public static String getTokenApiUrl() {
        AppConfigEntity appConfigEntity = AppConfigHolder.getConfigObject();
        String appId = appConfigEntity.getAppId();
        String appSecret = appConfigEntity.getAppSecret();
        String url = TOKEN_API;
        url.replace(varForParameter(PARAM_APP_ID), appId);
        url.replace(varForParameter(PARAM_APP_SECRET), appSecret);
        return url;
    }

    public static String varForParameter(String paramName) {
        if (StringUtils.isBlank(paramName)) {
            return null;
        }
        return "${" + paramName + "}";
    }
}
