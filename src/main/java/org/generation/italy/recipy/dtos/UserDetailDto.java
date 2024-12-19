package org.generation.italy.recipy.dtos;

import org.generation.italy.recipy.model.entities.User;

import java.util.List;

public class UserDetailDto {
    private long id;
    private String firstname, lastname, email, profile, pal, imgUrl, role, eatingRegime;
    private double weight, height, bfp, lbmp;
    private Character sex;
    private List<AllergyDto> allergies;
    private List<IntoleranceDto> intolerances;

    public UserDetailDto() {}

    public UserDetailDto(long id, String firstname, String lastname, String email, String profile, String pal,
                         String imgUrl, String role, String eatingRegime, double weight, double height, double bfp,
                         double lbmp, Character sex, List<AllergyDto> allergies, List<IntoleranceDto> intolerances) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.profile = profile;
        this.pal = pal;
        this.imgUrl = imgUrl;
        this.role = role;
        this.eatingRegime = eatingRegime;
        this.weight = weight;
        this.height = height;
        this.bfp = bfp;
        this.lbmp = lbmp;
        this.sex = sex;
        this.allergies = allergies;
        this.intolerances = intolerances;
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
                user.getEatingRegime().getName(),
                user.getWeight(),
                user.getHeight(),
                user.getBfp(),
                user.getLbmp(),
                user.getSex(),
                user.getAllergies().stream().map(AllergyDto::fromAllergy).toList(),
                user.getIntolerances().stream().map(IntoleranceDto::fromIntolerance).toList()
                );
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
}
