package se.kth.mal.transformator.builder;

import se.kth.mal.transformator.model.Asset;
import se.kth.mal.transformator.model.Attack;
import se.kth.mal.transformator.model.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AssetBuilder {
    private HashMap<String, Asset> assets = new HashMap<String, Asset>();
    private CategoryBuilder categoryBuilder = new CategoryBuilder();
    private AttackBuilder attackBuilder = new AttackBuilder();

    public Asset getAsset(String name) {
        return getAsset("", name, new ArrayList<AttackDescription>());
    }

    public Asset getAsset(String category, String name, List<AttackDescription> attacks) {
        Asset newAsset = new Asset();

        newAsset.setName(name);

        Category assetCategory = categoryBuilder.getCategory(category);
        newAsset.setCategory(assetCategory);

        for (AttackDescription description : attacks) {
            Attack attack = attackBuilder.getAttack(
                    newAsset,
                    description.name,
                    description.probability,
                    getAsset(description.targetAsset),
                    description.targetAttack
            );
            newAsset.getAttacks().add(attack);
        }

        if (assets.containsKey(newAsset.getIdentifier())) {
            assets.get(newAsset.getIdentifier()).merge(newAsset);
            newAsset = assets.get(newAsset.getIdentifier());
        } else {
            assets.put(newAsset.getIdentifier(), newAsset);
            assetCategory.getAssets().add(newAsset);
        }

        return newAsset;
    }

    public HashMap<String, Asset> getAssets() {
        return assets;
    }
}
