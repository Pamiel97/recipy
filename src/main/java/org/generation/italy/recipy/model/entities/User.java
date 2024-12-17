package org.generation.italy.recipy.model.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Character sex;
    @Enumerated(EnumType.STRING)
    private Profile profile;
    private double weight;
    private double height;
    private double bfp;
    private double lbmp;
    @Column(name = "diet_type")
    @Enumerated(EnumType.STRING)
    private DietType dietType;
    @Enumerated(EnumType.STRING)
    private Pal pal;
    @Column(name = "img_url")
    private String imgUrl;
    @OneToMany(mappedBy = "user")
    private List<Review> review = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "user_allergies",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "allergy_id")
    )
    private List<Allergy> allergies = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "user_intolerances",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "intolerance_id")
    )
    private List<Intolerance> intolerances = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Pantry> pantries = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {}

    public User(String firstname, String lastname, String email, String encode, Role role) {
        this.name = firstname;
        this.surname = lastname;
        this.email = email;
        this.password = encode;
        this.role = role;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+role.name()));
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
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

    public DietType getDietType() {
        return dietType;
    }

    public void setDietType(DietType dietType) {
        this.dietType = dietType;
    }

    public Pal getPal() {
        return pal;
    }

    public void setPal(Pal pal) {
        this.pal = pal;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public List<Allergy> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<Allergy> allergies) {
        this.allergies = allergies;
    }

    public List<Intolerance> getIntolerances() {
        return intolerances;
    }

    public void setIntolerances(List<Intolerance> intolerances) {
        this.intolerances = intolerances;
    }

    public List<Pantry> getPantries() {
        return pantries;
    }

    public void setPantries(List<Pantry> pantries) {
        this.pantries = pantries;
    }

    public Role getRole() {
        return role;
    }
}
