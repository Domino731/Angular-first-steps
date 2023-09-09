package engine.actors.utils;

public class ActorDrop {
    private String itemId;
    private byte[] chance;
    private short[] amount;

    public ActorDrop(String itemId, byte[] chance, short[] amount) {
        this.itemId = itemId;
        this.chance = chance;
        this.amount = amount;
    }


    //// GETTERS ////

    public String getItemId() {
        return itemId;
    }

    public byte[] getChance() {
        return chance;
    }

    public short[] getAmount() {
        return amount;
    }
}
