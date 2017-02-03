package ch.m226.golf.skills;

import ch.m226.golf.Level;
import ch.m226.golf.game_objects.Mob;

/**
 * The interface for skills. A skill is always used with a mob.
 */
public interface Skill {

    /**
     * Use the skill. A skill is always used in a direction.
     * @param level the level for the skill to act in.
     * @param mob the mob that uses the skill
     * @param directionX the x axis of the direction
     * @param directionY the y axis of the direction
     */
    void use(Level level, Mob mob, int directionX, int directionY);
}
