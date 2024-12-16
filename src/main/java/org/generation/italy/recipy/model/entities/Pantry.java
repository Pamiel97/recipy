package org.generation.italy.recipy.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pantry")
public class Pantry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantity;
    @Column(name = "unit_type")
    private String unitType;
    @Column(name = "purchase_date")
    private LocalDate purchaseDate;
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

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
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Ingredient getIngredient() {
        return ingredient;
    }
    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

}
