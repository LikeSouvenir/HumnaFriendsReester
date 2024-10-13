package org.example.ReesterCategories;

import org.example.ReesterCategories.BaseClasses.BaseClass;
import org.example.ReesterCategories.Enums.Gender;

import java.util.Date;

public class Human extends BaseClass {

    private static int countHuman = 1;
    private int id;
    String surname;

    public Human(String name, String surname, Gender gender, Date birthday) {
        super(name, gender, birthday);
        this.surname = surname;
        id = countHuman;
        countHuman++;
    }

    public Human(String name ,String surname, Gender gender) {
        super(name, gender);
        this.surname = surname;
        id = countHuman;
        countHuman++;
    }

    public static int getCountHuman(){
        return countHuman;
    }

    public int getID() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return  "\nID=" + id + ", Фамилия=" + surname + ", " + super.toString();
    }
}
