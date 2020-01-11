package com.zuojie.springboot.study.service;

import com.zuojie.springboot.service.ISplitService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SplitServletTest {
    @Resource
   private ISplitService iSplitService;

}
