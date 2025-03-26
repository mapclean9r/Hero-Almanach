package com.example.heroEncyclopedia.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hero {

    private Integer rank;
    private String name;
    private String alias;
    private String description;
    private String imageUrl;

}
