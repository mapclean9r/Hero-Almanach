package com.example.heroEncyclopedia.controller;

import com.example.heroEncyclopedia.model.Hero;
import com.example.heroEncyclopedia.services.IHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HeroController {

    private final IHeroService heroService;

    @Autowired
    public HeroController(final IHeroService heroService){
        this.heroService = heroService;
    }

    @PutMapping(path = "/api/heroes/{id}")
    public ResponseEntity<Hero> createUpdateHero(
            @PathVariable final Integer id,
            @RequestBody final Hero hero){
        hero.setRank(id);
        final boolean isHeroExists = heroService.isHeroExist(hero);
        final Hero savedHero = heroService.save(hero);

        if (isHeroExists){
            return new ResponseEntity<>(savedHero, HttpStatus.OK);
        }
        return new ResponseEntity<>(savedHero, HttpStatus.CREATED);
    }

    @GetMapping(path = "/api/heroes/{id}")
    public ResponseEntity<Hero> getHeroByRank(@PathVariable final Integer id) {

        return heroService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/api/heroes")
    public ResponseEntity<List<Hero>> getAllHeroes(){
        return new ResponseEntity<List<Hero>>(heroService.getAllHeroes(), HttpStatus.OK);
    }


}
