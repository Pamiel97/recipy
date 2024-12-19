package org.generation.italy.recipy.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Course course;
    @Column(name = "prep_time")
    private int prepTime;
    @Column(name = "cooking_time")
    private int cookingTime;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    @Column(name = "kcalories")
    private double kCalories;
    @Column(name = "creation_date")
    private LocalDate creationDate;
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //permette di caricare direttamente tutte le tag
    private List<Tag> tag;
    @Column(name = "img_url")
    private String imgUrl;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<RecipeStep> recipeSteps = new ArrayList<>();

    public Recipe() {}
    public Recipe(long id, String title, String description, Course course, int prepTime, int cookingTime, Difficulty difficulty, double kCalories, LocalDate creationDate, List<Tag> tag, String imgUrl, User user, List<RecipeStep> recipeSteps) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.course = course;
        this.prepTime = prepTime;
        this.cookingTime = cookingTime;
        this.difficulty = difficulty;
        this.kCalories = kCalories;
        this.creationDate = creationDate;
        this.tag = tag;
        this.imgUrl = imgUrl;
        this.user = user;
        this.recipeSteps = recipeSteps;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public double getkCalories() {
        return kCalories;
    }

    public void setkCalories(double kCalories) {
        this.kCalories = kCalories;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<RecipeStep> getRecipeSteps() {
        return recipeSteps;
    }

    public void setRecipeSteps(List<RecipeStep> recipeSteps) {
        this.recipeSteps = recipeSteps;
    }
}
