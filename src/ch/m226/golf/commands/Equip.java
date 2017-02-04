package ch.m226.golf.commands;

import ch.m226.golf.Game;
import ch.m226.golf.items.Item;
import ch.m226.golf.items.Weapon;

import java.util.ArrayList;

/**
 * The command used to equip a weapon.
 */
public class Equip implements Command {
    @Override
    public boolean use(Game game, String[] args) {
        if (args.length >= 1) {
            ArrayList<Item> inventory = game.player.inventory;
            boolean equipped = false;
            for (Item item : inventory) {
                if (item.name.equals(args[0]) && Weapon.class.isAssignableFrom(item.getClass())) {
                    if(game.player.equippedWeapon != null){
                        inventory.add(game.player.equippedWeapon);
                    }
                    game.player.equippedWeapon = (Weapon) item;
                    inventory.remove(item);
                    equipped = true;
                    break;
                } else if (item.name.equals(args[0])) {
                    System.out.println("That's not a weapon!");
                }
            }
            if (!equipped) {
                System.out.println("You don't have a " + args[0] + " in your inventory");
            }

            return equipped;
        } else {
            return false;
        }
    }
}
