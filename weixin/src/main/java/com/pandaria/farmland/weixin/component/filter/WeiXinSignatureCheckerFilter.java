package com.pandaria.farmland.weixin.component.filter;

import com.pandaria.farmland.toolkits.utils.CryptUtil;
import com.pandaria.farmland.weixin.component.AppConstants;
import com.pandaria.farmland.weixin.component.WeiXinApiConstants;
import com.pandaria.farmland.weixin.component.config.AppConfigHolder;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import java.io.IOException;
import java.util.Arrays;

public class WeiXinSignatureCheckerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = AppConfigHolder.get(AppConstants.TOKEN_KEY);
        String timestamp = request.getParameter(WeiXinApiConstants.PARAM_TIMESTAMP);
        String nonce = request.getParameter(WeiXinApiConstants.PARAM_NONCE);
        String signature = request.getParameter(WeiXinApiConstants.PARAM_SIGNATURE);
        String echoStr = request.getParameter(WeiXinApiConstants.PARAM_ECHO_STR);
        String sha1 = sortAndSha1(token, timestamp, nonce);
        if (StringUtils.isNotBlank(signature) && StringUtils.isNotBlank(sha1)) {
            if (signature.equals(sha1)) {
                //continue
            } else {
                return;
            }
        }
    }

    @Override
    public void destroy() {

    }

    private String sortAndSha1(String... args) {
        Arrays.sort(args);
        String sha1 = CryptUtil.sha1Hex(args);
        return sha1;
    }
}
