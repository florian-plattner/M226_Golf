package ch.m226.golf.commands;

import ch.m226.golf.Game;
import ch.m226.golf.game_objects.GameObject;
import ch.m226.golf.game_objects.Player;

import java.util.Arrays;
import java.util.HashSet;

public class View implements Command{
    private static int range = 6;

    @Override
    public boolean use(Game game, String[] args){
        Player player = game.player;
        HashSet<GameObject> visibleObjects = new HashSet<>();

        for(int i = 0; i <= range; i++){
            int x = -1, y = -1;

            do{
                if(y == -1)x *= -1;
                y *= -1;

                lightRay(game, visibleObjects, player.x, player.y, i * x, range * y, range);
                lightRay(game, visibleObjects, player.x, player.y, range * x, i * y, range);
            }while(!(x == -1 && y == -1));
        }

        char[][] output = new char[range * 2][range * 2];
        for (char[] line : output) {
            Arrays.fill(line, ' ');
        }

        for (GameObject gameObject1 : visibleObjects) {
            if (gameObject1.name.equals("wall")) {
                output[gameObject1.y - player.y + range][gameObject1.x - player.x + range] = '#';
            } else if (gameObject1.name.equals("ork")) {
                output[gameObject1.y - player.y + range][gameObject1.x - player.x + range] = 'o';
            }
        }

        output[range][range] = 'X';

        for (char[] line : output) {
            System.out.println(line);
        }

        return true;
    }

    private void lightRay(Game game, HashSet<GameObject> visibleObjects, int posX, int posY, int x, int y, int range){
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
            int distanceX, distanceY;

            if(i >= lines[straight % lines.length]){
                diagonal++;
            }

            int[] distances = getDistances(x, y, longest, shortest, straight, diagonal);
            distanceX = distances[0];
            distanceY = distances[1];

            GameObject gameObject = checkField(game, posX + distanceX, posY + distanceY);

            if(gameObject != null){
                visibleObjects.add(gameObject);
                if(gameObject.intact){
                    finished = true;
                }
            }

            i++;
            straight++;
        }
    }

    private int[] getDistances(int x, int y, int longest, int shortest, int straight, int diagonal){
        int[] distances = new int[2];

        if(longest == x){
            distances[0] = longest != 0 ? straight * longest / Math.abs(longest) : 0;
            distances[1] = shortest != 0 ? diagonal * shortest / Math.abs(shortest) : 0;
        }else{
            distances[0] = shortest != 0 ? diagonal * shortest / Math.abs(shortest) : 0;
            distances[1] = longest != 0 ? straight * longest / Math.abs(longest) : 0;
        }

        return  distances;
    }

    private GameObject checkField(Game game, int x, int y){
        GameObject gameObject = null;

        for(GameObject gameObject1: game.currentLevel.gameObjects){
            if(gameObject1.x == x && gameObject1.y == y){
                gameObject = gameObject1;
                break;
            }
        }

        return gameObject;
    }
}
