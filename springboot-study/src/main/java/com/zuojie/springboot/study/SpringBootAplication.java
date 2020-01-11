package com.zuojie.springboot.study;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <h1>应用程序启动类</h1>
 * 1.@EnableScheduling,允许当前应用开启定时任务
 * 2.@EnableAsync 开启异步任务支持
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class SpringBootAplication {
    public static void main(String[] args) {
        //1.通过静态的run方法启动
        SpringApplication.run(SpringBootAplication.class,args);
        /*SpringApplication application = new SpringApplication(SpringBootAplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);*/
    }
}
