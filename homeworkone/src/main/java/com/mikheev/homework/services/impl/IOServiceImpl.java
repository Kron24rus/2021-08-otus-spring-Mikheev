package com.mikheev.homework.services.impl;

import com.mikheev.homework.services.IOService;

public class IOServiceImpl implements IOService {

    @Override
    public void write(String output) {
        System.out.print(output);
    }
}
