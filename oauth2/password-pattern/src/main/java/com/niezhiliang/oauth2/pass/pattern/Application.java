package com.niezhiliang.oauth2.pass.pattern;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/10/26 下午4:10
 */
@SpringBootApplication
@MapperScan(basePackages = "com.niezhiliang.oauth2.pass.pattern.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
