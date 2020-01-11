package com.zuojie.springboot.study.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@Configuration
public class AsyncPoolConfig implements AsyncConfigurer {
    @Bean
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor excutor = new ThreadPoolTaskExecutor();
        excutor.setCorePoolSize(10);
        excutor.setMaxPoolSize(20);
        excutor.setQueueCapacity(20);
        excutor.setKeepAliveSeconds(60);
        excutor.setThreadNamePrefix("zuojieAsync_");
        excutor.setWaitForTasksToCompleteOnShutdown(true);
        excutor.setAwaitTerminationSeconds(60);
        //拒绝策略
        excutor.setRejectedExecutionHandler(
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        excutor.initialize();

        return excutor;
    }

    /**
     * <h2>定义异步任务异常处理类</h2>
     * @return
     */

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return  new AsyncExceptionHandler();
    }
    class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler{

        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
            log.info("AsycError:{},Mehtod:{},param:{}",throwable.getMessage(),method.getName(),
                    JSON.toJSONString(objects));
            throwable.printStackTrace();
            //TODO 发送邮件或者发送短信
        }
    }
}
