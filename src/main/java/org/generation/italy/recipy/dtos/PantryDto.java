package org.generation.italy.recipy.dtos;

import org.generation.italy.recipy.model.entities.Pantry;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PantryDto {
    private long id;
    private int quantity;
    private String unitType, purchaseDate, expirationDate;
    private UserDto user;
    private long ingredientId;
    private String ingredientName;

    public PantryDto() {}
    public PantryDto(long id, int quantity, String unitType, String purchaseDate, String expirationDate, UserDto user, long ingredientId, String ingredientName) {
        this.id = id;
        this.quantity = quantity;
        this.unitType = unitType;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.user = user;
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
    }

    public static PantryDto fromPantry(Pantry pantry) {
        return new PantryDto(
                pantry.getId(),
                pantry.getQuantity(),
                pantry.getUnitType(),
                pantry.getPurchaseDate().format(DateTimeFormatter.ISO_LOCAL_DATE),
                pantry.getExpirationDate().format(DateTimeFormatter.ISO_LOCAL_DATE),
                UserDto.fromUser(pantry.getUser()),
                pantry.getIngredient().getId(),
                pantry.getIngredient().getName());

    }

    public Pantry toPantry(){
        Pantry pantry = new Pantry();
        pantry.setId(this.id);
        pantry.setQuantity(this.quantity);
        pantry.setUnitType(this.unitType);
        pantry.setPurchaseDate(LocalDate.parse(this.purchaseDate));
        pantry.setExpirationDate(LocalDate.parse(this.expirationDate));
        //manca user che viene preso direttamente dalla login
        //manca ingredientId che viene settato nel controller
        return pantry;
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
    public long getIngredientId() {
        return ingredientId;
    }
    public void setIngredientId(long ingredientId) {
        this.ingredientId = ingredientId;
    }
    public String getIngredientName() {
        return ingredientName;
    }
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
