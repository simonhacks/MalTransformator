package se.kth.mal.transformator.builder;

import se.kth.mal.transformator.model.Asset;
import se.kth.mal.transformator.model.Attack;
import se.kth.mal.transformator.model.Category;
import se.kth.mal.transformator.model.Defense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AssetBuilder {
    private HashMap<String, Asset> assets = new HashMap<String, Asset>();
    private CategoryBuilder categoryBuilder = new CategoryBuilder();
    private AttackBuilder attackBuilder = new AttackBuilder();
    private DefenseBuilder defenseBuilder = new DefenseBuilder();

    public Asset getAsset(String name) {
        return getAsset("", name, new ArrayList<AttackDescription>(), new ArrayList<DefenseDescription>());
    }

    public Asset getAsset(String category, String name, List<AttackDescription> attacks, List<DefenseDescription> defenses) {
        if (attacks == null || defenses == null) {
            throw new IllegalArgumentException("Parameters are not allowed to be null.");
        }

        Asset newAsset = new Asset();

        newAsset.setName(name);

        Category assetCategory = categoryBuilder.getCategory(category);
        newAsset.setCategory(assetCategory);

        for (AttackDescription description : attacks) {
            Attack attack = attackBuilder.getAttack(
                    newAsset,
                    description.getName(),
                    description.getProbability(),
                    getAsset(description.getTargetAsset()),
                    description.getTargetAttack()
            );
            newAsset.getAttacks().add(attack);
        }

        for (DefenseDescription description : defenses) {
            Defense defense = defenseBuilder.getDefense(
                    newAsset,
                    description.getName(),
                    description.getProbability(),
                    attackBuilder.getAttack(getAsset(description.getTargetAsset()), description.getTargetAttack())
            );
            newAsset.getDefenses().add(defense);
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
