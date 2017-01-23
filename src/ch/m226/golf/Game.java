package ch.m226.golf;

import java.util.ArrayList;
import java.util.Scanner;

public class Game{
    public ArrayList<Level> levels;
    public Level currentLevel;
    private Scanner scanner;

    public Game(ArrayList<Level> levels){
        this.levels = levels;
        if(levels.size() > 0){
            currentLevel = levels.get(0);
        }
        scanner = new Scanner(System.in);
    }

    public void game(){
        if(currentLevel != null){
            while(true){
                String input = scanner.next();

                if(input.equals("exit")){
                    break;
                }

                if(input.equals("walk")){
                    String next = scanner.next();
                    switch(next){
                        case "north":
                            currentLevel.getPlayer().move(currentLevel, 0, -1);
                            break;
                        case "south":
                            currentLevel.getPlayer().move(currentLevel, 0, 1);
                            break;
                        case "west":
                            currentLevel.getPlayer().move(currentLevel, -1, 0);
                            break;
                        case "east":
                            currentLevel.getPlayer().move(currentLevel, 1, 0);
                            break;
                    }
                }

                if(input.equals("attack")){
                    String direction = scanner.next();
                    if(scanner.next().equals("with")){
                        String weapon = scanner.next();
                        switch(direction){
                            case "north":
                                currentLevel.getPlayer().useWeapon(currentLevel, weapon, 0, -1);
                                break;
                            case "south":
                                currentLevel.getPlayer().useWeapon(currentLevel, weapon, 0, 1);
                                break;
                            case "west":
                                currentLevel.getPlayer().useWeapon(currentLevel, weapon, -1, 0);
                                break;
                            case "east":
                                currentLevel.getPlayer().useWeapon(currentLevel, weapon, 1, 0);
                                break;
                        }
                    }
                }
            }
        }
    }
}
