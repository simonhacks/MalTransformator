package se.kth.mal.transformator.builder;

import se.kth.mal.transformator.model.Asset;
import se.kth.mal.transformator.model.Attack;
import se.kth.mal.transformator.model.Probability;

import java.util.HashMap;

public class AttackBuilder {
    private HashMap<String, Attack> attacks = new HashMap<String, Attack>();

    public Attack getAttack(Asset parentAsset, String name) {
        return getAttack(parentAsset, name, "", null, "");
    }

    public Attack getAttack(Asset parentAsset, String name, String probability, Asset targetAsset, String targetAttack) {
        Attack newAttack = new Attack();

        newAttack.setAsset(parentAsset);
        newAttack.setName(name);
        newAttack.setProbability(new Probability(probability));
        newAttack.getRelatedAttacks().add(getAttack(targetAsset, targetAttack));

        if (attacks.containsKey(newAttack.getIdentifier())) {
            attacks.get(newAttack.getIdentifier()).merge(newAttack);
            newAttack = attacks.get(newAttack.getIdentifier());
        } else {
            attacks.put(newAttack.getIdentifier(), newAttack);
        }

        return newAttack;
    }
}
