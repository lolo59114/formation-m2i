package org.example.exercice4.model;

import java.time.LocalDate;

public class Cat {
    String name;
    String race;
    String favoriteMeal;
    LocalDate birthDay;

    public Cat(String name, String race, String favoriteMeal, LocalDate birthDay) {
        this.name = name;
        this.race = race;
        this.favoriteMeal = favoriteMeal;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getFavoriteMeal() {
        return favoriteMeal;
    }

    public void setFavoriteMeal(String favoriteMeal) {
        this.favoriteMeal = favoriteMeal;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
}
