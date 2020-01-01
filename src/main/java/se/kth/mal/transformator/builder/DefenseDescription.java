package se.kth.mal.transformator.builder;

public class DefenseDescription {
    private String name;
    private String probability;
    private String targetAsset;
    private String targetAttack;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
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
}
