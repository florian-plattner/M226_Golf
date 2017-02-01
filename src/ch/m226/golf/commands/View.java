package ch.m226.golf.commands;

import ch.m226.golf.Game;
import ch.m226.golf.game_objects.GameObject;
import ch.m226.golf.game_objects.Player;

import java.util.Arrays;
import java.util.HashSet;

public class View implements Command{
    private static int range = 8;

    @Override
    public boolean use(Game game, String[] args){
        Player player = game.player;
        HashSet<GameObject> visibleObjects = new HashSet<>();

        for(int i = 0; i <= range / 2; i++){
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

    private void lightRay1(Game game, HashSet<GameObject> visibleObjects, int posX, int posY, int x, int y, int range){
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

                if(y < 0)diagonal--;
                else diagonal++;

                if(i >= lines[straight % lines.length]){
                    i = 0;
                    if(x < 0)straight -= 1;
                    else straight += 1;
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
