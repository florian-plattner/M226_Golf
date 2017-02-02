package ch.m226.golf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Main.
 */
class MainTest {
    @Test
    void getArticle() {
        assertEquals("a", Main.getArticle("Wall", false));
        assertEquals("an", Main.getArticle("Ork", false));
        assertEquals("A", Main.getArticle("Wall", true));
        assertEquals("An", Main.getArticle("Ork", true));
    }

}