package se.kth.mal.transformator.builder;

import se.kth.mal.transformator.model.Category;

import java.util.HashMap;

public class CategoryBuilder {
    private HashMap<String, Category> categories = new HashMap<String, Category>();

    public Category getCategory(String name) {
        Category newCategory = new Category();

        newCategory.setName(name);

        if (categories.containsKey(newCategory.getIdentifier())) {
            newCategory = categories.get(newCategory.getIdentifier());
        } else {
            categories.put(newCategory.getIdentifier(), newCategory);
        }

        return newCategory;
    }
}
