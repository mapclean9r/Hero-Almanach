package com.example.heroEncyclopedia.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hero {


    private String name;
    private String alias;
    private Integer rank;
    private String heroClass;
    private List<String> abilities;
    private String personality;
    private String description;
    private String imageUrl;

}
