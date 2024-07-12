package org.example.exercice5.model;

import java.time.LocalDate;

public class Dog {
    private int id;
    private static int nbDogs = 0;
    private String name;
    private String breed;
    private LocalDate birthDate;

    public Dog(String name, String breed, LocalDate birthDate) {
        this.id = ++nbDogs;
        this.name = name;
        this.breed = breed;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
