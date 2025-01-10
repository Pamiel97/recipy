package org.generation.italy.recipy.dtos;

import org.generation.italy.recipy.model.entities.*;

import java.math.BigDecimal;

public class IngredientDto {
    private long id;
    private String name, imgUrl, allergy, intolerance;
    private BigDecimal kcal, carbs, prots, fats, weight, price;
    private String ingredientCategory;
    public IngredientDto() {}

    public IngredientDto(long id, String name, BigDecimal kcal, BigDecimal carbs, BigDecimal prots, BigDecimal fats,
                         BigDecimal weight, BigDecimal price, String imgUrl, String allergy, String intolerance,
                         String ingredientCategory) {
        this.id = id;
        this.name = name;
        this.kcal = kcal;
        this.carbs = carbs;
        this.prots = prots;
        this.fats = fats;
        this.weight = weight;
        this.price = price;
        this.imgUrl = imgUrl;
        this.allergy = allergy;
        this.intolerance = intolerance;
        this.ingredientCategory = ingredientCategory;
    }

    public static IngredientDto fromIngredient(Ingredient ingredient) {
        IngredientDto dto = new IngredientDto();
        dto.setId(ingredient.getId());
        dto.setName(ingredient.getName());
        dto.setKcal(ingredient.getKcal());
        dto.setCarbs(ingredient.getCarbohydrates());
        dto.setProts(ingredient.getProteins());
        dto.setFats(ingredient.getFats());
        dto.setWeight(ingredient.getAvgWeight());
        dto.setPrice(ingredient.getAvgPrice());
        dto.setImgUrl(ingredient.getImgUrl());
        dto.setIngredientCategory(ingredient.getIngredientCategory().getName());

        if(ingredient.getAllergy() != null) {
            dto.setAllergy(ingredient.getAllergy().getName());
        } else {
            dto.setAllergy(null);
        }
        if(ingredient.getIntolerance() != null) {
            dto.setIntolerance(ingredient.getIntolerance().getName());
        } else {
            dto.setIntolerance(null);
        }

        return dto;
    }

    public Ingredient toIngredient() {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(this.id);
        ingredient.setName(this.name);
        ingredient.setKcal(this.kcal);
        ingredient.setCarbohydrates(this.carbs);
        ingredient.setProteins(this.prots);
        ingredient.setFats(this.fats);
        ingredient.setAvgWeight(this.weight);
        ingredient.setAvgPrice(this.price);
        ingredient.setImgUrl(this.imgUrl);
        ingredient.setAllergy(new Allergy());
        ingredient.setIntolerance(new Intolerance());
        //manca la category da settare
        return ingredient;
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
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public String getAllergy() {
        return allergy;
    }
    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }
    public String getIntolerance() {
        return intolerance;
    }
    public void setIntolerance(String intolerance) {
        this.intolerance = intolerance;
    }
    public BigDecimal getKcal() {
        return kcal;
    }
    public void setKcal(BigDecimal kcal) {
        this.kcal = kcal;
    }
    public BigDecimal getCarbs() {
        return carbs;
    }
    public void setCarbs(BigDecimal carbs) {
        this.carbs = carbs;
    }
    public BigDecimal getProts() {
        return prots;
    }
    public void setProts(BigDecimal prots) {
        this.prots = prots;
    }
    public BigDecimal getFats() {
        return fats;
    }
    public void setFats(BigDecimal fats) {
        this.fats = fats;
    }
    public BigDecimal getWeight() {
        return weight;
    }
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getIngredientCategory() {
        return ingredientCategory;
    }
    public void setIngredientCategory(String ingredientCategory) {
        this.ingredientCategory = ingredientCategory;
    }
}
