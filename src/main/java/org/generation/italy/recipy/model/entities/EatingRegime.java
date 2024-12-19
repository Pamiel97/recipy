package org.generation.italy.recipy.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "eating_regimes")
public class EatingRegime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    String description;
    @OneToMany(mappedBy = "eatingRegime")
    List<User> user;
    @ManyToMany(mappedBy = "eatingRegimes")
    private List<User> ingredientCategory = new ArrayList<>();
}
