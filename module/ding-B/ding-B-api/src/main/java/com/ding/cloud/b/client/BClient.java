package com.ding.cloud.b.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *
 * </p>
 * <p>Company: www.kktalkee.com</p>
 *
 * @author dingzhongfa
 * @date 2018-12-10 10:36
 */
@FeignClient("ding-b")
public interface BClient {

    @GetMapping("gray")
    Boolean getTrue(@RequestParam("id") Integer id);

}
