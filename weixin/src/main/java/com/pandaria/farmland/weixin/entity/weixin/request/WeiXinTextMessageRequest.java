package com.pandaria.farmland.weixin.entity.weixin.request;

import com.pandaria.farmland.weixin.component.convertor.WeiXinMessageCDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("xml")
public class WeiXinTextMessageRequest extends WeiXinMessageRequestBase {

    @XStreamAlias("Content")
    @XStreamConverter(value = WeiXinMessageCDataConverter.class)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
