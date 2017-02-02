package ch.m226.golf;

import ch.m226.golf.game_objects.GameObject;
import ch.m226.golf.game_objects.Player;

import java.util.ArrayList;

/**
 * The main game class. It contains all of the levels, the player and also the user interface.
 */
public class Game{
    public ArrayList<Level> levels;
    public Level currentLevel;
    public String description;
    public Player player;
    public UserInterface userInterface;

    public Game(Player player, ArrayList<Level> levels, String description){
        this.player = player;
        this.levels = levels;
        this.description = description;
        if(levels.size() > 0){
            currentLevel = levels.get(0);
        }
        if(!currentLevel.gameObjects.contains(player)){
            currentLevel.gameObjects.add(player);
        }
        userInterface = new UserInterface(this);
    }

    /**
     * Start the game loop.
     */
    public void game(){
        userInterface.printDescription();
        while (userInterface.run() && player.intact){
            for (GameObject gameObject: currentLevel.gameObjects){
                gameObject.update(currentLevel);
            }
        }
    }
}
