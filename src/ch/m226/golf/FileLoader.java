package ch.m226.golf;

import ch.m226.golf.game_objects.Player;
import ch.m226.golf.items.MeleeWeapon;
import ch.m226.golf.items.Weapon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileLoader {
    public static final String PLAYER = "assets/player";
    public static final String MELEE_WEAPONS = "assets/weapons/melee.csv";
    public static final String RANGED_WEAPONS = "assets/weapons/ranged.csv";
    public static final String DESCRIPTION = "description.txt";

    public static ArrayList<String[]> loadCsv(String filename){
        ArrayList<String[]> data = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            data = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                data.add(line.split(","));
            }
        }catch(Exception e){
        }

        return data;
    }

    public static Weapon loadWeapon(String name){
        Weapon weapon = null;

        for(String[] line: loadCsv(MELEE_WEAPONS)){
            if(line[0].equals(name)){
                try {
                    String weapon_name = line[0];
                    int weight = Integer.parseInt(line[1]);
                    DamageType damageType = DamageType.valueOf(line[2]);
                    int damage = Integer.parseInt(line[3]);

                    weapon = new MeleeWeapon(weapon_name, weight, damageType, damage);
                }catch(Exception e){
                }
            }
        }


        return weapon;
    }

    public static Player loadPlayer(){
        ArrayList<String[]> data = loadCsv(PLAYER);
        Player player = null;

        try {
            String[] line = data.get(0);

            String name = line[0];
            int hitpoints = Integer.parseInt(line[1]);
            int x = Integer.parseInt(line[2]);
            int y = Integer.parseInt(line[3]);

            player = new Player(name, hitpoints, x, y);

            for(String weaponName: data.get(1)){
                Weapon weapon = loadWeapon(weaponName);
                if(weapon != null){
                    player.inventory.add(weapon);
                }
            }
        }catch(Exception e){
        }

        return player;
    }

    public static String loadText(String filename){
        String text = null;

        try{
            text = new String(Files.readAllBytes(Paths.get(filename)));
        }catch(IOException e){
        }

        return text;
    }

    public static String loadDescription(){
        return loadText(DESCRIPTION);
    }
}
