package ch.m226.golf;

import ch.m226.golf.commands.Command;
import ch.m226.golf.commands.Equip;
import ch.m226.golf.commands.View;

import java.util.*;

public class UserInterface {
    private Game game;
    private Scanner scanner;
    private HashMap<String, int[]> directions;
    public HashMap<String, Command> commands;

    public UserInterface(Game game) {
        this.game = game;
        scanner = new Scanner(System.in);
        commands = new HashMap<>();
        commands.put("view", new View());
        commands.put("equip", new Equip());

        directions = new HashMap<>();
        directions.put("north", new int[]{0, -1});
        directions.put("west", new int[]{-1, 0});
        directions.put("east", new int[]{1, 0});
        directions.put("south", new int[]{0, 1});
    }

    public void run() {
        System.out.println(game.description);

        while (game.currentLevel != null) {
            String[] input = scanner.nextLine().split(" ");

            boolean commandExecuted = false;

            if (input[0].equals("exit")) {
                commandExecuted = true;
                break;
            }

            for(String command : commands.keySet()){
                if(command.equals(input[0])){
                    if(commands.get(command).use(game, Arrays.copyOfRange(input, 1, input.length))){
                        commandExecuted = true;
                        break;
                    }
                }
            }

            if(!commandExecuted){
                if(game.player.skills.containsKey(input[0]) && input.length >= 2 && directions.containsKey(input[1])){
                    int[] direction = directions.get(input[1]);
                    game.player.skills.get(input[0]).use(game.currentLevel, game.player, direction[0], direction[1]);
                    commandExecuted = true;
                }
            }

            if(!commandExecuted){
                System.out.println("Unknown command");
            }
        }
    }

}
