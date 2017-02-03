package ch.m226.golf.commands;

import ch.m226.golf.Game;
import ch.m226.golf.items.Item;

public class ShowInventory implements Command {
    @Override
    public boolean use(Game game, String[] args) {
        for(Item item : game.player.inventory){
            System.out.println(item.name);
        }
        System.out.println();
        return true;
    }
}
