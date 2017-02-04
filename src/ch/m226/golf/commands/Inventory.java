package ch.m226.golf.commands;

import ch.m226.golf.Game;
import ch.m226.golf.items.Item;

/**
 * Is used to view the inventory of the player.
 */
public class Inventory implements Command {
    @Override
    public boolean use(Game game, String[] args) {
        System.out.println("Equipped: " +
                (game.player.equippedWeapon != null ? game.player.equippedWeapon.name : "null"));

        for(Item item : game.player.inventory){
            System.out.println(item.name);
        }
        System.out.println();
        return true;
    }
}
