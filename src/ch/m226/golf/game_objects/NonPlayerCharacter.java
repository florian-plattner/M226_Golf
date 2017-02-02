package ch.m226.golf.game_objects;

import ch.m226.golf.Level;

public class NonPlayerCharacter extends Mob{

    public NonPlayerCharacter(String name, int hitpoints, int x, int y){
        super(name, hitpoints, x, y);
    }

    @Override
    public void update(Level level){

    }
}
