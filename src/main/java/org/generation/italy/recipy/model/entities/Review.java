package org.generation.italy.recipy.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="reviews")
public class Review {
    long id;
    String text;
    double rating;
    @Column(name="creation_date")
    LocalDate creationDate;
    @ManyToOne
    @JoinColumn(name="user_id")
    User user;
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    Recipe recipe;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
