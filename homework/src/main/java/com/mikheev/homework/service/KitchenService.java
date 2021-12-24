package com.mikheev.homework.service;

import com.mikheev.homework.domain.Food;
import com.mikheev.homework.domain.OrderItem;
import org.springframework.stereotype.Service;

@Service
public class KitchenService {

    public Food cook(OrderItem orderItem) throws Exception {
        System.out.println("Cooking " + orderItem.getItemName());
        Thread.sleep(3000);
        System.out.println("Cooking " + orderItem.getItemName() + " done");
        return new Food(orderItem.getItemName());
    }
}
