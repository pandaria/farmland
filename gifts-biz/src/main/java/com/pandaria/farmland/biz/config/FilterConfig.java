package com.pandaria.farmland.biz.config;

import com.pandaria.farmland.weixin.component.filter.WeiXinSignatureCheckerFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean checkSignatureFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new WeiXinSignatureCheckerFilter());
        registration.addUrlPatterns("/wx/*");
        registration.setName("WeiXinSignatureCheckerFilter");
        registration.setEnabled(true);
        registration.setOrder(1);
        return registration;
    }
}
