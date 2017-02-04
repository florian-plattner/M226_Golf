package ch.m226.golf.items;

import ch.m226.golf.DamageType;
import ch.m226.golf.Level;

/**
 * An item that can be used for attacking.
 */
public abstract class Weapon extends Item{
    public DamageType damageType;
    public int damage;
    public boolean output;

    public Weapon(String name, int weight, DamageType damageType, int damage){
        super(name, weight);
        this.damageType = damageType;
        this.damage = damage;
        output = false;
    }

    public void attack(Level level, int directionX, int directionY, int x, int y){
    }
}
