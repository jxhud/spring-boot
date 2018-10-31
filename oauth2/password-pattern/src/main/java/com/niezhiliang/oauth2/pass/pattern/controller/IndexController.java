package com.niezhiliang.oauth2.pass.pattern.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/10/26 下午4:11
 */
@RestController
@RequestMapping(value = "/")
public class IndexController {

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {
        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
        return "product id : " + id;
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id) {
        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
        return "order id : " + id;
    }
}
