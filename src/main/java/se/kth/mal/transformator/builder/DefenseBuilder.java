package se.kth.mal.transformator.builder;

import se.kth.mal.transformator.model.Asset;
import se.kth.mal.transformator.model.Attack;
import se.kth.mal.transformator.model.Defense;
import se.kth.mal.transformator.model.Probability;

import java.util.HashMap;

public class DefenseBuilder {
    private HashMap<String, Defense> defenses = new HashMap<String, Defense>();

    public Defense getDefense(Asset parentAsset, String name, String probability, Attack coveredAttack) {
        Defense newDefense = new Defense();

        newDefense.setAsset(parentAsset);
        newDefense.setName(name);
        newDefense.setProbability(new Probability(probability));
        newDefense.getCoveredAttacks().add(coveredAttack);

        if (defenses.containsKey(newDefense.getIdentifier())) {
            defenses.get(newDefense.getIdentifier()).merge(newDefense);
            newDefense = defenses.get(newDefense.getIdentifier());
        } else {
            defenses.put(newDefense.getIdentifier(), newDefense);
        }

        return newDefense;
    }
}
