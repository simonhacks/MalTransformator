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
}
