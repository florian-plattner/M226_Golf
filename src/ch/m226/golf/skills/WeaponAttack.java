package ch.m226.golf.skills;


import ch.m226.golf.Level;
import ch.m226.golf.game_objects.Mob;
import ch.m226.golf.game_objects.Player;

/**
 * Uses the equipped weapon of a mob to attack in a direction.
 */
public class WeaponAttack implements Skill{
    @Override
    public void use(Level level, Mob mob, int directionX, int directionY){
        directionX = directionX == 0 ? 0 : directionX / Math.abs(directionX);
        directionY = directionY == 0 ? 0 : directionY / Math.abs(directionY);

        if(mob.equippedWeapon != null){
            mob.equippedWeapon.attack(level, directionX, directionY, mob.x, mob.y);
        }else{
            if(mob.getClass() == Player.class){
                System.out.println("You have no weapon equipped!");
            }
        }
    }
}
