package com.mikheev.homework;

import com.mikheev.homework.domain.Egg;
import com.mikheev.homework.domain.Fish;
import com.mikheev.homework.messaging.Lake;
import com.mikheev.homework.service.GrowFishService;
import com.mikheev.homework.service.LakeService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@IntegrationComponentScan
@SpringBootApplication
public class HomeworkApplication {

    private final GrowFishService growFishService;
    private final LakeService lakeService;

    @Bean
    public QueueChannel eggsChannel() {
        return MessageChannels.queue(10).get();
    }

    @Bean
    public DirectChannel fishChannel() {
        return MessageChannels.direct().get();
    }

    @Bean
    public IntegrationFlow fishGrowFlow() {
        return IntegrationFlows.from("eggsChannel")
                .handle(lakeService, "eatRandomEgg")
                .handle(growFishService, "hatch")
                .handle(lakeService, "eatRandomFry")
                .handle(growFishService, "grow")
                .channel("fishChannel")
                .get();
    }

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(HomeworkApplication.class, args);
        Lake lake = applicationContext.getBean( Lake.class );

        ForkJoinPool pool = ForkJoinPool.commonPool();

        while ( true ) {
            Thread.sleep( 7000 );

            pool.execute( () -> {
                Collection<Egg> eggs = generateEggs();
                System.out.println("Generated Eggs: " + eggs.stream()
                        .map(Egg::getId).collect(Collectors.toList()));
                Collection<Fish> food = lake.process(eggs);
                System.out.println("Survived Fish: " + food.stream()
                        .map(Fish::getId).collect(Collectors.toList()));
            });
        }
    }

    private static Collection<Egg> generateEggs() {
        List<Egg> eggs = new ArrayList<>();
        for (int i = 0; i < RandomUtils.nextInt(50, 100); i++) {
            eggs.add(new Egg(i));
        }
        return eggs;
    }
}
