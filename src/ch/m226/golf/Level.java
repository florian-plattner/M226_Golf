package ch.m226.golf;

import ch.m226.golf.game_objects.GameObject;
import ch.m226.golf.game_objects.Player;

import java.util.ArrayList;

/**
 * A collection of game objects.
 */
public class Level{
    public Player player;
    public ArrayList<GameObject> gameObjects;

    public Level(){
        gameObjects = new ArrayList<>();
    }
}
