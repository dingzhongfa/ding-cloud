package com.ding.cloud.gray.filter;

import com.ding.cloud.gray.support.RibbonFilterContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.ding.cloud.gray.constant.GrayConstants.GRAY_KEY;

/**
 * <p>
 *
 * </p>
 * <p>Company: www.kktalkee.com</p>
 *
 * @author dingzhongfa
 * @date 2018-12-11 10:24
 */
public class RibbonGrayFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(RibbonGrayFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("RibbonGrayFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String gatedLaunch = httpServletRequest.getHeader(GRAY_KEY);
        if (gatedLaunch != null) {
            RibbonFilterContextHolder.clearCurrentContext();
            RibbonFilterContextHolder.getCurrentContext().add(GRAY_KEY, gatedLaunch);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("RibbonGrayFilter destroy");
    }
}
