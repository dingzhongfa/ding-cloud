package com.ding.cloud.gateway;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * <p>
 *  网关启动类
 * </p>
 * <p>Company: www.kktalkee.com</p>
 *
 * @author dingzhongfa
 * @date 2018-12-07 10:32
 */
@SpringCloudApplication
@EnableZuulProxy
public class GatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(GatewayApplication.class).run(args);
    }
}
