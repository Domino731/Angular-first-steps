package utils.vectors;

import utils.CollisionData;

public class DimensionCordVector {
    public int width;
    public int height;
    public int x;
    public int y;

    public DimensionCordVector(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public DimensionCordVector(int size, int x, int y) {
        this.width = size;
        this.height = size;
        this.x = x;
        this.y = y;
    }

    public DimensionCordVector(CollisionData collisionData) {
        this.width = collisionData.width;
        this.height = collisionData.height;
        this.x = collisionData.x;
        this.y = collisionData.y;
    }
}