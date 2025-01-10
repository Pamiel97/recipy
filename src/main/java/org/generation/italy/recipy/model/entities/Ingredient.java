package org.generation.italy.recipy.model.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "kcal_per_gram", precision = 10, scale = 2)
    private BigDecimal kcal;
    @Column(name = "carbohydrates_per_gram", precision = 10, scale = 2)
    private BigDecimal carbohydrates;
    @Column(name = "proteins_per_gram", precision = 10, scale = 2)
    private BigDecimal proteins;
    @Column(name = "fats_per_gram", precision = 10, scale = 2)
    private BigDecimal fats;
    @Column(name = "avg_weight", precision = 10, scale = 2)
    private BigDecimal avgWeight;
    @Column(name = "avg_price", precision = 10, scale = 2)
    private BigDecimal avgPrice;
    @Column(name = "img_url")
    private String imgUrl;
    @ManyToOne
    @JoinColumn(name = "allergy_id")
    private Allergy allergy;
    @ManyToOne
    @JoinColumn(name = "intolerance_id")
    private Intolerance intolerance;
    @ManyToOne
    @JoinColumn(name = "ingredient_category_id")
    private IngredientCategory ingredientCategory;
    @OneToMany(mappedBy = "ingredient")
    private List<Pantry> pantries = new ArrayList<>();

    public Ingredient() {}
    public Ingredient(long id){
        this.id =id;
    }
    public Ingredient(long id, String name, BigDecimal kcal, BigDecimal carbohydrates, BigDecimal proteins,
                      BigDecimal fats, BigDecimal avgWeight, BigDecimal avgPrice, String imgUrl, Allergy allergy,
                      Intolerance intolerance, IngredientCategory ingredientCategory, List<Pantry> pantries) {
        this.id = id;
        this.name = name;
        this.kcal = kcal;
        this.carbohydrates = carbohydrates;
        this.proteins = proteins;
        this.fats = fats;
        this.avgWeight = avgWeight;
        this.avgPrice = avgPrice;
        this.imgUrl = imgUrl;
        this.allergy = allergy;
        this.intolerance = intolerance;
        this.ingredientCategory = ingredientCategory;
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
    public BigDecimal getKcal() {
        return kcal;
    }
    public void setKcal(BigDecimal kcal) {
        this.kcal = kcal;
    }
    public BigDecimal getCarbohydrates() {
        return carbohydrates;
    }
    public void setCarbohydrates(BigDecimal carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
    public BigDecimal getProteins() {
        return proteins;
    }
    public void setProteins(BigDecimal proteins) {
        this.proteins = proteins;
    }
    public BigDecimal getFats() {
        return fats;
    }
    public void setFats(BigDecimal fats) {
        this.fats = fats;
    }
    public BigDecimal getAvgWeight() {
        return avgWeight;
    }
    public void setAvgWeight(BigDecimal avgWeight) {
        this.avgWeight = avgWeight;
    }
    public BigDecimal getAvgPrice() {
        return avgPrice;
    }
    public void setAvgPrice(BigDecimal avgPrice) {
        this.avgPrice = avgPrice;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
    public IngredientCategory getIngredientCategory() {
        return ingredientCategory;
    }
    public void setIngredientCategory(IngredientCategory ingredientCategory) {
        this.ingredientCategory = ingredientCategory;
    }
    public List<Pantry> getPantries() {
        return pantries;
    }
    public void setPantries(List<Pantry> pantries) {
        this.pantries = pantries;
    }
}
