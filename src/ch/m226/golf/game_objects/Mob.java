package ch.m226.golf.game_objects;

import ch.m226.golf.Attack;
import ch.m226.golf.Level;
import ch.m226.golf.Main;
import ch.m226.golf.items.Item;

import java.util.ArrayList;

public class Mob extends GameObject{
    public ArrayList<Item> inventory;

    public Mob(String name, int hitpoints, int x, int y){
        super(name, hitpoints, x, y);
        inventory = new ArrayList<>();
    }

    public void move(Level level, int x, int y){
        if(x > 1)x = 1;
        else if(x < -1)x = -1;
        if(y > 1)y = 1;
        else if(y < -1)y = -1;

        for(GameObject gameObject: level.gameObjects){
            if (gameObject.x == this.x + x && gameObject.y == this.y + y && gameObject.intact){
                System.out.println(Main.getArticle(gameObject.name, true) + " " + gameObject.name +
                        " is in your way!");
                x = 0;
                y = 0;
                break;
            }
        }

        this.x += x;
        this.y += y;
    }

    @Override
    public void hit(Attack attack){
        boolean alreadyDead = !intact;
        super.hit(attack);
        if(!intact && !alreadyDead){
            System.out.println("The " + name + " is dead.");
        }
    }
}
