package ch.m226.golf;

import ch.m226.golf.game_objects.Player;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @BeforeEach
    void setUp() {
        Player player = new Player(5, 1, 6);
        ArrayList<Level> levels = new ArrayList<>();
        levels.add(new Level());
        String description = "fgjfkdlgjklgök";

        Game game = new Game(player, levels, description);
        assertEquals(levels, game.levels);
        assertEquals(levels.get(0), game.currentLevel);
        assertEquals(player, game.player);
        assertEquals(description, game.description);
    }

}