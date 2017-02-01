package ch.m226.golf.skills;

import ch.m226.golf.Level;
import ch.m226.golf.Main;
import ch.m226.golf.game_objects.GameObject;
import ch.m226.golf.game_objects.Mob;

public class Walk implements Skill{

    @Override
    public void use(Level level, Mob mob, int directionX, int directionY){
        directionX = directionX / Math.abs(directionX);
        directionY = directionY / Math.abs(directionY);

        for(GameObject gameObject: level.gameObjects){
            if (gameObject.x == mob.x + directionX && gameObject.y == mob.y + directionY && gameObject.intact){
                System.out.println(Main.getArticle(gameObject.name, true) + " " + gameObject.name + " is in your way!");
                directionX = 0;
                directionY = 0;
                break;
            }
        }

        mob.x += directionX;
        mob.y += directionY;
    }
}