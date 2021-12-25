package com.mikheev.homework.service;

import com.mikheev.homework.domain.Egg;
import com.mikheev.homework.domain.Fry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class LakeService {

    public List<Egg> eatRandomEgg(List<Egg> eggs) {
        List<Egg> survivedEggs = new ArrayList<>();
        for (Egg egg : eggs) {
            if (new Random().nextBoolean()) {
                survivedEggs.add(egg);
            }
        }
        return survivedEggs;
    }

    public List<Fry> eatRandomFry(List<Fry> fries) {
        List<Fry> survivedFries = new ArrayList<>();
        for (Fry fry : fries) {
            if (new Random().nextBoolean()) {
                survivedFries.add(fry);
            }
        }
        return survivedFries;
    }
}
