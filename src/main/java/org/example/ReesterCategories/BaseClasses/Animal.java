package org.example.ReesterCategories.BaseClasses;

import org.example.ReesterCategories.Enums.Gender;

import java.util.Date;

public abstract class Animal extends BaseClass {
    private static int countAnimal = 1;
    private int id;
    String breed;

    public Animal(String name, Gender gender, Date birthday, String breed) {
        super(name, gender, birthday);
        this.breed = breed;
        id = countAnimal;
        countAnimal++;
    }

    public Animal(String name, Gender gender, String breed) {
        super(name, gender);
        this.breed = breed;
        id = countAnimal;
        countAnimal++;
    }

    public int getID() {
        return id;
    }

    public static int getCountAnimal() {
        return countAnimal;
    }

    @Override
    public String toString() {
        return "\nID=" + id + ", " + super.toString() + ", " + "порода=" + breed;
    }
}
