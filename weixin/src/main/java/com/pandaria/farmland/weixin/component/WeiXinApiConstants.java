package com.pandaria.farmland.weixin.component;

public interface WeiXinApiConstants {

    //    String APP_CONFIG_FILE = "weixin-api.properties";
    String PARAM_TIMESTAMP = "timestamp";
    String PARAM_NONCE = "nonce";
    String PARAM_SIGNATURE = "signature";
    String PARAM_ECHO_STR = "echostr";

    String PARAM_APP_ID = "APP_ID";
    String PARAM_APP_SECRET = "APP_SECRET";
    String PARAM_ACCESS_TOKEN = "ACCESS_TOKEN";

    String TOKEN_API = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=${APP_ID}&secret=${APP_SECRET}}";
    String GET_CALLBACK_IP_API = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=${ACCESS_TOKEN}";

    String GET_CURRENT_SELF_MENU_INFO_API = "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=${ACCESS_TOKEN}";
    String MENU_CREATE_API = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=${ACCESS_TOKEN}";
    String MENU_ADD_CONDITIONAL_API = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=${ACCESS_TOKEN}";
    String MENU_DELETE_API = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=${ACCESS_TOKEN}";
    String MENU_DELETE_CONDITIONAL_API = "https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=${ACCESS_TOKEN}";
    String MENU_GET_API = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=${ACCESS_TOKEN}";
    String MENU_TRY_MATCH_API = "https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=${ACCESS_TOKEN}";

    String MEDIA_UPLOAD_API = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=${ACCESS_TOKEN}&type=${TYPE}";
    String MEDIA_GET_API = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=${ACCESS_TOKEN}&media_id=${MEDIA_ID}";
    String MEDIA_UPLOAD_IMAGE_API = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=${ACCESS_TOKEN}";
    String MATERIAL_ADD_API = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=${ACCESS_TOKEN}";
    String MATERIAL_BATCH_GET_MATERIAL_API = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=${ACCESS_TOKEN}";
    String MATERIAL_GET_MATERIAL_API = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=${ACCESS_TOKEN}";
    String MATERIAL_DELETE_MATERIAL_API = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=${ACCESS_TOKEN}";
    String MATERIAL_GET_MATERIAL_COUNT_API = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=${ACCESS_TOKEN}";
    String MATERIAL_ADD_NEWS_API = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=${ACCESS_TOKEN}";
    String MATERIAL_UPDATE_NEWS_API = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=${ACCESS_TOKEN}";

    String TAGS_CREATE_API = "https://api.weixin.qq.com/cgi-bin/tags/create?access_token=${ACCESS_TOKEN}";
    String TAGS_DELETE_API = "https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=${ACCESS_TOKEN}";
    String TAGS_GET_API = "https://api.weixin.qq.com/cgi-bin/tags/get?access_token=${ACCESS_TOKEN}";
    String TAGS_UPDATE_API = "https://api.weixin.qq.com/cgi-bin/tags/update?access_token=${ACCESS_TOKEN}";
    String TAGS_MEMBERS_BATCH_TAGGING_API = "https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=${ACCESS_TOKEN}";
    String TAGS_MEMBERS_BATCH_UNTAGGING_API = "https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=${ACCESS_TOKEN}";
    String TAGS_MEMBERS_BATCH_BLACK_LISE_API = "https://api.weixin.qq.com/cgi-bin/tags/members/batchblacklist?access_token=${ACCESS_TOKEN}";
    String TAGS_MEMBERS_BATCH_UNBLACK_LISE_API = "https://api.weixin.qq.com/cgi-bin/tags/members/batchunblacklist?access_token=${ACCESS_TOKEN}";
    String TAGS_MEMBERS_GET_BLACK_LISE_API = "https://api.weixin.qq.com/cgi-bin/tags/members/getblacklist?access_token=${ACCESS_TOKEN}";

    String USER_TAG_GET_API = "https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=${ACCESS_TOKEN}";
    String USER_INFO_UPDATE_REMARK_API = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=${ACCESS_TOKEN}";
    String USER_INFO_API = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=${ACCESS_TOKEN}&openid=${OPENID}&lang=zh_CN";
    String USER_INFO_BATCH_GET_API = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=${ACCESS_TOKEN}";
    String USER_GET_API = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=${ACCESS_TOKEN}&next_openid=${NEXT_OPENID}";
    String OAUTH2_AUTHORIZE_API = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=${APPID}&redirect_uri=${REDIRECT_URI}&response_type=code&scope=${SCOPE}&state=${STATE}#wechat_redirect";
    String OAUTH2_ACCESS_TOKEN_API = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=${APPID}&secret=${SECRET}&code=${CODE}&grant_type=authorization_code";
    String SNS_OAUTH2_REFRESH_TOKEN_API = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=${APPID}&grant_type=refresh_token&refresh_token=${REFRESH_TOKEN}";
    String SNS_USER_INFO_API = "https://api.weixin.qq.com/sns/userinfo?access_token=${ACCESS_TOKEN}&openid=${OPENID}&lang=zh_CN";
    String SNS_AUTH_API = "https://api.weixin.qq.com/sns/auth?access_token=${ACCESS_TOKEN}&openid=${OPENID}";

    String QRCODE_CREATE_API = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=${TOKEN}";
    String SHOW_QRCODE_API = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=${TICKET}";
    String SHORT_URL_API = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=${ACCESS_TOKEN}";

    String TICKET_GET_TICKET_API = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=${ACCESS_TOKEN}&type=jsapi";

    String MESSAGE_MASS_SEND_ALL_API = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=${ACCESS_TOKEN}";
    String MESSAGE_MASS_SEND_API = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=${ACCESS_TOKEN}";
    String MESSAGE_MASS_DELETE_API ="https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=${ACCESS_TOKEN}";
    String MESSAGE_MASS_PREVIEW_API ="https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=${ACCESS_TOKEN}";
    String MESSAGE_MASS_GET_API = "https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=${ACCESS_TOKEN}";
    String MESSAGE_CUSTOM_SEND_API = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=${ACCESS_TOKEN}";
    String MESSAGE_CUSTOM_TYPING_API = "https://api.weixin.qq.com/cgi-bin/message/custom/typing?access_token=${ACCESS_TOKEN}";

    String PAY_UNIFIED_ORDER_API = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    String TEMPLATE_API_SET_INDUSTRY_API = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=${ACCESS_TOKEN}";
    String TEMPLATE_GET_INDUSTRY_API = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=${ACCESS_TOKEN}";
    String TEMPLATE_API_ADD_TEMPLATE_API = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=${ACCESS_TOKEN}";
    String TEMPLATE_GET_ALL_PRIVATE_TEMPLATE_API = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=${ACCESS_TOKEN}";
    String TEMPLATE_DELETE_PRIVATE_TEMPLATE_API = "https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=${ACCESS_TOKEN}";
    String TEMPLATE_SEND_API = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=${ACCESS_TOKEN}";

    String CUSTOMER_SERVICE_KF_ACCOUNT_ADD_API = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=${ACCESS_TOKEN}";
    String CUSTOMER_SERVICE_KF_ACCOUNT_UPDATE_API = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=${ACCESS_TOKEN}";
    String CUSTOMER_SERVICE_KF_ACCOUNT_DELETE_API = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=${ACCESS_TOKEN}";
    String CUSTOMER_SERVICE_KF_ACCOUNT_UPLOAD_HEAD_IMAGE_API = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=${ACCESS_TOKEN}&kf_account=${KFACCOUNT}";
    String CUSTOMER_SERVICE_GET_KF_LIST_API = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=${ACCESS_TOKEN}";
}
