package se.kth.mal.transformator.test.unit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import se.kth.mal.transformator.builder.CategoryBuilder;
import se.kth.mal.transformator.model.Category;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CategoryBuilderTest {
    private CategoryBuilder categoryBuilder;

    private Category testCategory;
    private String testCategoryName = "Test Category";

    @BeforeAll
    public void init() {
        categoryBuilder = new CategoryBuilder();
        testCategory = new Category();
        testCategory.setName(testCategoryName);
    }

    @BeforeEach
    public void prepare() {
        categoryBuilder.getCategories().clear();
        categoryBuilder.getCategories().put(testCategory.getIdentifier(), testCategory);
    }

    @Test
    public void testGetCategory_Exists() {
        Category receivedCategory = categoryBuilder.getCategory(testCategory.getIdentifier());

        assertSame(testCategory, receivedCategory);
    }

    @Test
    public void testGetCategory_NotExists() {
        String dummyCategory = "dummyCategory";
        Category receivedCategory = categoryBuilder.getCategory(dummyCategory);

        assertNotSame(testCategory, receivedCategory);
        assertEquals(dummyCategory, receivedCategory.getName());
    }
}
