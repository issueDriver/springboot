package com.zuojie.springboot.study.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/springboot")
public class Controller {

    @GetMapping("/conf_inject_1")
    public void firstConfInject(){
        log.info("first conf inject:{},{}");
    }
}
