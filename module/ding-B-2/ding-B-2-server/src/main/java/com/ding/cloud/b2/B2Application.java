package com.ding.cloud.b2;

import com.ding.cloud.a.client.AClient;
import com.ding.cloud.b.client.BClient;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>
 * B2模块启动类
 * </p>
 * <p>Company: www.kktalkee.com</p>
 *
 * @author dingzhongfa
 * @date 2018-12-07 14:00
 */
@SpringCloudApplication
@EnableFeignClients(basePackageClasses = {AClient.class, BClient.class})
public class B2Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(B2Application.class).run(args);
    }
}
