package com.example.heroEncyclopedia;

import com.example.heroEncyclopedia.model.Hero;
import com.example.heroEncyclopedia.model.HeroEntity;

public final class DummyData {

    private DummyData(){}

    public static Hero testHeroData(){
        return Hero.builder()
                .alias("testerDude")
                .rank(1)
                .name("isArealTest")
                .description("testing the limits")
                .imageUrl("niks/bilde")
                .build();
    }

    public static HeroEntity testHeroEntityData(){
        return HeroEntity.builder()
                .alias("testerDude")
                .rank(1)
                .name("isArealTest")
                .description("testing the limits")
                .imageUrl("niks/bilde")
                .build();

    }
}
