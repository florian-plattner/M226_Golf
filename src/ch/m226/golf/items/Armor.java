package ch.m226.golf.items;

import ch.m226.golf.DamageType;

import java.util.HashMap;

/**
 * An item that can be equipped to reduce damage on a mob.
 */
public class Armor extends Item{
    public HashMap<DamageType, Integer> damageReductions;

    public Armor(String name, int weight){
        super(name, weight);
        damageReductions = new HashMap<>();
    }
}
