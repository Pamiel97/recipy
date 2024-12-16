package org.generation.italy.recipy.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String description;
    Category category;
    @Column(name = "prep_time")
    int prepTime;
    @Column(name = "cooking_time")
    int cookingTime;
    String difficulty;
    double kCalories;
    @Column(name = "creation_date")
    LocalDate creationDate;
    ArrayList<Tag> tag;
    @Column(name = "img_url")
    String imgUrl;
    @Column(name = "user_id")
    ArrayList<User> userId;

    //CONTROLLARE
    @ManyToMany
    @JoinTable(
            name = "NOME TABELLA COMUNE",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    ArrayList<Ingredient> ingredients;
}
