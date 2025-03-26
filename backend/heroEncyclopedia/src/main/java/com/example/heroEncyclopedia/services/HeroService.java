package com.example.heroEncyclopedia.services;

import com.example.heroEncyclopedia.model.Hero;
import com.example.heroEncyclopedia.model.HeroEntity;
import com.example.heroEncyclopedia.repositories.IHeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HeroService implements IHeroService {

    private final IHeroRepository heroRepository;

    @Autowired
    public HeroService(final IHeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }


    @Override
    public Hero save(final Hero hero) {
        final HeroEntity heroEntity = mapperHeroToHeroEntity(hero);
        final HeroEntity mappedHero = heroRepository.save(heroEntity);
        return mapperHeroEntityToHero(mappedHero);
    }

    @Override
    public Optional<Hero> findById(Integer rank) {
        final Optional<HeroEntity> hero = heroRepository.findById(rank);
        return hero.map(this::mapperHeroEntityToHero);
    }

    @Override
    public List<Hero> getAllHeroes() {
        final List<HeroEntity> allHeroes = heroRepository.findAll();
        return allHeroes.stream().map(this::mapperHeroEntityToHero).collect(Collectors.toList());
    }

    @Override
    public boolean isHeroExist(Hero hero) {
        return heroRepository.existsById(hero.getRank());
    }

    private HeroEntity mapperHeroToHeroEntity(Hero hero){
        return HeroEntity.builder()
                .rank(hero.getRank())
                .name(hero.getName())
                .alias(hero.getAlias())
                .description(hero.getDescription())
                .imageUrl(hero.getImageUrl())
                .build();
    }

    private Hero mapperHeroEntityToHero(HeroEntity heroEntity){
        return Hero.builder()
                .rank(heroEntity.getRank())
                .name(heroEntity.getName())
                .alias(heroEntity.getAlias())
                .description(heroEntity.getDescription())
                .imageUrl(heroEntity.getImageUrl())
                .build();
    }

}
