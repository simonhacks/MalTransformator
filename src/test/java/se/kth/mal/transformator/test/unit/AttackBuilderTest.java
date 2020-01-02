package se.kth.mal.transformator.test.unit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import se.kth.mal.transformator.builder.AttackBuilder;
import se.kth.mal.transformator.model.Asset;
import se.kth.mal.transformator.model.Attack;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AttackBuilderTest {
    private AttackBuilder attackBuilder;

    private Asset testAsset;
    private Attack testAttack;
    private String testAttackName = "Test Attack";

    private Asset testTargetAsset;
    private Attack testTargetAttack;
    private String testTargetAttackName = "Test Target";

    @BeforeAll
    public void init() {
        attackBuilder = new AttackBuilder();
        testAttack = new Attack();
        testAttack.setName(testAttackName);

        testAsset = new Asset();
        testAttack.setAsset(testAsset);

        testTargetAsset = new Asset();
        testTargetAttack = new Attack();
        testTargetAttack.setName(testTargetAttackName);
    }

    @BeforeEach
    public void prepare() {
        attackBuilder.getAttacks().clear();
        attackBuilder.getAttacks().put(testAttack.getIdentifier(), testAttack);
        testAttack.getRelatedAttacks().clear();
    }

    @Test
    public void testGetAttack_Exist() {
        Attack receivedAttack = attackBuilder.getAttack(testAsset, testAttackName, "", testTargetAsset, testTargetAttackName);

        assertSame(testAttack, receivedAttack);
    }

    @Test
    public void testGetAttack_NotExist() {
        String dummyAttackName = "Dummy Attack";
        Attack receivedAttack = attackBuilder.getAttack(testAsset, dummyAttackName);

        assertNotSame(testAttack, receivedAttack);
        assertEquals(dummyAttackName, receivedAttack.getName());
    }

    @Test
    public void testGetAttack_Exist_AddTarget() {
        attackBuilder.getAttacks().get(testAttack.getIdentifier()).getRelatedAttacks().add(new Attack());
        Attack receivedAttack = attackBuilder.getAttack(testAsset, testAttackName, "", testTargetAsset, testTargetAttackName);

        assertEquals(2, receivedAttack.getRelatedAttacks().size());
    }
}
