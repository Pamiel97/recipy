package org.generation.italy.recipy.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.generation.italy.recipy.model.entities.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class UserDetailDto {
    private long id, eatingRegimeId;
    private String firstname, lastname, email, profile, pal, imgUrl, role;
    @JsonProperty
    private String password;
    private double weight, height, bfp, lbmp;
    private Character sex;
    private List<AllergyDto> allergies;
    private List<IntoleranceDto> intolerances;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserDetailDto() {}

    public UserDetailDto(long id, String firstname, String lastname, String email, String profile, String pal,
                         String imgUrl, String role, long eatingRegimeId, double weight, double height, double bfp,
                         double lbmp, Character sex, List<AllergyDto> allergies, List<IntoleranceDto> intolerances, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.profile = profile;
        this.pal = pal;
        this.imgUrl = imgUrl;
        this.role = role;
        this.eatingRegimeId = eatingRegimeId;
        this.weight = weight;
        this.height = height;
        this.bfp = bfp;
        this.lbmp = lbmp;
        this.sex = sex;
        this.allergies = allergies;
        this.intolerances = intolerances;
        this.password = password;
    }

    public static UserDetailDto fromUser(User user){
        return new UserDetailDto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getProfile().toString(),
                user.getPal().toString(),
                user.getImgUrl(),
                user.getRole().toString(),
                user.getEatingRegime().getId(),
                user.getWeight(),
                user.getHeight(),
                user.getBfp(),
                user.getLbmp(),
                user.getSex(),
                user.getAllergies().stream().map(AllergyDto::fromAllergy).toList(),
                user.getIntolerances().stream().map(IntoleranceDto::fromIntolerance).toList(),
                "**********"
        );
    }

    public User toUser(User userFromDb, EatingRegime eatingRegime){
        User user = new User();

        user.setId(userFromDb.getId());
        user.setPassword(userFromDb.getPassword());
        user.setEmail(this.email);
        user.setFirstname(this.firstname);
        user.setLastname(this.lastname);
        user.setProfile(Profile.valueOf(this.profile));
        user.setPal(Pal.valueOf(this.pal));
        user.setImgUrl(this.imgUrl);
        user.setRole(userFromDb.getRole());
        user.setWeight(this.weight);
        user.setHeight(this.height);
        user.setBfp(this.bfp);
        user.setLbmp(this.lbmp);
        user.setSex(this.sex);
        user.setEatingRegime(eatingRegime);
        user.setPassword(passwordEncoder.encode(this.password));
        return user;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getProfile() {
        return profile;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }
    public String getPal() {
        return pal;
    }
    public void setPal(String pal) {
        this.pal = pal;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getBfp() {
        return bfp;
    }
    public void setBfp(double bfp) {
        this.bfp = bfp;
    }
    public double getLbmp() {
        return lbmp;
    }
    public void setLbmp(double lbmp) {
        this.lbmp = lbmp;
    }
    public Character getSex() {
        return sex;
    }
    public void setSex(Character sex) {
        this.sex = sex;
    }
    public List<AllergyDto> getAllergies() {
        return allergies;
    }
    public void setAllergies(List<AllergyDto> allergies) {
        this.allergies = allergies;
    }
    public List<IntoleranceDto> getIntolerances() {
        return intolerances;
    }
    public void setIntolerances(List<IntoleranceDto> intolerances) {
        this.intolerances = intolerances;
    }

    public Long getEatingRegimeId() {
        return eatingRegimeId;
    }

    public void setEatingRegime(long eatingRegimeId) {
        this.eatingRegimeId = eatingRegimeId;
    }
}
