package ch.m226.golf.items;

/**
 * The abstract base class for all items, that can be in the inventory of a mob.
 */
public abstract class Item{
    public String name;
    public int weight;

    public Item(String name, int weight){
        this.name = name;
        this.weight = weight;
    }
}
