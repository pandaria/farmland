package com.pandaria.farmland.weixin.entity.weixin.response;

import com.pandaria.farmland.weixin.component.convertor.WeiXinMessageCDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("xml")
public class WeiXinTextImageMixedMessageResponse extends WeiXinMessageResponseBase {

    @XStreamAlias("ArticleCount")
    protected int articleCount;

    @XStreamAlias("Articles")
    protected final List<Item> articles = new ArrayList<Item>();

    @XStreamAlias("Title")
    @XStreamConverter(value = WeiXinMessageCDataConverter.class)
    private String title;

    @XStreamAlias("Description")
    @XStreamConverter(value = WeiXinMessageCDataConverter.class)
    private String description;

    @XStreamAlias("Url")
    @XStreamConverter(value = WeiXinMessageCDataConverter.class)
    private String url;

    @XStreamAlias("PicUrl")
    @XStreamConverter(value = WeiXinMessageCDataConverter.class)
    private String picUrl;

    @XStreamAlias("item")
    public static class Item {

        @XStreamAlias("Title")
        @XStreamConverter(value = WeiXinMessageCDataConverter.class)
        private String Title;

        @XStreamAlias("Description")
        @XStreamConverter(value = WeiXinMessageCDataConverter.class)
        private String Description;

        @XStreamAlias("PicUrl")
        @XStreamConverter(value = WeiXinMessageCDataConverter.class)
        private String PicUrl;

        @XStreamAlias("Url")
        @XStreamConverter(value = WeiXinMessageCDataConverter.class)
        private String Url;

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String description) {
            Description = description;
        }

        public String getPicUrl() {
            return PicUrl;
        }

        public void setPicUrl(String picUrl) {
            PicUrl = picUrl;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String url) {
            Url = url;
        }

    }

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public List<Item> getArticles() {
        return articles;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
