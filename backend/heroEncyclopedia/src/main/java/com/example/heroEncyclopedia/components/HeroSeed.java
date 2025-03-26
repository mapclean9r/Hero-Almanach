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
                new Hero("Blast", "Blast", 1, "S", List.of("Teleportation", "Energy manipulation", "Super speed", "Super strength"), "Stoic, secretive, mission-driven", "Blast is the enigmatic top-ranked hero who only appears when the world is in grave danger.", "https://static.wikia.nocookie.net/onepunchman/images/1/15/Blast_Anime.png"),
                new Hero("Tatsumaki", "Tornado of Terror", 2, "S", List.of("Psychokinesis", "Flight", "Force fields"), "Hot-headed, impatient, confident", "Tatsumaki is a tiny but terrifying esper who can level cities with her psychic powers.", "https://static.wikia.nocookie.net/onepunchman/images/d/d0/Tatsumaki_Anime.png"),
                new Hero("Bang", "Silver Fang", 3, "S", List.of("Martial arts mastery", "Water Stream Rock Smashing Fist", "Superhuman reflexes"), "Calm, wise, disciplined", "Bang is a martial arts master with unmatched technique and wisdom in combat.", "https://static.wikia.nocookie.net/onepunchman/images/0/05/Bang_Anime.png"),
                new Hero("Kamaitachi", "Atomic Samurai", 4, "S", List.of("Master swordsmanship", "Atomic-level strikes", "Incredible speed"), "Proud, traditional, loyal to strength", "Atomic Samurai uses incredible sword speed and precision to annihilate his enemies.", "https://static.wikia.nocookie.net/onepunchman/images/3/33/Atomic_Samurai_Anime.png"),
                new Hero("Child Emperor", "Child Emperor", 5, "S", List.of("Genius-level intellect", "Robotics", "Gadgets and weapons"), "Serious, analytical, mature for his age", "Child Emperor is a technological prodigy who uses gadgets to defeat powerful foes.", "https://static.wikia.nocookie.net/onepunchman/images/f/fc/Child_Emperor_Anime.png"),
                new Hero("Bofoi", "Metal Knight", 6, "S", List.of("Remote-controlled robots", "Missile systems", "Engineering genius"), "Secretive, pragmatic, morally ambiguous", "Metal Knight fights using advanced remote-controlled robots and heavy weaponry.", "https://static.wikia.nocookie.net/onepunchman/images/5/5c/Metal_Knight_Anime.png"),
                new Hero("King", "King", 7, "S", List.of("None (relies on intimidation and luck)"), "Timid, unlucky, falsely revered", "Though he lacks combat power, King's reputation alone terrifies even the strongest.", "https://static.wikia.nocookie.net/onepunchman/images/6/66/King_Anime.png"),
                new Hero("Zombieman", "Zombieman", 8, "S", List.of("Immortality", "Regeneration", "Weapon proficiency"), "Calm, investigative, resilient", "Zombieman is an immortal hero who never stops, no matter how many times he's injured.", "https://static.wikia.nocookie.net/onepunchman/images/5/59/Zombieman_Anime.png"),
                new Hero("Drive Knight", "Drive Knight", 9, "S", List.of("Transformation", "Stealth", "Surveillance tech"), "Mysterious, distrustful, strategic", "Drive Knight is a tactical cyborg who transforms into various combat modes.", "https://static.wikia.nocookie.net/onepunchman/images/5/59/Drive_Knight_Anime.png"),
                new Hero("Pig God", "Pig God", 10, "S", List.of("Extreme digestive power", "Inhuman durability"), "Calm, confident, gluttonous", "Pig God can devour monsters whole and has incredible endurance in battle.", "https://static.wikia.nocookie.net/onepunchman/images/6/6c/Pig_God_Anime.png"),
                new Hero("Superalloy Darkshine", "Superalloy Darkshine", 11, "S", List.of("Superhuman strength", "Invulnerability", "High durability"), "Gentle but insecure, obsessed with strength", "A gentle giant with near-invulnerability and dazzling muscular strength.", "https://static.wikia.nocookie.net/onepunchman/images/1/15/Superalloy_Darkshine_Anime.png"),
                new Hero("Watchdog Man", "Watchdog Man", 12, "S", List.of("Beast-like reflexes", "Extreme agility", "Savage fighting style"), "Silent, loyal, quirky", "Watchdog Man guards his city ferociously with wild animal-like fighting skills.", "https://static.wikia.nocookie.net/onepunchman/images/0/05/Watchdog_Man_Anime.png"),
                new Hero("Flashy Flash", "Flashy Flash", 13, "S", List.of("Supersonic speed", "Swordsmanship", "Ninja techniques"), "Arrogant, competitive, elegant", "Flashy Flash is a supersonic ninja whose speed and style are unmatched.", "https://static.wikia.nocookie.net/onepunchman/images/8/83/Flashy_Flash_Anime.png"),
                new Hero("Genos", "Demon Cyborg", 14, "S", List.of("Cyborg enhancements", "Energy blasts", "Extreme agility"), "Serious, loyal, driven", "Genos is a powerful cyborg seeking justice and personal growth as Saitama's disciple.", "https://static.wikia.nocookie.net/onepunchman/images/9/90/Genos_Anime.png"),
                new Hero("Metal Bat", "Metal Bat", 15, "S", List.of("Indomitable will", "Strength increases with damage", "Expert in bat combat"), "Hot-headed, stubborn, family-oriented", "Metal Bat grows stronger the more damage he takes, fighting with fierce resolve.", "https://static.wikia.nocookie.net/onepunchman/images/9/9a/Metal_Bat_Anime.png"),
                new Hero("Tanktop Master", "Tanktop Master", 16, "S", List.of("Tanktop-based strength", "Raw physical power"), "Motivational, loyal, straightforward", "Tanktop Master uses sheer physical power and inspires others through action.", "https://static.wikia.nocookie.net/onepunchman/images/e/ea/Tanktop_Master_Anime.png"),
                new Hero("Puri-Puri Prisoner", "Puri-Puri Prisoner", 17, "S", List.of("Angel-style combat", "Muscle growth on transformation"), "Flamboyant, affectionate, passionate", "Puri-Puri Prisoner unleashes his strength in battle with flamboyant, powerful moves.", "https://static.wikia.nocookie.net/onepunchman/images/0/0d/Puri-Puri_Prisoner_Anime.png")
        );
        for (Hero hero : sClassHeroes) {
            heroService.save(hero);
        }
    }
}