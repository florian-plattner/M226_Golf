package ch.m226.golf;

import ch.m226.golf.game_objects.GameObject;
import ch.m226.golf.game_objects.Player;

import java.util.ArrayList;

public class Level{
    private Player player;
    public ArrayList<GameObject> gameObjects;

    public Level(){
        gameObjects = new ArrayList<>();
    }

    public void setPlayer(Player player){
        this.player = player;
        gameObjects.add(player);
    }

    public Player getPlayer(){
        return player;
    }
}
