package ch.m226.golf.commands;

import ch.m226.golf.FileLoader;
import ch.m226.golf.Game;
import ch.m226.golf.Level;
import ch.m226.golf.game_objects.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandTest {
    Command equip, view;
    Game game;

    @BeforeEach
    void setUp() {
        equip = new Equip();
        view = new View();
        Player player = FileLoader.loadPlayer();
        ArrayList<Level> levels = new ArrayList<>();
        levels.add(new Level());
        String description = "fgjfkdlgjklgök";
        Game game = new Game(player, levels, description);
        game = new Game(player, new ArrayList<>(), "jjkdljkl");
    }

    @Test
    void use() {
        assertTrue(view.use(game, new String[0]));
        assertTrue(view.use(game, new String[]{ "fdjkslaf", "jkldjkl" }));
        assertFalse(equip.use(game, new String[0]));
        assertTrue(equip.use(game, new String[]{ "sword" }));
        assertTrue(equip.use(game, new String[]{ "sword", "jkldjkl" }));
    }

}