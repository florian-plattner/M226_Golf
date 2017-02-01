package ch.m226.golf.commands;

import ch.m226.golf.Game;
import ch.m226.golf.items.Item;
import ch.m226.golf.items.Weapon;

import java.util.ArrayList;

public class Equip implements Command{
    @Override
    public boolean use(Game game, String[] args){
        if(args.length >= 1){
            ArrayList<Item> inventory = game.player.inventory;
            boolean equipped = false;
            for(Item item : inventory){
                if(item.name.equals(args[0]) && Weapon.class.isAssignableFrom(item.getClass())){
                    game.player.equippedWeapon = (Weapon)item;
                    inventory.remove(item);
                    equipped = true;
                    break;
                }else if(item.name.equals(args[0])){
                    System.out.println("That's not a weapon!");
                }else{
                    System.out.println("You don't have a " + args[0] + " in your inventory");
                }
            }
            return equipped;
        }else {
            return false;
        }
    }
}
