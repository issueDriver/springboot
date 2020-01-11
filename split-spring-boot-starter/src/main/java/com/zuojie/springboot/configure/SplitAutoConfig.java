package com.zuojie.springboot.configure;

import com.zuojie.springboot.service.ISplitService;
import com.zuojie.springboot.service.impl.SplitServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(value = {ISplitService.class, SplitServiceImpl.class})
public class SplitAutoConfig {
    @Bean
    @ConditionalOnMissingBean
    ISplitService starterService(){
        return new SplitServiceImpl();
    }
}
