package utils;

import com.fasterxml.jackson.databind.JsonNode;

public class CollisionData {
    public final short width;
    public final short height;
    public final short x;
    public final short y;

    public CollisionData(short width, short height, short x, short y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public CollisionData(JsonNode node) {
        this.width = (short) node.get("width").asInt();
        this.height = (short) node.get("width").asInt();
        this.x = (short) node.get("x").asInt();
        this.y = (short) node.get("y").asInt();
    }
}


