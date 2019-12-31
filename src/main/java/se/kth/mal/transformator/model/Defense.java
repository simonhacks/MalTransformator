package se.kth.mal.transformator.model;

import java.util.ArrayList;
import java.util.List;

public class Defense extends Step {
    private List<Attack> coveredAttacks = new ArrayList<Attack>();

    public List<Attack> getCoveredAttacks() {
        return coveredAttacks;
    }

    public void setCoveredAttacks(List<Attack> coveredAttacks) {
        this.coveredAttacks = coveredAttacks;
    }
}
