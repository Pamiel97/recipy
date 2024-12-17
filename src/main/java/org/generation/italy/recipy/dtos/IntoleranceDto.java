package org.generation.italy.recipy.dtos;

import org.generation.italy.recipy.model.entities.Intolerance;

public class IntoleranceDto {
    private String intolerance;

    public IntoleranceDto() {}
    public IntoleranceDto(String intolerance) {
        this.intolerance = intolerance;
    }

    public static IntoleranceDto fromIntolerance(Intolerance intolerance) {
        return new IntoleranceDto(intolerance.getName());
    }

    public String getIntolerance() {
        return intolerance;
    }
    public void setIntolerance(String intolerance) {this.intolerance = intolerance;}
}
