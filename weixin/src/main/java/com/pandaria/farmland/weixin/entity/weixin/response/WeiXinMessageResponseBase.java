package com.pandaria.farmland.weixin.entity.weixin.response;

import com.pandaria.farmland.weixin.component.convertor.WeiXinMessageCDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

public class WeiXinMessageResponseBase {

    @XStreamAlias("ToUserName")
    @XStreamConverter(value = WeiXinMessageCDataConverter.class)
    private String toUserName;

    @XStreamAlias("FromUserName")
    @XStreamConverter(value = WeiXinMessageCDataConverter.class)
    private String fromUserName;

    @XStreamAlias("CreateTime")
    private Long createTime;

    @XStreamAlias("MsgType")
    @XStreamConverter(value = WeiXinMessageCDataConverter.class)
    private String msgType;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
