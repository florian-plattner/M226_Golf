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

        if (game.currentLevel != null) {
            while (true) {
                String input = scanner.next();

                if (input.equals("exit")) {
                    break;
                } else if (input.equals("walk")) {
                    String next = scanner.next();
                    switch (next) {
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
                    }
                } else if (input.equals("attack")) {
                    String direction = scanner.next();
                    if (scanner.next().equals("with")) {
                        String weapon = scanner.next();
                        switch (direction) {
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
                        }
                    }
                } else if (input.equals("look") && scanner.next().equals("around")) {
                    printView(game.player, 4);
                }
            }
        }
    }

    private void printView(GameObject object, int range) {
        ArrayList<GameObject> visibleObjects = new ArrayList<>();
        visibleObjects.addAll(game.currentLevel.gameObjects);

        for(Iterator<GameObject> iterator = visibleObjects.iterator(); iterator.hasNext();){
            GameObject gameObject = iterator.next();

            int distanceX = Math.abs(gameObject.x - object.x);
            int distanceY = Math.abs(gameObject.y - object.y);

            if(Math.max(distanceX, distanceY) >= range){
                iterator.remove();
            }
        }

//        for (GameObject gameObject : game.currentLevel.gameObjects) {
//            if(gameObject != object){
//
//                int distanceX = gameObject.x - object.x;
//                int distanceY = gameObject.y - object.y;
//
//                double angle_min;
//                double angle_max;
//
//                double[] angles = new double[]{
//                        Math.atan2(distanceY - 0.5, distanceX - 0.5),
//                        Math.atan2(distanceY - 0.5, distanceX + 0.5),
//                        Math.atan2(distanceY + 0.5, distanceX - 0.5),
//                        Math.atan2(distanceY + 0.5, distanceX + 0.5)
//                };
//
//                angle_min = Math.min(Math.min(angles[0], angles[1]), Math.min(angles[2], angles[3]));
//                angle_max = Math.max(Math.max(angles[0], angles[1]), Math.max(angles[2], angles[3]));
//
//                if (Math.max(distanceX, distanceY) >= range) {
//                    visibleObjects.remove(gameObject);
//                } else {
//                    ArrayList<double[]> obstacles = new ArrayList<>();
//                    for (GameObject gameObject1 : visibleObjects) {
//                        int distanceY1 = gameObject1.y - object.y;
//                        int distanceX1 = gameObject1.x - object.x;
//
//                        if (Math.max(distanceX, distanceY) < range && Math.abs(distanceX) > Math.abs(distanceX1) &&
//                                Math.abs(distanceY) > Math.abs(distanceY1) && (distanceX < 0) == (distanceX1 < 0) &&
//                                (distanceY < 0) == (distanceY1 < 0)) {
//
//                            double angle_min1;
//                            double angle_max1;
//
//                            double[] angles1 = new double[]{
//                                    Math.atan2(distanceY1 - 0.5, distanceX1 - 0.5),
//                                    Math.atan2(distanceY1 - 0.5, distanceX1 + 0.5),
//                                    Math.atan2(distanceY1 + 0.5, distanceX1 - 0.5),
//                                    Math.atan2(distanceY1 + 0.5, distanceX1 + 0.5)
//                            };
//
//                            angle_min1 = Math.min(Math.min(angles1[0], angles1[1]), Math.min(angles1[2], angles1[3]));
//                            angle_max1 = Math.max(Math.max(angles1[0], angles1[1]), Math.max(angles1[2], angles1[3]));
//
//                            for (Iterator<double[]> iterator = obstacles.iterator(); iterator.hasNext();) {
//                                double[] next = iterator.next();
//
//                                if (Math.max(angle_min1, next[0]) <= Math.min(angle_max1, next[1])) {
//                                    iterator.remove();
//                                    angle_min1 = Math.min(angle_min1, next[0]);
//                                    angle_max1 = Math.max(angle_max1, next[1]);
//                                }
//
//                            }
//                            if (Math.max(angle_min1, angle_min1) <= Math.min(angle_max1, angle_max1)) {
//                                obstacles.add(new double[]{angle_min1, angle_max1});
//                            }
//                        }
//                    }
//
//                    for (double[] obstacle: obstacles){
//                        if(obstacle[0] <= angle_min && obstacle[1] >= angle_max){
//                            visibleObjects.remove(gameObject);
//                        }
//                    }
//
//
//                }
//            }
//        }

        char[][] output = new char[range * 2][range * 2];
        for (char[] line : output) {
            Arrays.fill(line, ' ');
        }

        for (GameObject gameObject : visibleObjects) {
            if (gameObject.name.equals("wall")) {
                output[gameObject.y - object.y + range][gameObject.x - object.x + range] = '#';
            } else if (gameObject.name.equals("ork")) {
                output[gameObject.y - object.y + range][gameObject.x - object.x + range] = 'o';
            }
        }

        output[range][range] = 'X';

        for (char[] line : output) {
            System.out.println(line);
        }
    }
}
