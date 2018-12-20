package com.ding.cloud.b2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
public class BController {


    private Logger logger = LoggerFactory.getLogger(BController.class);

    @GetMapping
    public Boolean getTrue(@RequestParam("id") Integer id){
        logger.info("server B ==>  id  : {}  value  :  {}", id, false);
        return false;
    }

}
