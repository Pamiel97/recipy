package org.generation.italy.recipy.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    String surname;
    String email;
    String password;
    char sex;
    Profile profile;
    double weight;
    double height;
    double bfp;
    double lbmp;
    @Column(name = "diet_type")
    DietType dietType;
    Pal pal;
    @OneToMany(mappedBy = "user")
    List<Review> review = new ArrayList<>();
}
