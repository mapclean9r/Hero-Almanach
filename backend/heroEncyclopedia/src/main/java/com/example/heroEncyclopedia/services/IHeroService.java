package com.example.heroEncyclopedia.services;

import com.example.heroEncyclopedia.model.Hero;

import java.util.List;
import java.util.Optional;

public interface IHeroService {
    Hero save(Hero hero);
    Optional<Hero> findById(Integer rank);
    List<Hero> getAllHeroes();
    boolean isHeroExist(Hero hero);

}
