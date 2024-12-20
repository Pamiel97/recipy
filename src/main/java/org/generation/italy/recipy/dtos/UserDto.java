package org.generation.italy.recipy.dtos;

import org.generation.italy.recipy.model.entities.User;

public class UserDto {
    long id;
    private String firstname, lastname, profile;

    public UserDto() {}
    public UserDto(long id, String firstname, String lastname, String profile) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.profile = profile;
    }

    public static UserDto fromUser(User user) {
        return new UserDto(user.getId(), user.getFirstname(), user.getLastname(), user.getProfile() == null ? "utente_base" : user.getProfile().toString());
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getProfile() {
        return profile;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }
}
