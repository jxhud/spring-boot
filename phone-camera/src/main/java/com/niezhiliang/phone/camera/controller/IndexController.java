package com.niezhiliang.phone.camera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/10 上午11:08
 */
@Controller
public class IndexController {

    @RequestMapping(value = "index")
    public String carmera() {
        return "carmera.html";
    }
}
