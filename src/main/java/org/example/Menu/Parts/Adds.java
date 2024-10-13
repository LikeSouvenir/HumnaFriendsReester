package org.example.Menu.Parts;

import org.example.Base.Base;
import org.example.ReesterCategories.BaseClasses.Animal;
import org.example.ReesterCategories.Cats;
import org.example.ReesterCategories.Dogs;
import org.example.ReesterCategories.Hoofeds;
import org.example.ReesterCategories.Human;

public class Adds extends BaseMenuParagraph{
    public Adds(Base base) {
        super(base);
    }

    public void addHuman(Human human) {
        base.addHuman(human);
    }

    public void addAnimal(Animal animal, int idNewOwner) {
        base.addAnimal(idNewOwner, animal);
    }
}
