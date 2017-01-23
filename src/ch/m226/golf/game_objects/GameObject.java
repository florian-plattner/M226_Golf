package ch.m226.golf.game_objects;

import ch.m226.golf.Attack;

public class GameObject{
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

    public void hit(Attack attack){
        hitpoints -= attack.amount;
        if(hitpoints <= 0){
            intact = false;
        }
    }
}
