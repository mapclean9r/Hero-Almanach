package com.example.heroEncyclopedia.controllers;

import com.example.heroEncyclopedia.DummyData;
import com.example.heroEncyclopedia.model.Hero;
import com.example.heroEncyclopedia.services.IHeroService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TestHeroController {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IHeroService heroService;

    @Test
    public void testIsHeroCreated() throws Exception {
        final Hero hero = DummyData.testHeroData();
        final ObjectMapper objectMapper = new ObjectMapper();
        final String jsonHero = objectMapper.writeValueAsString(hero);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/heroes/"+hero.getRank())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonHero))
                .andExpect(jsonPath("$.rank").value(hero.getRank()));
    }

    @Test
    public void testIsHeroUpdated() throws Exception {
        final Hero hero = DummyData.testHeroData();
        System.out.println(hero);
        heroService.save(hero);
        hero.setName("Horse");
        final ObjectMapper objectMapper = new ObjectMapper();
        final String jsonHero = objectMapper.writeValueAsString(hero);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/heroes/"+hero.getRank())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonHero))
                .andExpect(jsonPath("$.name").value(hero.getName()));
        System.out.println(hero);
    }

    @Test
    public void testGetOneHero() throws Exception {
        final Hero hero = DummyData.testHeroData();
        heroService.save(hero);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/heroes/"+hero.getRank()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAllHeroes() throws Exception {
        final Hero hero = DummyData.testHeroData();
        heroService.save(hero);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/heroes"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]alias").value(hero.getAlias()));
    }

}
