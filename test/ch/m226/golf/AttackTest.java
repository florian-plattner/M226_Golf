package ch.m226.golf;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class AttackTest {
    @BeforeEach
    void setUp() {
        DamageType damageType = DamageType.PIERCING;
        int amount = 5;
        Attack attack = new Attack(damageType, amount);
        assertEquals(damageType, attack.type);
        assertEquals(amount, attack.amount);
    }

}