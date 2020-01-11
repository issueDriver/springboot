package com.zuojie.redis.service;
import org.springframework.stereotype.Service;

/**
 * author:zuojie
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void closeOrder() {
        System.out.println("执行了关闭订单的操作");
    }
}
