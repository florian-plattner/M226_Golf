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
    public int levelEndX, levelEndY;

    public Level(){
        gameObjects = new ArrayList<>();
        levelEndX = 0;
        levelEndY = 0;
    }
}
