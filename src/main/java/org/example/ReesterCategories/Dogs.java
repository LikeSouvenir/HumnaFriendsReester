package org.example.ReesterCategories;

import org.example.ReesterCategories.Attributes.Commands;
import org.example.ReesterCategories.Attributes.Skills;
import org.example.ReesterCategories.BaseClasses.Animal;
import org.example.ReesterCategories.Enums.Gender;

import java.util.Date;
import java.util.ArrayList;

public class Dogs extends Animal {
    Commands commands = new Commands(new ArrayList<>());
    Skills skills = new Skills();

    public Dogs(String name, Gender gender, Date birthday, String breed) {
        super(name, gender, birthday, breed);
    }

    public Dogs(String name, Gender gender, String breed) {
        super(name, gender, breed);
    }

    public Commands getCommand() {
        return commands;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
