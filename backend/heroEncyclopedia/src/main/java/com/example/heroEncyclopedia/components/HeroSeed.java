package com.example.heroEncyclopedia.components;

import com.example.heroEncyclopedia.model.Hero;
import com.example.heroEncyclopedia.services.IHeroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HeroSeed implements CommandLineRunner {

    private final IHeroService heroService;

    public HeroSeed(IHeroService heroService) {
        this.heroService = heroService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Hero> sClassHeroes = List.of(
                new Hero(1, "Blast", "Blast", "Mysterious top-ranked hero who appears only when the world is in grave danger.", "https://static.wikia.nocookie.net/onepunchman/images/1/15/Blast_Anime.png"),
                new Hero(2, "Tatsumaki", "Tornado of Terror", "Extremely powerful esper with a strong personality and little patience for others.", "https://static.wikia.nocookie.net/onepunchman/images/d/d0/Tatsumaki_Anime.png"),
                new Hero(3, "Bang", "Silver Fang", "A wise martial arts master who uses the Water Stream Rock Smashing Fist style.", "https://static.wikia.nocookie.net/onepunchman/images/0/05/Bang_Anime.png"),
                new Hero(4, "Kamaitachi", "Atomic Samurai", "Master swordsman known for his atomic-level precision strikes.", "https://static.wikia.nocookie.net/onepunchman/images/3/33/Atomic_Samurai_Anime.png"),
                new Hero(5, "Child Emperor", "Child Emperor", "A young genius who uses advanced technology to fight monsters.", "https://static.wikia.nocookie.net/onepunchman/images/f/fc/Child_Emperor_Anime.png"),
                new Hero(6, "Bofoi", "Metal Knight", "A remote-controlled scientist hero with unknown motives.", "https://static.wikia.nocookie.net/onepunchman/images/5/5c/Metal_Knight_Anime.png"),
                new Hero(7, "King", "King", "Known as the 'Strongest Man on Earth' despite having no real combat power.", "https://static.wikia.nocookie.net/onepunchman/images/6/66/King_Anime.png"),
                new Hero(8, "Zombieman", "Zombieman", "An immortal hero with incredible regenerative abilities and detective skills.", "https://static.wikia.nocookie.net/onepunchman/images/5/59/Zombieman_Anime.png"),
                new Hero(9, "Drive Knight", "Drive Knight", "A mysterious transforming cyborg who distrusts Metal Knight.", "https://static.wikia.nocookie.net/onepunchman/images/5/59/Drive_Knight_Anime.png"),
                new Hero(10, "Pig God", "Pig God", "A gluttonous hero who can devour even massive monsters in a single gulp.", "https://static.wikia.nocookie.net/onepunchman/images/6/6c/Pig_God_Anime.png"),
                new Hero(11, "Superalloy Darkshine", "Superalloy Darkshine", "A muscular, shiny-skinned hero with superhuman durability and strength.", "https://static.wikia.nocookie.net/onepunchman/images/1/15/Superalloy_Darkshine_Anime.png"),
                new Hero(12, "Watchdog Man", "Watchdog Man", "A silent guardian of Q-City who wears a dog suit and fights like a beast.", "https://static.wikia.nocookie.net/onepunchman/images/0/05/Watchdog_Man_Anime.png"),
                new Hero(13, "Flashy Flash", "Flashy Flash", "An incredibly fast and agile swordsman, formerly part of the Ninja Village.", "https://static.wikia.nocookie.net/onepunchman/images/8/83/Flashy_Flash_Anime.png"),
                new Hero(14, "Genos", "Demon Cyborg", "A cyborg hero and Saitama's disciple who constantly upgrades himself to get stronger.", "https://static.wikia.nocookie.net/onepunchman/images/9/90/Genos_Anime.png"),
                new Hero(15, "Metal Bat", "Metal Bat", "A delinquent-style hero who becomes stronger the more damage he takes.", "https://static.wikia.nocookie.net/onepunchman/images/9/9a/Metal_Bat_Anime.png"),
                new Hero(16, "Tanktop Master", "Tanktop Master", "A strongman who believes in the power of tank tops and brute strength.", "https://static.wikia.nocookie.net/onepunchman/images/e/ea/Tanktop_Master_Anime.png"),
                new Hero(17, "Puri-Puri Prisoner", "Puri-Puri Prisoner", "A flamboyant hero who gains power when he breaks free from his clothes.", "https://static.wikia.nocookie.net/onepunchman/images/0/0d/Puri-Puri_Prisoner_Anime.png")
        );

        for (Hero hero : sClassHeroes) {
            heroService.save(hero);
        }
    }
}