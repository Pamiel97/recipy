package org.generation.italy.recipy.dtos;

import org.generation.italy.recipy.model.entities.User;

public class UserDto {
    private String firstname, lastname, profile;

    public UserDto() {}
    public UserDto(String firstname, String lastname, String profile) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.profile = profile;
    }

    public static UserDto fromUser(User user) {
        return new UserDto(user.getFirstname(), user.getLastname(), user.getProfile().toString());
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
