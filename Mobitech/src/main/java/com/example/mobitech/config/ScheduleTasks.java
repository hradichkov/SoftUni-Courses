package com.example.mobitech.config;

import com.example.mobitech.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTasks {
    private final OrderService orderService;

    @Autowired
    public ScheduleTasks(OrderService orderService) {
        this.orderService = orderService;
    }

    @Scheduled(cron = "0 12 * * * *")
    public void delete() {
        this.orderService.deleteOldOrders();
    }
}
