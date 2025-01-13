package org.generation.italy.recipy.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonIgnore
    @ManyToMany(mappedBy = "allergies")
    private List<User> affectedUsers = new ArrayList<>();

    public Allergy() {}
    public Allergy(long id, List<User> affectedUsers, String name) {
        this.id = id;
        this.affectedUsers = affectedUsers;
        this.name = name;
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
    public List<User> getAffectedUsers() {
        return affectedUsers;
    }
    public void setAffectedUsers(List<User> affectedUsers) {
        this.affectedUsers = affectedUsers;
    }
}
