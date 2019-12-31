package se.kth.mal.transformator.builder;

public class AttackDescription {
    String name;
    String targetAsset;
    String targetAttack;
    String probability;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTargetAsset() {
        return targetAsset;
    }

    public void setTargetAsset(String targetAsset) {
        this.targetAsset = targetAsset;
    }

    public String getTargetAttack() {
        return targetAttack;
    }

    public void setTargetAttack(String targetAttack) {
        this.targetAttack = targetAttack;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }
}
