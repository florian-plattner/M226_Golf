package ch.m226.golf.game_objects;

import ch.m226.golf.Attack;

public class Player extends Mob{

    public Player(int hitpoints, int x, int y){
        super("player", hitpoints, x, y);
    }

    @Override
    public void hit(Attack attack){
        System.out.println("You got hit and took " + attack.amount + " damage.");
        super.hit(attack);
    }
}
