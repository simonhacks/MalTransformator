package se.kth.mal.transformator.model;

public abstract class Step {
    private String name;
    private Probability probability;
    private Asset asset;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Probability getProbability() {
        return probability;
    }

    public void setProbability(Probability probability) {
        this.probability = probability;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }
}
