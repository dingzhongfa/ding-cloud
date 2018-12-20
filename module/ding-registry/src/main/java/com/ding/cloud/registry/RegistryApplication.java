package com.ding.cloud.registry;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>
 *  euereka启动类
 * </p>
 * <p>Company: www.kktalkee.com</p>
 *
 * @author dingzhongfa
 * @date 2018-12-07 10:32
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistryApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RegistryApplication.class).run(args);
    }
}
