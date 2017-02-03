package ch.m226.golf;

import ch.m226.golf.game_objects.GameObject;

import java.util.*;

public class UserInterface {
    private Game game;
    private Scanner scanner;

    public UserInterface(Game game) {
        this.game = game;
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println(game.description);

        while (game.currentLevel != null) {
            String[] input = scanner.nextLine().split(" ");

            if (input[0].equals("exit")) {
                break;
            } else if (input[0].equals("walk") && input.length >= 2) {
                switch (input[1]) {
                    case "north":
                        game.player.move(game.currentLevel, 0, -1);
                        break;
                    case "south":
                        game.player.move(game.currentLevel, 0, 1);
                        break;
                    case "west":
                        game.player.move(game.currentLevel, -1, 0);
                        break;
                    case "east":
                        game.player.move(game.currentLevel, 1, 0);
                        break;
                    default:
                        System.out.println("unknown direction");
                }
            } else if (input[0].equals("attack") && input.length >= 4) {
                if (input[2].equals("with")) {
                    String weapon = input[3];
                    switch (input[1]) {
                        case "north":
                            game.player.useWeapon(game.currentLevel, weapon, 0, -1);
                            break;
                        case "south":
                            game.player.useWeapon(game.currentLevel, weapon, 0, 1);
                            break;
                        case "west":
                            game.player.useWeapon(game.currentLevel, weapon, -1, 0);
                            break;
                        case "east":
                            game.player.useWeapon(game.currentLevel, weapon, 1, 0);
                            break;
                        default:
                            System.out.println("unknown direction");
                    }
                }
            } else if (input[0].equals("look") && input.length >= 2 && input[1].equals("around")) {
                printView(game.player, 4);
            } else {
                System.out.println("unknown command");
            }
        }
    }


    public void printView(GameObject gameObject, int range) {
        HashSet<GameObject> visibleObjects = new HashSet<>();

        for(int i = 0; i <= range / 2; i++){
            int x = -1, y = -1;

            do{
                if(y == -1)x *= -1;
                y *= -1;

                lightRay(visibleObjects, gameObject.x, gameObject.y, i * x, range * y, range);
                lightRay(visibleObjects, gameObject.x, gameObject.y, range * x, i * y, range);
            }while(!(x == -1 && y == -1));
        }

        char[][] output = new char[range * 2][range * 2];
        for (char[] line : output) {
            Arrays.fill(line, ' ');
        }

        for (GameObject gameObject1 : visibleObjects) {
            if (gameObject1.name.equals("wall")) {
                output[gameObject1.y - gameObject.y + range][gameObject1.x - gameObject.x + range] = '#';
            } else if (gameObject1.name.equals("ork")) {
                output[gameObject1.y - gameObject.y + range][gameObject1.x - gameObject.x + range] = 'o';
            }
        }

        output[range][range] = 'X';

        for (char[] line : output) {
            System.out.println(line);
        }
    }

    private void lightRay(HashSet<GameObject> visibleObjects, int posX, int posY, int x, int y, int range){
        int longest = (Math.abs(x) > Math.abs(y)) ? x : y;
        int shortest  = (Math.abs(x) < Math.abs(y)) ? x : y;

        int[] lines = new int[Math.abs(shortest) + 1];
        for(int i = 0; i < lines.length; i++){
            lines[i] = 0;
        }

        int length = 0;

        for(int i = 1; length != Math.abs(longest); i++){
            lines[i % lines.length] = i / lines.length;

            length = 0;
            for(int line : lines){
                length += line;
            }
        }

        boolean finished = false;
        int straight = 0, diagonal = 0, i = 0;
        while(straight < range && diagonal < range && !finished){
            for(GameObject gameObject: game.currentLevel.gameObjects){
                int distanceX, distanceY;

                if(longest == x ){
                    distanceX = longest != 0 ? straight * longest / Math.abs(longest) : 0;
                    distanceY = shortest != 0 ? diagonal * shortest / Math.abs(shortest) : 0;
                }else{
                    distanceX = shortest != 0 ? diagonal * shortest / Math.abs(shortest) : 0;
                    distanceY = longest != 0 ? straight * longest / Math.abs(longest) : 0;
                }

                if(gameObject.x == posX + distanceX && gameObject.y == posY + distanceY){
                    visibleObjects.add(gameObject);
                    if(gameObject.intact){
                        finished = true;
                    }
                }
            }

            straight++;
            i++;
            if(i >= lines[straight % lines.length]){
                i = 0;
                diagonal++;
            }
        }
    }
}
