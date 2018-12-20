package com.ding.cloud.a2.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *
 * </p>
 * <p>Company: www.kktalkee.com</p>
 *
 * @author dingzhongfa
 * @date 2018-12-10 10:28
 */
@FeignClient("ding-a")
public interface AClient {

    @GetMapping("gray")
    Boolean getTrue(@RequestParam("id") Integer id);
}
