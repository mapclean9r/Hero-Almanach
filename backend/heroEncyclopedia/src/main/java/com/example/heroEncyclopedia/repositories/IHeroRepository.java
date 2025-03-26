package com.example.heroEncyclopedia.repositories;

import com.example.heroEncyclopedia.model.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHeroRepository extends JpaRepository<HeroEntity, Integer> {

}
