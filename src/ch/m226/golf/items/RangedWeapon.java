package ch.m226.golf.items;

import ch.m226.golf.Attack;
import ch.m226.golf.DamageType;
import ch.m226.golf.Level;
import ch.m226.golf.Main;
import ch.m226.golf.game_objects.GameObject;

/**
 * A weapon for ranged combat.
 */
public class RangedWeapon extends Weapon{
    public int range;

    public RangedWeapon(String name, int weight, DamageType damageType, int damage, int range){
        super(name, weight, damageType, damage);
        this.range = range;
    }

    @Override
    public void attack(Level level, int directionX, int directionY, int x, int y){
        if(directionX > 1)directionX = 1;
        else if(directionX < -1)directionX = -1;
        if(directionY > 1)directionY = 1;
        else if(directionY < -1)directionY = -1;

        boolean hit = false;
        for(int i = 1; i < range && !hit; i++){
            for(GameObject gameObject: level.gameObjects){
                if(gameObject.x == x + directionX * i && gameObject.y == y + directionY * i){
                    if(gameObject.intact){
                        System.out.println("You shoot " + Main.getArticle(gameObject.name, false) + " " +
                                           gameObject.name + ".");
                    }else{
                        System.out.println("You shoot the corps of " + Main.getArticle(gameObject.name, false) + " " +
                                           gameObject.name + ".");
                    }
                    gameObject.hit(new Attack(damageType, damage));
                    hit = true;
                }
            }
        }

        if(!hit){
            System.out.println("You did not hit anything.");
        }
    }
}
