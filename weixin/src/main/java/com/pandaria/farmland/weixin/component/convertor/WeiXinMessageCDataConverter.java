package com.pandaria.farmland.weixin.component.convertor;

import com.thoughtworks.xstream.converters.basic.StringConverter;

public class WeiXinMessageCDataConverter extends StringConverter {

    @Override
    public String toString(Object obj) {
        return "<![CDATA[" + super.toString(obj) + "]]>";
    }

}
