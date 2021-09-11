package com.mikheev.homework.services.impl;

import com.mikheev.homework.services.IOService;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class IOServiceImpl implements IOService {

    @Override
    public String readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void write(String output) {
        System.out.print(output);
    }
}
