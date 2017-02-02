package ch.m226.golf;

/**
 * A data class that is used when a weapon attacks a game object.
 */
public class Attack{
    public DamageType type;
    public int amount;

    public Attack(DamageType type, int amount){
        this.type = type;
        this.amount = amount;
    }
}
