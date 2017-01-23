package ch.m226.golf.items;

import ch.m226.golf.DamageType;

import java.util.HashMap;

public class Armor extends Item{
    public HashMap<DamageType, Integer> damageReductions;

    public Armor(String name, int weight){
        super(name, weight);
        damageReductions = new HashMap<>();
    }
}
