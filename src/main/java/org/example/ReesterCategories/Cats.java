package org.example.ReesterCategories;

import org.example.ReesterCategories.BaseClasses.Animal;
import org.example.ReesterCategories.Enums.Gender;

import java.util.Date;

public class Cats extends Animal {
    public Cats(String name, Gender gender, Date birthday, String breed) {
        super(name, gender, birthday, breed);
    }

    public Cats(String name, Gender gender, String breed) {
        super(name, gender, breed);
    }
    public void catchMouse() {};

    @Override
    public String toString() {
        return super.toString();
    }
}