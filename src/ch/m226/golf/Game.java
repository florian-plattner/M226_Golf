package ch.m226.golf;

import ch.m226.golf.game_objects.Player;

import java.util.ArrayList;
import java.util.Scanner;

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
        userInterface = new UserInterface(this);
    }

    public void game(){
        boolean running = true;
        userInterface.run();
    }
}
