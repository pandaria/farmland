package com.pandaria.farmland.weixin.entity.weixin.request;

import com.pandaria.farmland.weixin.component.convertor.WeiXinMessageCDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("xml")
public class WeiXinImageMessageRequest extends WeiXinMessageRequestBase {

    @XStreamAlias("PicUrl")
    @XStreamConverter(value = WeiXinMessageCDataConverter.class)
    private String picUrl;

    @XStreamAlias("MediaId")
    @XStreamConverter(value = WeiXinMessageCDataConverter.class)
    private String mediaId;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
