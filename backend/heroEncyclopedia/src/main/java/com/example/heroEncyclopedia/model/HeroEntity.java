package com.example.heroEncyclopedia.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "heroes")
public class HeroEntity {

    @Id
    private Integer rank;
    private String name;
    private String alias;
    private String description;
    private String imageUrl;

}
