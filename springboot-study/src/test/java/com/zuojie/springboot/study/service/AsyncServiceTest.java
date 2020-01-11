package com.zuojie.springboot.study.service;

import com.zuojie.springboot.study.async.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AsyncServiceTest {
    @Autowired
    private AsyncService asyncService;
    @Test
    public void testAsyncProcess()throws InterruptedException{
        asyncService.asyncProcess();
        log.info("====");

    }
}
