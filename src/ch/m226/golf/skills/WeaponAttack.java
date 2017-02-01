package ch.m226.golf.skills;


import ch.m226.golf.Level;
import ch.m226.golf.game_objects.Mob;

public class WeaponAttack implements Skill{
    @Override
    public void use(Level level, Mob mob, int directionX, int directionY){
        directionX = directionX / Math.abs(directionX);
        directionY = directionY / Math.abs(directionY);

        mob.equippedWeapon.attack(level, directionX, directionY, mob.x, mob.y);
    }
}
