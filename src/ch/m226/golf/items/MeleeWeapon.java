package ch.m226.golf.items;

import ch.m226.golf.Attack;
import ch.m226.golf.DamageType;
import ch.m226.golf.Level;
import ch.m226.golf.Main;
import ch.m226.golf.game_objects.GameObject;

public class MeleeWeapon extends Weapon{

    public MeleeWeapon(String name, int weight, DamageType damageType, int damage){
        super(name, weight, damageType, damage);
    }

    @Override
    public void attack(Level level, int directionX, int directionY, int x, int y){
        if(directionX > 1)directionX = 1;
        else if(directionX < -1)directionX = -1;
        if(directionY > 1)directionY = 1;
        else if(directionY < -1)directionY = -1;

        boolean hit = false;
        for(GameObject gameObject: level.gameObjects){
            if(gameObject.x == x + directionX && gameObject.y == y + directionY){
                if(gameObject.intact){
                    System.out.println("You hit " + Main.getArticle(gameObject.name, false) + " " +
                                       gameObject.name + ".");
                }else{
                    System.out.println("You hit the corps of " + Main.getArticle(gameObject.name, false) + " " +
                                       gameObject.name + ".");
                }
                gameObject.hit(new Attack(damageType, damage));
                hit = true;
            }
        }

        if(!hit){
            System.out.println("You did not hit anything.");
        }
    }
}
