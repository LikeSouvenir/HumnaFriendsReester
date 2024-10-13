package org.example.ReesterCategories.Attributes;

import java.util.ArrayList;
import java.util.List;

public class Skills {
    List<Skills> skills = new ArrayList<Skills>();

    public void addSkill(Skills newSkill) {
        skills.add(newSkill);
    }

    public List getSkills() {return skills;}

    public void rmSkill(Skills rmSkill) {
        if (skills.contains(rmSkill)) skills.remove(rmSkill);
    }

    public void clearSlikks() {skills.clear();}

}
