package org.example.Menu.Parts;

import org.example.Base.Base;
import org.example.ReesterCategories.BaseClasses.Animal;
import org.example.ReesterCategories.Human;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Looks extends BaseMenuParagraph{

    public Looks(Base base) {
        super(base);
    }

    public String getAnimalName(String name) {
        Map<Integer, Animal> mapAnimal = base.getAllAnimal();
        for (Map.Entry<Integer, Animal> animal: mapAnimal.entrySet())
            if (animal.getValue().getName().equals(name))
                return animal.getValue().toString();
        return null;
    }

    public String getHumanSurname(String surname) {
        List<Human> humansList = base.getallHumans();
        for (Human human : humansList)
            if (human.getSurname().equals(surname))
                return human.toString();
        return null;
    }

    public String getHumanName(String name) {
        List<Human> humansList = base.getallHumans();
        for (Human human : humansList)
            if (human.getName().equals(name))
                return human.toString();
        return null;
    }

    public String getAnimalID(int id) {
        if (base.getAllAnimal().containsKey(id)) {
            Map<Integer, Animal> mapAnimal = base.getAllAnimal();
            for (Map.Entry<Integer, Animal> animal : mapAnimal.entrySet())
                if (animal.getValue().getID() == id)
                    return animal.getValue().toString() + "\n";
        }
        else return null;
    }

    public String getHumanID(int id) {
        try {
            return base.getallHumans().get(id-1).toString();
        }
        catch (Exception e) {
            return null;
        }
    }

    public String seeAllBase() {
        String out = base.getallHumans().toString() + "\n";
        Map<Integer, Animal> mapAnimal = base.getAllAnimal();
        for (Map.Entry<Integer, Animal> animal: mapAnimal.entrySet())
            out += animal.getValue().toString();
        return out;
    }
}
