package ch.m226.golf.skills;

import ch.m226.golf.Level;
import ch.m226.golf.game_objects.Mob;

public interface Skill {
    void use(Level level, Mob mob, int directionX, int directionY);
}
