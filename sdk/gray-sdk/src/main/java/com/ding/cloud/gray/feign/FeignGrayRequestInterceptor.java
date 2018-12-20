package com.ding.cloud.gray.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

import static com.ding.cloud.gray.constant.GrayConstants.GRAY_KEY;

/**
 * <p>
 *
 * </p>
 * <p>Company: www.kktalkee.com</p>
 *
 * @author dingzhongfa
 * @date 2018-12-11 16:23
 */
public class FeignGrayRequestInterceptor implements RequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(FeignGrayRequestInterceptor.class);

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String value = request.getHeader(GRAY_KEY);
        if (value != null) {
            requestTemplate.header(GRAY_KEY, value);
            logger.info("feign interceptor header:{}", requestTemplate);
        }
    }
}
