package org.example.ReesterCategories;

import org.example.ReesterCategories.Attributes.Commands;
import org.example.ReesterCategories.BaseClasses.Animal;
import org.example.ReesterCategories.Enums.Gender;
import org.example.ReesterCategories.Enums.TypeHarness;
import org.example.ReesterCategories.Enums.WorkType;

import java.util.Date;
import java.util.ArrayList;

public class Hoofeds  extends Animal {
    int middleWeigth;
    WorkType workType;
    TypeHarness typeHarness;
    Commands commands = new Commands(new ArrayList<String>());

    public Hoofeds(String name, Gender gender, Date birthday, String breed, int middleWeigth, WorkType workType, TypeHarness typeHarness) {
        super(name, gender, birthday, breed);
        this.middleWeigth = middleWeigth;
        this.workType = workType;
        this.typeHarness = typeHarness;
    }
    public Hoofeds(String name, Gender gender, Date birthday, String breed, int middleWeigth) {
        super(name, gender, birthday, breed);
        this.middleWeigth = middleWeigth;
    }
    public Hoofeds(String name, Gender gender, Date birthday, String breed, int middleWeigth,  TypeHarness typeHarness) {
        super(name, gender, birthday, breed);
        this.middleWeigth = middleWeigth;
        this.typeHarness = typeHarness;
    }
    public Hoofeds(String name, Gender gender, Date birthday, String breed, int middleWeigth, WorkType workType) {
        super(name, gender, birthday, breed);
        this.middleWeigth = middleWeigth;
        this.workType = workType;
    }
    public Hoofeds(String name, Gender gender, Date birthday, String breed) {
        super(name, gender, birthday, breed);
    }
    public Hoofeds(String name, Gender gender, String breed) {
        super(name, gender, breed);
    }

    public Commands getCommand() {
        return commands;
    }

    public int getMiddleWeigth() {
        return middleWeigth;
    }

    public void setMiddleWeigth(int middleWeigth) {
        this.middleWeigth = middleWeigth;
    }

    public WorkType getWorkType() {
        return workType;
    }

    public void setWorkType(WorkType workType) {
        this.workType = workType;
    }

    public TypeHarness getTypeHarness() {
        return typeHarness;
    }

    public void setTypeHarness(TypeHarness typeHarness) {
        this.typeHarness = typeHarness;
    }

    @Override
    public String toString() {
        return  super.toString() + ", " +
                "средний вес=" + middleWeigth +
                ", тип работы=" + workType +
                ", тип упряжи=" + typeHarness;
    }
}
