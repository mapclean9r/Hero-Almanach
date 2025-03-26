package com.example.heroEncyclopedia.services;

import com.example.heroEncyclopedia.DummyData;
import com.example.heroEncyclopedia.model.Hero;
import com.example.heroEncyclopedia.model.HeroEntity;
import com.example.heroEncyclopedia.repositories.IHeroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestHeroService {

    @Mock
    private IHeroRepository heroRepository;
    @InjectMocks
    private HeroService heroService;

    @Test
    public void testCreateHero(){
        final Hero heroDummy = DummyData.testHeroData();
        final HeroEntity heroEntityDummy = DummyData.testHeroEntityData();

        when(heroRepository.save(eq(heroEntityDummy))).thenReturn(heroEntityDummy);

        final Hero hero = heroService.save(heroDummy);
        assertEquals(hero, heroDummy);
        System.out.println(hero+"\n"+heroDummy);

    }

    @Test
    public void testGetOneHero(){
        final Hero heroDummy = DummyData.testHeroData();
        final HeroEntity heroEntityDummy = DummyData.testHeroEntityData();
        when(heroRepository.findById(eq(heroDummy.getRank())))
                .thenReturn(Optional.of(heroEntityDummy));

        final Optional<Hero> result = heroService.findById(heroDummy.getRank());
        assertEquals(Optional.of(heroDummy), result);
        System.out.println(result);

    }

    @Test
    public void testGetAllHeroes(){
        final HeroEntity heroEntityDummy = DummyData.testHeroEntityData();
        when(heroRepository.findAll()).thenReturn(List.of(heroEntityDummy));
        final List<Hero> result = heroService.getAllHeroes();
        assertEquals(1, result.size());
        System.out.println(result);
    }

    @Test
    public void testHeroExist(){
        final Hero heroDummy = DummyData.testHeroData();
        when(heroRepository.existsById(any())).thenReturn(true);
        final boolean result = heroService.isHeroExist(heroDummy);
        assertEquals(true, result);
    }

}
