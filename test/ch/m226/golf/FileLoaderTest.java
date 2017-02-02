package ch.m226.golf;

import ch.m226.golf.items.MeleeWeapon;
import ch.m226.golf.items.Weapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FileLoaderTest {
    @Test
    void loadCsv() {
        assertNotNull(FileLoader.loadCsv(FileLoader.PLAYER));
    }

    @Test
    void loadWeapon() {
        Weapon sword = FileLoader.loadWeapon("sword");
        assertEquals(MeleeWeapon.class, sword.getClass());
        assertEquals("sword", sword.name);
    }

    @Test
    void loadPlayer() {
        assertNotNull(FileLoader.loadPlayer());
    }

    @Test
    void loadText() {
        assertNotNull(FileLoader.loadText(FileLoader.LEVELS));
    }

    @Test
    void loadDescription() {
        assertEquals(FileLoader.loadText(FileLoader.DESCRIPTION), FileLoader.loadDescription());
    }

    @Test
    void loadLevels() {
        assertNotNull(FileLoader.loadLevels());
    }

}