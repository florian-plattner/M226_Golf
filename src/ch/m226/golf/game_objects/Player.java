package ch.m226.golf.game_objects;

import ch.m226.golf.Level;
import ch.m226.golf.items.Item;
import ch.m226.golf.items.Weapon;

public class Player extends Mob{

    public Player(String name, int hitpoints, int x, int y){
        super(name, hitpoints, x, y);
    }

    public boolean useWeapon(Level level, String weapon, int directionX, int directionY){
        boolean isItem = false, isWeapon = false;
        for(Item item: inventory){
            if(weapon.equals(item.name)){
                isItem = true;
                if(Weapon.class.isAssignableFrom(item.getClass())){
                    isWeapon = true;
                    ((Weapon)item).attack(level, directionX, directionY, x, y);
                }else{
                    System.out.println("That's not a weapon!");
                }
            }
        }

        if(!isItem){
            System.out.println("You don't have a " + weapon + " in your inventory");
        }

        return isWeapon;
    }
}
