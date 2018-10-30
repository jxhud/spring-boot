package com.niezhiliang.oauth.client.credentials.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/10/29 下午8:06
 */
@RestController
public class IndexController {

    /**
     * 这个方法访问不需要access_token
     * @return
     */
    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello oauth2.0 client_credentitals";
    }


    /**
     * 这个方法是收保护的 必须带正确的access_token才能请求
     * @return
     */
    @RequestMapping(value = "/index")
    public String index() {
        return "this method is protected by oauth2.0.";
    }
}
