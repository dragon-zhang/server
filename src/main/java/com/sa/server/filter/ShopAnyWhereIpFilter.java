package com.sa.server.filter;

import com.sa.server.config.properties.IpProperties;
import com.sa.server.util.IpUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author SuccessZhang
 * @date 2019.1.2
 */
@Slf4j
@Component
@ServletComponentScan
@RequiredArgsConstructor
public class ShopAnyWhereIpFilter implements Filter {

    private final IpProperties ipConfig;

    private static final String POINT = ".";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        List<String> excludeIPs = ipConfig.getExcludeIPs();
        if (req.getRequestURI().contains(POINT) && !req.getRequestURI().contains("index")) {
            chain.doFilter(request, response);
            return;
        }
        //yml中配置的过滤的ip黑名单
        for (String url : excludeIPs) {
            if (!req.getRequestURI().contains(url)) {
                chain.doFilter(request, response);
                return;
            }
        }
        //用户不在黑名单内，放行
        String ipAddress = IpUtil.getRealIP(req);
        log.info("there is a request from ip:" + ipAddress + ", to " + req.getRequestURL());
        req.setAttribute("ip", ipAddress);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
