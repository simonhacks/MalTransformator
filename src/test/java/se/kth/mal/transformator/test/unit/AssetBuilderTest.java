package se.kth.mal.transformator.test.unit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import se.kth.mal.transformator.builder.AssetBuilder;
import se.kth.mal.transformator.builder.AttackDescription;
import se.kth.mal.transformator.builder.DefenseDescription;
import se.kth.mal.transformator.model.Asset;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AssetBuilderTest {
    private AssetBuilder assetBuilder;
    private Asset testAsset;
    private String testAssetName = "Test Asset";
    private String testCategory = "Test Category";
    private List<AttackDescription> attacks;
    private List<DefenseDescription> defenses;
    private AttackDescription testAttack;
    private DefenseDescription testDefense;

    @BeforeAll
    public void init() {
        assetBuilder = new AssetBuilder();
        testAsset = new Asset();
        testAsset.setName(testAssetName);
        attacks = new ArrayList<>();
        defenses = new ArrayList<>();
        testAttack = new AttackDescription();
        testDefense = new DefenseDescription();
    }

    @BeforeEach
    public void prepare() {
        assetBuilder.getAssets().clear();
        testAsset.getDefenses().clear();
        testAsset.getAttacks().clear();
        defenses.clear();
        attacks.clear();

        assetBuilder.getAssets().put(testAsset.getIdentifier(), testAsset);
        defenses.add(testDefense);
        attacks.add(testAttack);
    }

    @Test
    public void testGetAsset_Exist() {
        Asset receivedAsset = assetBuilder.getAsset(testAsset.getIdentifier());

        assertSame(testAsset, receivedAsset);
    }

    @Test
    public void testGetAsset_NotExist() {
        String assetDummyName = "Dummy Asset";

        Asset receivedAsset = assetBuilder.getAsset(assetDummyName);

        assertNotSame(testAsset, receivedAsset);
        assertEquals(assetDummyName, receivedAsset.getName());
    }

    @Test
    public void testGetAsset_AttacksNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> assetBuilder.getAsset(testCategory, testAssetName, null, new ArrayList<>())
        );
    }

    @Test
    public void testGetAsset_DefensesNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> assetBuilder.getAsset(testCategory, testAssetName, new ArrayList<>(), null)
        );
    }

    @Test
    public void testGetAsset_Attacks1() {
        Asset receivedAsset = assetBuilder.getAsset(testCategory, testAssetName, attacks, new ArrayList<>());

        assertEquals(1, receivedAsset.getAttacks().size());
    }

    @Test
    public void testGetAsset_Attacks2() {
        attacks.add(new AttackDescription());
        Asset receivedAsset = assetBuilder.getAsset(testCategory, testAssetName, attacks, new ArrayList<>());

        assertEquals(2, receivedAsset.getAttacks().size());
    }

    @Test
    public void testGetAsset_Defenses1() {
        Asset receivedAsset = assetBuilder.getAsset(testCategory, testAssetName, new ArrayList<>(), defenses);

        assertEquals(1, receivedAsset.getDefenses().size());
    }

    @Test
    public void testGetAsset_Defenses2() {
        defenses.add(new DefenseDescription());
        Asset receivedAsset = assetBuilder.getAsset(testCategory, testAssetName, new ArrayList<>(), defenses);

        assertEquals(2, receivedAsset.getDefenses().size());
    }
}
