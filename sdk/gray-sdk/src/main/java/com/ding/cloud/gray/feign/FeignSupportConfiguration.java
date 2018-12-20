package com.ding.cloud.gray.feign;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 * <p>Company: www.kktalkee.com</p>
 *
 * @author dingzhongfa
 * @date 2018-12-11 16:55
 */
@Configuration
public class FeignSupportConfiguration {

    /**
     * feign请求拦截器
     *
     * @return
     */
    @Bean
    public RequestInterceptor requestInterceptor(){
        return new FeignGrayRequestInterceptor();
    }

}
