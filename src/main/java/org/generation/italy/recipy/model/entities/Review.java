package org.generation.italy.recipy.model.entities;

import java.time.LocalDate;

public class Review {
    long id;
    String text;
    double rating;

    LocalDate creationDate;
    //controllare


    User user;
    Recipe recipe;
}
