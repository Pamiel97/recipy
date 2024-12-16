package org.generation.italy.recipy.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "allergies")
public class Allergy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    @ManyToMany(mappedBy = "allergies")
    private List<User> affectedUsers = new ArrayList<>();

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
    public List<User> getAffectedUsers() {
        return affectedUsers;
    }
    public void setAffectedUsers(List<User> affectedUsers) {
        this.affectedUsers = affectedUsers;
    }
}
