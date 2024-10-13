package org.example.ReesterCategories.BaseClasses;

import org.example.ReesterCategories.Enums.Gender;

import java.util.Date;

public abstract class BaseClass {
    String name;
    Gender gender;
    Date birthday;

    public BaseClass(String name,  Gender gender, Date birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }
    public BaseClass(String name,  Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Имя=" + name +
                ", пол=" + gender +
                ", день рождения=" + birthday;
    }
}
