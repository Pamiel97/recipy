package org.generation.italy.recipy.dtos;

import org.generation.italy.recipy.model.entities.*;

public class IngredientDto {
    private long id;
    private String name, imgUrl, allergy, intolerance;
    private double kcal, carbs, prots, fats, weight, price;
    public IngredientDto() {}

    public IngredientDto(long id, String name, double kcal, double carbs, double prots, double fats, double weight,
                         double price, String imgUrl, String allergy, String intolerance) {
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
    public double getKcal() {
        return kcal;
    }
    public void setKcal(double kcal) {
        this.kcal = kcal;
    }
    public double getCarbs() {
        return carbs;
    }
    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }
    public double getProts() {
        return prots;
    }
    public void setProts(double prots) {
        this.prots = prots;
    }
    public double getFats() {
        return fats;
    }
    public void setFats(double fats) {
        this.fats = fats;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
