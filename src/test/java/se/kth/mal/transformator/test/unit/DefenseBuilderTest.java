package se.kth.mal.transformator.test.unit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import se.kth.mal.transformator.builder.DefenseBuilder;
import se.kth.mal.transformator.model.Asset;
import se.kth.mal.transformator.model.Attack;
import se.kth.mal.transformator.model.Defense;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DefenseBuilderTest {
    private DefenseBuilder defenseBuilder;

    private Defense testDefense;
    private Asset testAsset;
    private Attack testAttack;
    private String testDefenseName = "Test Defense";

    @BeforeAll
    public void init() {
        defenseBuilder = new DefenseBuilder();
        testDefense = new Defense();
        testDefense.setName(testDefenseName);

        testAsset = new Asset();
        testDefense.setAsset(testAsset);

        testAttack = new Attack();
    }

    @BeforeEach
    public void prepare() {
        defenseBuilder.getDefenses().clear();
        defenseBuilder.getDefenses().put(testDefense.getIdentifier(), testDefense);
        testDefense.getCoveredAttacks().clear();
    }

    @Test
    public void testGetDefense_Exist() {
        Defense receivedDefense = defenseBuilder.getDefense(testAsset, testDefenseName, "", testAttack);

        assertSame(testDefense, receivedDefense);
    }

    @Test
    public void testGetDefense_NotExist() {
        String dummyDefenseName = "Dummy Defense";
        Defense receivedDefense = defenseBuilder.getDefense(testAsset, dummyDefenseName, "", testAttack);

        assertNotSame(testDefense, receivedDefense);
        assertEquals(dummyDefenseName, receivedDefense.getName());
    }

    @Test
    public void testGetDefense_Exist_AddAttack() {
        defenseBuilder.getDefenses().get(testDefense.getIdentifier()).getCoveredAttacks().add(new Attack());
        Defense receivedDefense = defenseBuilder.getDefense(testAsset, testDefenseName, "", testAttack);

        assertEquals(2, receivedDefense.getCoveredAttacks().size());
    }
}
