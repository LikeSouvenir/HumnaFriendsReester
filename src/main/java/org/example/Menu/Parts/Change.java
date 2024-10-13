package org.example.Menu.Parts;

import org.example.Base.Base;
import org.example.ReesterCategories.BaseClasses.Animal;
import org.example.ReesterCategories.Cats;
import org.example.ReesterCategories.Dogs;
import org.example.ReesterCategories.Enums.TypeHarness;
import org.example.ReesterCategories.Enums.WorkType;
import org.example.ReesterCategories.Hoofeds;

import java.util.Map;

public class Change extends BaseMenuParagraph{
    public Change(Base base) {
        super(base);
    }

    public boolean rmCommands(int idAnimal, String command) {
        if (checkHoofeds(idAnimal)) {
            Hoofeds hoofeds = (Hoofeds) base.getAllAnimal().get(idAnimal);
            hoofeds.getCommand().rmCommand(command);
            return true;
        }
        else if (checkDogs(idAnimal)) {
            Dogs dog = (Dogs) base.getAllAnimal().get(idAnimal);
            dog.getCommand().rmCommand(command);
            return true;
        }
        return false;
    }

    public boolean addCommands(int idAnimal, String command) {
        if (checkHoofeds(idAnimal)) {
            Hoofeds hoofeds = (Hoofeds) base.getAllAnimal().get(idAnimal);
            hoofeds.getCommand().addCommand(command);
            return true;
        }
        else if (checkDogs(idAnimal)) {
            Dogs dog = (Dogs) base.getAllAnimal().get(idAnimal);
            dog.getCommand().addCommand(command);
            return true;
        }
        return false;
    }

    public boolean changeHarness(int idAnimal, TypeHarness harness) {
        if (checkHoofeds(idAnimal)) {
            Hoofeds hoofeds = (Hoofeds) base.getAllAnimal().get(idAnimal);
            hoofeds.setTypeHarness(harness);
            return true;
        }
        return false;
    }

    public boolean changeWorkType(int idAnimal, WorkType workType) {
        if (checkHoofeds(idAnimal)) {
            Hoofeds hoofeds = (Hoofeds) base.getAllAnimal().get(idAnimal);
            hoofeds.setWorkType(workType);
            return true;
        }
        return false;
    }

    public boolean checkHoofeds(int idAnimal) {
        if (base.getAllAnimal().get(idAnimal).getClass() == Hoofeds.class) return true;
        return false;
    }
    public boolean checkDogs(int idAnimal) {
        if (base.getAllAnimal().get(idAnimal).getClass() == Dogs.class) return true;
        return false;
    }
    public boolean checkCats(int idAnimal) {
        if (base.getAllAnimal().get(idAnimal).getClass() == Cats.class) return true;
        return false;
    }

    public boolean chacngeOwner(int idNewOwner, int idAnimal) {
        try {
            base.changeAnimalOwner(idNewOwner, idAnimal);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
