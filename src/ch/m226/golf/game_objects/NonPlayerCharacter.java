package ch.m226.golf.game_objects;

import ch.m226.golf.Level;

public class NonPlayerCharacter extends Mob{

    public NonPlayerCharacter(String name, int hitpoints, int x, int y){
        super(name, hitpoints, x, y);
    }

    @Override
    public void update(Level level){
        int directionX = 0;
        int directionY = 0;

        if(level.player.x - x == 0){
            if(level.player.y > y){
                directionY = 1;
            }else if(level.player.y < y){
                directionY = -1;
            }
        }else if(level.player.y - y == 0){
            if(level.player.x > x){
                directionX = 1;
            }else if(level.player.x < x){
                directionX = -1;
            }
        }

        if(equippedWeapon != null && (directionX != 0 || directionY != 0)){
            skills.get("walk").use(level, this, directionX, directionY);
            skills.get("attack").use(level, this, directionX, directionY);
        }

//        System.out.println(x);
//        System.out.println(y);
    }
}
