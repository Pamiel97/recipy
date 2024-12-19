package org.generation.italy.recipy.dtos;

import org.generation.italy.recipy.model.entities.Allergy;

import java.util.List;

public class AllergyDto {
    private long id;
    private String name;


    public AllergyDto() {}
    public AllergyDto(long id, String allergy) {
        this.name = allergy;
        this.id = id;
    }

    public static AllergyDto fromAllergy(Allergy allergy) {
        return new AllergyDto(allergy.getId(), allergy.getName());
    }
    public Allergy toAllergy(){
        Allergy allergy = new Allergy();
        allergy.setId(this.id);
        allergy.setName(this.name);
        allergy.setAffectedUsers(List.of());
        return allergy;
    }

    public String getName() {return this.name;}
    public void setName(String name) {this.name = name;}
}
