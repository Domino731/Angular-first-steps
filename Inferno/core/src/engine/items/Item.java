package engine.items;

public class Item {
    public String id;
    public ItemRarity rarity;

    public Item(String id, ItemRarity rarity) {
        this.id = id;
        this.rarity = rarity;
    }
}
