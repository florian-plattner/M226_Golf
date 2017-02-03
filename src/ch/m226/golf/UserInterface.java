package ch.m226.golf;

import ch.m226.golf.commands.*;

import java.util.*;

/**
 * The user interface is used to interface between the user and the game.
 */
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
        commands.put("inventory", new ShowInventory());
        commands.put("health", new Health());

        directions = new HashMap<>();
        directions.put("north", new int[]{0, -1});
        directions.put("west", new int[]{-1, 0});
        directions.put("east", new int[]{1, 0});
        directions.put("south", new int[]{0, 1});
    }

    /**
     * Prints the description.
     */
    public void printDescription(){
        System.out.println(game.description);
    }

    /**
     * Scans for input and runs the commands.
     * @return whether the game should continue running
     */
    public boolean run() {
        if (game.currentLevel != null) {
            String[] input = scanner.nextLine().split(" ");

            if (input[0].equals("exit")) {
               return false;
            }else if (commands.containsKey(input[0])) {
                commands.get(input[0]).use(game, Arrays.copyOfRange(input, 1, input.length));
            }else if(game.player.skills.containsKey(input[0]) && input.length >= 2 && directions.containsKey(input[1])){
                int[] direction = directions.get(input[1]);
                game.player.skills.get(input[0]).use(game.currentLevel, game.player, direction[0], direction[1]);
            }else{
                System.out.println("Unknown command");
            }

            return true;
        }else{
            return false;
        }
    }

}
