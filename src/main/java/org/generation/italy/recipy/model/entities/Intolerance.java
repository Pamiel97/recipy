package org.generation.italy.recipy.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "intolerances")
public class Intolerance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToMany(mappedBy = "intolerances")
    private List<User> affectedUsers = new ArrayList<>();

    public Intolerance() {}
    public Intolerance(long id, String name, List<User> affectedUsers) {
        this.id = id;
        this.name = name;
        this.affectedUsers = affectedUsers;
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