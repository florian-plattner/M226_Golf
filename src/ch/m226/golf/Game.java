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
    private boolean running;

    public Game(Player player, ArrayList<Level> levels, String description){
        this.player = player;
        this.levels = levels;
        this.description = description;
        if(levels.size() > 0){
            currentLevel = levels.get(0);
        }
        if(currentLevel.player != player){
            currentLevel.player = player;
        }
        userInterface = new UserInterface(this);
        running = true;
    }

    /**
     * Start the game loop.
     */
    public void game(){
        userInterface.printDescription();
        while (running){
            running = userInterface.run();
            player.update(currentLevel);
            for (GameObject gameObject: currentLevel.gameObjects){
                if(gameObject.intact)gameObject.update(currentLevel);
            }
            if(player.x == currentLevel.levelEndX && player.y == currentLevel.levelEndY){
                nextLevel();
            }
            if(running)running = player.intact;
        }
    }

    /**
     * Load the next level.
     */
    public void nextLevel(){
        int index = 0;
        if(levels.contains(currentLevel)){
            index = levels.indexOf(currentLevel) + 1;
        }

        if(levels.size() > index){
            currentLevel = levels.get(index);
            if(currentLevel.player != player){
                currentLevel.player = player;
            }
            player.x = 1;
            player.y = 1;

            System.out.println("You have reached level " + (index + 1) + ".");
        }else{
            System.out.println("You win!!!");
            running = false;
        }

    }
}
