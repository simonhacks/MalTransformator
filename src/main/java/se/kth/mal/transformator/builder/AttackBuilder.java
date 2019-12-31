package se.kth.mal.transformator.builder;

import se.kth.mal.transformator.model.Asset;
import se.kth.mal.transformator.model.Attack;

import java.util.HashMap;

public class AttackBuilder {
    private HashMap<String, Attack> attacks = new HashMap<String, Attack>();

    public Attack getAttack(Asset parentAsset, String name) {
        return getAttack(parentAsset, name, "", null, "");
    }

    public Attack getAttack(Asset parentAsset, String name, String probability, Asset targetAsset, String targetAttack) {
        Attack newAttack = new Attack();

        return newAttack;
    }
}
