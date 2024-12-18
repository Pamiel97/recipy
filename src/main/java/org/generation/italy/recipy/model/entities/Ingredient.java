package org.generation.italy.recipy.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "kcal_per_gram")
    private double kcal;
    @Column(name = "carbohydrates_per_gram")
    private double carbohydrates;
    @Column(name = "proteins_per_gram")
    private double proteins;
    @Column(name = "fats_per_gram")
    private double fats;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(name = "avg_weight")
    private double avgWeight;
    @Column(name = "avg_price")
    private double avgPrice;
    @Column(name = "img_url")
    private String imgUrl;
    @Column(name = "diet_compatibility")
    @Enumerated(EnumType.STRING)
    private DietType dietCompatibility;
    @ManyToOne
    @JoinColumn(name = "allergy_id")
    private Allergy allergy;
    @ManyToOne
    @JoinColumn(name = "intolerance_id")
    private Intolerance intolerance;
    @OneToMany(mappedBy = "ingredient")
    private List<Pantry> pantries = new ArrayList<>();

    public Ingredient() {}
    public Ingredient(long id){
        this.id =id;
    }
    public Ingredient(long id, String name, double kcal, double carbohydrates, double proteins, double fats, Category category, double avgWeight, double avgPrice, String imgUrl, DietType dietCompatibility, Allergy allergy, Intolerance intolerance, List<Pantry> pantries) {
        this.id = id;
        this.name = name;
        this.kcal = kcal;
        this.carbohydrates = carbohydrates;
        this.proteins = proteins;
        this.fats = fats;
        this.category = category;
        this.avgWeight = avgWeight;
        this.avgPrice = avgPrice;
        this.imgUrl = imgUrl;
        this.dietCompatibility = dietCompatibility;
        this.allergy = allergy;
        this.intolerance = intolerance;
        this.pantries = pantries;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getAvgWeight() {
        return avgWeight;
    }

    public void setAvgWeight(double avgWeight) {
        this.avgWeight = avgWeight;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public DietType getDietCompatibility() {
        return dietCompatibility;
    }

    public void setDietCompatibility(DietType dietCompatibility) {
        this.dietCompatibility = dietCompatibility;
    }

    public Allergy getAllergy() {
        return allergy;
    }

    public void setAllergy(Allergy allergy) {
        this.allergy = allergy;
    }

    public Intolerance getIntolerance() {
        return intolerance;
    }

    public void setIntolerance(Intolerance intolerance) {
        this.intolerance = intolerance;
    }

    public List<Pantry> getPantries() {
        return pantries;
    }

    public void setPantries(List<Pantry> pantries) {
        this.pantries = pantries;
    }

}
