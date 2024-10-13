package org.example.Base;

import org.example.ReesterCategories.BaseClasses.Animal;
import org.example.ReesterCategories.Human;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import static org.example.ReesterCategories.BaseClasses.Animal.getCountAnimal;
import static org.example.ReesterCategories.Human.getCountHuman;

public class Base {
    Map <Integer, Animal> animals = new HashMap<Integer, Animal>();
    List<Human> humans = new ArrayList<Human>();
    Map<Integer, Integer> whoOwner = new HashMap<Integer, Integer>();


    public int getCountHumans() {
        return getCountHuman();
    }

    public int getCountAnimals() {
        return getCountAnimal();
    }

    public void changeAnimalOwner(int idNewOwer, int idAnimal) {
        whoOwner.put(idAnimal, idNewOwer);
    }

    public void addAnimal(int idOnwer, Animal animal) {
        animals.put(animal.getID(), animal);
        whoOwner.put(getCountAnimal(), idOnwer);
    }

    public Map getAllAnimal() {
        return animals;
    }

    public void addHuman(Human human) {
        humans.add(human);
    }

    public Map getAllOwners() {
        return whoOwner;
    }

    public List<Human> getallHumans() {
        return humans;
    }
}
