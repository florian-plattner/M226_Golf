package ch.m226.golf.game_objects;

import ch.m226.golf.Attack;
import ch.m226.golf.Level;
import ch.m226.golf.Main;
import ch.m226.golf.items.Item;
import ch.m226.golf.items.Weapon;
import ch.m226.golf.skills.Skill;
import ch.m226.golf.skills.Walk;
import ch.m226.golf.skills.WeaponAttack;

import java.util.ArrayList;
import java.util.HashMap;

public class Mob extends GameObject{
    public ArrayList<Item> inventory;
    public HashMap<String, Skill> skills;
    public Weapon equippedWeapon;

    public Mob(String name, int hitpoints, int x, int y){
        super(name, hitpoints, x, y);
        inventory = new ArrayList<>();
        skills = new HashMap<>();
        equippedWeapon = null;
        skills.put("walk", new Walk());
        skills.put("attack", new WeaponAttack());
    }

    @Override
    public void hit(Attack attack){
        boolean alreadyDead = !intact;
        super.hit(attack);
        if(!intact && !alreadyDead){
            System.out.println("The " + name + " is dead.");
        }
    }
}
