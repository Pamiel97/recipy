package org.generation.italy.recipy.dtos;

import org.generation.italy.recipy.model.entities.Pantry;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PantryDto {
    private long id;
    private int quantity;
    private String unitType, purchaseDate, expirationDate;
    private UserDto user;
    private IngredientDto ingredient;

    public PantryDto() {}
    public PantryDto(long id, int quantity, String unitType, String purchaseDate, String expirationDate, UserDto user, IngredientDto ingredient) {
        this.id = id;
        this.quantity = quantity;
        this.unitType = unitType;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.user = user;
        this.ingredient = ingredient;
    }

    public static PantryDto fromPantry(Pantry pantry) {
        return new PantryDto(pantry.getId(),
                             pantry.getQuantity(),
                             pantry.getUnitType(),
                             pantry.getPurchaseDate().format(DateTimeFormatter.ISO_LOCAL_DATE),
                             pantry.getExpirationDate().format(DateTimeFormatter.ISO_LOCAL_DATE),
                             UserDto.fromUser(pantry.getUser()),
                             IngredientDto.fromIngredient(pantry.getIngredient()));
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getUnitType() {
        return unitType;
    }
    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }
    public String getPurchaseDate() {
        return purchaseDate;
    }
    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    public String getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    public UserDto getUser() {
        return user;
    }
    public void setUser(UserDto user) {
        this.user = user;
    }
    public IngredientDto getIngredient() {
        return ingredient;
    }
    public void setIngredient(IngredientDto ingredient) {
        this.ingredient = ingredient;
    }
}
