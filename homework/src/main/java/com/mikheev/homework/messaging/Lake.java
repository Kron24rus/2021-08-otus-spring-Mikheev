package com.mikheev.homework.messaging;

import com.mikheev.homework.domain.Egg;
import com.mikheev.homework.domain.Fish;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import java.util.Collection;

@MessagingGateway
public interface Lake {

    @Gateway(requestChannel = "eggsChannel", replyChannel = "fishChannel")
    Collection<Fish> process(Collection<Egg> eggs);
}
