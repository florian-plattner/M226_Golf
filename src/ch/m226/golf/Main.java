package ch.m226.golf;

import ch.m226.golf.game_objects.NonPlayerCharacter;
import ch.m226.golf.game_objects.Player;
import ch.m226.golf.items.MeleeWeapon;
import ch.m226.golf.items.RangedWeapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Level level = new Level();
        level.setPlayer(new Player("player", 6, 0, 0));
        level.getPlayer().inventory.add(new MeleeWeapon("sword", 1, DamageType.PIERCING, 5));
        level.getPlayer().inventory.add(new RangedWeapon("crossbow", 1, DamageType.PIERCING, 2, 4));
        level.gameObjects.add(new NonPlayerCharacter("ork", 5, 1, 0));

        ArrayList<Level> levels = new ArrayList<>();
        levels.add(level);
        Game game = new Game(levels);
        game.game();
    }

    public static String getArticle(String word, boolean capital){
        String a;

        if(capital)a = "A";
        else a = "a";

        List consonants = Arrays.asList('a', 'e', 'i', 'o', 'u');
        if(consonants.contains(word.toCharArray()[0])){
            return a + "n";
        }else{
            return a;
        }
    }


}
