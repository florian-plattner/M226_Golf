package ch.m226.golf.game_objects;

import ch.m226.golf.Level;

public class NonPlayerCharacter extends Mob{

    public NonPlayerCharacter(String name, int hitpoints, int x, int y){
        super(name, hitpoints, x, y);
    }

    @Override
    public void update(Level level){
        int distanceX = level.player.x - x;
        int distanceY = level.player.y - y;
        if(Math.abs(distanceX) < 4 && Math.abs(distanceY) < 4 && distanceX != 0 && distanceY != 0){
            int directionX = distanceX / Math.abs(distanceX);
            int directionY = distanceY / Math.abs(distanceY);

            if(Math.abs(distanceX) > 1) x += directionX;
            if(Math.abs(distanceY) > 1) y += directionY;


        }
    }
}
