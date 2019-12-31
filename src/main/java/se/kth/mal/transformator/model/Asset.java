package se.kth.mal.transformator.model;

import java.util.ArrayList;
import java.util.List;

public class Asset {
    private Category category;
    private List<Attack> attacks = new ArrayList<Attack>();
    private List<Defense> defenses = new ArrayList<Defense>();
    private String name;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
    }

    public List<Defense> getDefenses() {
        return defenses;
    }

    public void setDefenses(List<Defense> defenses) {
        this.defenses = defenses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}