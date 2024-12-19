package org.generation.italy.recipy.dtos;

import org.generation.italy.recipy.model.entities.Intolerance;

import java.util.List;

public class IntoleranceDto {
    private String name;
    private long id;

    public IntoleranceDto() {}
    public IntoleranceDto(long id, String intolerance) {
        this.name = intolerance;
        this.id = id;
    }

    public static IntoleranceDto fromIntolerance(Intolerance intolerance) {
        return new IntoleranceDto(intolerance.getId(), intolerance.getName());
    }

    public Intolerance toIntolerance() {
        Intolerance intolerance = new Intolerance();
        intolerance.setId(this.id);
        intolerance.setName(this.name);
        intolerance.setAffectedUsers(List.of());
        return intolerance;
    }


    public String getIntolerance() {
        return name;
    }
    public void setIntolerance(String intolerance) {this.name = intolerance;}


}
