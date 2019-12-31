package se.kth.mal.transformator.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Asset> assets = new ArrayList<Asset>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public String getIdentifier() {
        return getName();
    }
}
