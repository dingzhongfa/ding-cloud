package com.ding.cloud.gateway.filter;

import com.ding.cloud.gray.support.RibbonFilterContextHolder;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static com.ding.cloud.gray.constant.GrayConstants.GRAY_KEY;
import static com.netflix.zuul.context.RequestContext.getCurrentContext;

/**
 * <p>
 *
 * </p>
 * <p>Company: www.kktalkee.com</p>
 *
 * @author dingzhongfa
 * @date 2018-12-10 11:47
 */
@Component
public class GrayFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = getCurrentContext();
        final HttpServletRequest httpServletRequest = requestContext.getRequest();
        //灰度示例
        RibbonFilterContextHolder.clearCurrentContext();
        String version = httpServletRequest.getParameter("id");
        if (version != null && !StringUtils.isEmpty(version)) {
            RibbonFilterContextHolder.getCurrentContext().add(GRAY_KEY, version);
            requestContext.addZuulRequestHeader(GRAY_KEY,version);
        }
        return null;
    }
}
