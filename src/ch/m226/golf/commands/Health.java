package ch.m226.golf.commands;

import ch.m226.golf.Game;

public class Health implements Command{
    @Override
    public boolean use(Game game, String[] args) {
        System.out.println("You have " + game.player.hitpoints + " hitpoints.");
        return true;
    }
}
