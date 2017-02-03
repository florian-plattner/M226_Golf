package ch.m226.golf.skills;

import ch.m226.golf.Level;
import ch.m226.golf.Main;
import ch.m226.golf.game_objects.GameObject;
import ch.m226.golf.game_objects.Mob;
import ch.m226.golf.game_objects.Player;

/**
 * This skill gives a mob the ability to walk.
 */
public class Walk implements Skill{

    @Override
    public void use(Level level, Mob mob, int directionX, int directionY){
        directionX = directionX == 0 ? 0 : directionX / Math.abs(directionX);
        directionY = directionY == 0 ? 0 : directionY / Math.abs(directionY);

        if (level.player.x == mob.x + directionX && level.player.y == mob.y + directionY){
            directionX = 0;
            directionY = 0;
        }

        for(GameObject gameObject: level.gameObjects){
            if (gameObject.x == mob.x + directionX && gameObject.y == mob.y + directionY && gameObject.intact){
                if(mob.getClass() == Player.class){
                    System.out.println(Main.getArticle(gameObject.name, true) + " " + gameObject.name + " is in your way!");
                }
                directionX = 0;
                directionY = 0;
                break;
            }
        }

        mob.x += directionX;
        mob.y += directionY;
    }
}
