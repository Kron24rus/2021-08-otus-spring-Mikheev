package com.mikheev.homework.messaging;

import com.mikheev.homework.domain.Food;
import com.mikheev.homework.domain.OrderItem;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import java.util.Collection;

@MessagingGateway
public interface Cafe {

    @Gateway(requestChannel = "itemsChannel", replyChannel = "foodChannel")
    Collection<Food> process(Collection<OrderItem> orderItem);
}
