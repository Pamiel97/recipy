package org.generation.italy.recipy.dtos;

import org.generation.italy.recipy.model.entities.Allergy;

public class AllergyDto {
    private String allergy;

    public AllergyDto() {}
    public AllergyDto(String allergy) {
        this.allergy = allergy;
    }

    public static AllergyDto fromAllergy(Allergy allergy) {
        return new AllergyDto(allergy.getName());
    }

    public String getAllergy() {return this.allergy;}
    public void setAllergy(String allergy) {this.allergy = allergy;}
}
