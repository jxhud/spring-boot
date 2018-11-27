package com.niezhiliang.logger.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/27 下午4:31
 */
@RestController
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "index")
    public String index() {
        logger.info(new Date().toString());
        logger.warn("this warm logger");
        logger.error("this error logger");
        return null;
    }
}
