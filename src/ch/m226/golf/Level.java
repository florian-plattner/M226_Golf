package ch.m226.golf;

import ch.m226.golf.game_objects.GameObject;

import java.util.ArrayList;

/**
 * A collection of game objects.
 */
public class Level{
    public ArrayList<GameObject> gameObjects;

    public Level(){
        gameObjects = new ArrayList<>();
    }
}
