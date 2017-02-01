package ch.m226.golf;

import ch.m226.golf.game_objects.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main{

    public static void main(String[] args){
        String description = FileLoader.loadDescription();
        ArrayList<Level> levels = FileLoader.loadLevels();
        Player player = FileLoader.loadPlayer();

        if(description != null && levels != null && player != null){
            Game game = new Game(player, levels, description);
            game.game();
        }else{
            System.out.println("Failed to load!");
        }
    }

    public static String getArticle(String word, boolean capital){
        String a;

        if(capital) a = "A";
        else a = "a";

        List consonants = Arrays.asList('a', 'e', 'i', 'o', 'u');
        if(consonants.contains(word.toCharArray()[0])){
            return a + "n";
        }else{
            return a;
        }
    }


}
