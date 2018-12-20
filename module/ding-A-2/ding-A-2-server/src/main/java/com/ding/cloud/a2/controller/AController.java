package com.ding.cloud.a2.controller;

import com.ding.cloud.b.client.BClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 * <p>Company: www.kktalkee.com</p>
 *
 * @author dingzhongfa
 * @date 2018-12-07 14:44
 */
@RestController
@RequestMapping("gray")
public class AController {


    private static final Logger logger = LoggerFactory.getLogger(AController.class);

    @Resource
    private BClient bClient;

    @GetMapping
    public Boolean getTrue(@RequestParam("id") Integer id){
        logger.info("server A ==>  id  : {}  value  :  {}", id, false);
        return bClient.getTrue(id);
    }

}
