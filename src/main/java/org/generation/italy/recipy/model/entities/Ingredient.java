package org.generation.italy.recipy.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    @Column(name = "kcal_per_gram")
    double kcal;
    @Column(name = "carbohydrates_per_gram")
    double carbohydrates;
    @Column(name = "proteins_per_gram")
    double proteins;
    @Column(name = "fats_per_gram")
    double fats;
    Category category;
    @Column(name = "allergens")
    Allergen allergen;
    @Column(name = "avg_weight")
    double avgWeight;
    @Column(name = "avg_price")
    double avgPrice;
    @Column(name = "img_url")
    String imgUrl;



}
