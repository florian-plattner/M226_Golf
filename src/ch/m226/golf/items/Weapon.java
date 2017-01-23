package ch.m226.golf.items;

import ch.m226.golf.DamageType;
import ch.m226.golf.Level;

public class Weapon extends Item{
    public DamageType damageType;
    public int damage;

    public Weapon(String name, int weight, DamageType damageType, int damage){
        super(name, weight);
        this.damageType = damageType;
        this.damage = damage;
    }

    public void attack(Level level, int directionX, int directionY, int x, int y){
    }
}
