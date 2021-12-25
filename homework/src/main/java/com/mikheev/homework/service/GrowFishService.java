package com.mikheev.homework.service;

import com.mikheev.homework.domain.Egg;
import com.mikheev.homework.domain.Fish;
import com.mikheev.homework.domain.Fry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GrowFishService {

    public List<Fry> hatch(List<Egg> eggs) throws InterruptedException {
        Thread.sleep(1000);
        List<Fry> hatched = new ArrayList<>();
        for (Egg egg : eggs) {
            hatched.add(new Fry(egg.getId()));
        }
        return hatched;
    }

    public List<Fish> grow(List<Fry> fries) throws InterruptedException {
        Thread.sleep(10000);
        List<Fish> grown = new ArrayList<>();
        for (Fry fry : fries) {
            grown.add(new Fish(fry.getId()));
        }
        return grown;
    }
}
