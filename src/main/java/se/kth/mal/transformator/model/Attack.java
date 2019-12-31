package se.kth.mal.transformator.model;

import java.util.ArrayList;
import java.util.List;

public class Attack extends Step {
    private List<Attack> relatedAttacks = new ArrayList<Attack>();
    private AttackType type;

    public List<Attack> getRelatedAttacks() {
        return relatedAttacks;
    }

    public void setRelatedAttacks(List<Attack> relatedAttacks) {
        this.relatedAttacks = relatedAttacks;
    }

    public AttackType getType() {
        return type;
    }

    public void setType(AttackType type) {
        this.type = type;
    }

    public void merge(Attack other) {
        this.setProbability(other.getProbability());
        this.setName(other.getName());
        this.setAsset(other.getAsset());
        this.getRelatedAttacks().addAll(other.getRelatedAttacks());
        this.setType(other.getType());
    }
}
