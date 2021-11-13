package com.mikheev.homework.repositories.impl;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;

@DataMongoTest
@EnableConfigurationProperties
@ComponentScan({"com.mikheev.homework.repositories", "com.mikheev.homework.configuration"})
public class AbstractTestRepository {
}
