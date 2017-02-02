package ch.m226.golf.game_objects;

import ch.m226.golf.Attack;
import ch.m226.golf.Level;

/**
 * A game object represents an object in the game world.
 */
public abstract class GameObject{
    public String name;
    public int x, y;
    public int hitpoints;
    public boolean intact;

    public GameObject(String name, int hitpoints, int x, int y){
        this.name = name;
        this.hitpoints = hitpoints;
        this.x = x;
        this.y = y;
        intact = true;
    }

    /**
     * This method is called in every game turn.
     * @param level
     */
    public void update(Level level){

    }

    /**
     * This method is called when an object is being attacked.
     * @param attack
     */
    public void hit(Attack attack){
        if(hitpoints > 0){
            hitpoints -= attack.amount;
            if(hitpoints <= 0){
                intact = false;
            }
        }
    }
}
