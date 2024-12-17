package org.generation.italy.recipy.dtos;

import org.generation.italy.recipy.model.entities.User;

public class UserDto {
    private String firstname, lastname;

    public UserDto() {}
    public UserDto(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public static UserDto fromUser(User user) {
        return new UserDto(user.getFirstname(), user.getLastname());
    }

    public User toUser() {
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        return user;
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
}
