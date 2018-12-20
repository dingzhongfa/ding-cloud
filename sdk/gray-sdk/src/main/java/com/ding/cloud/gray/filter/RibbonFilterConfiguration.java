package com.ding.cloud.gray.filter;

import com.netflix.zuul.ZuulFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 * <p>Company: www.kktalkee.com</p>
 *
 * @author dingzhongfa
 * @date 2018-12-11 10:33
 */
@Configuration
public class RibbonFilterConfiguration {

    @Bean
    @ConditionalOnMissingBean(ZuulFilter.class)
    public RibbonGrayFilter ribbonGrayFilter(){
        return new RibbonGrayFilter();
    }
}
