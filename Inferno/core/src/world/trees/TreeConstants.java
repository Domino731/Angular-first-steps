package world.trees;

import utils.vectors.DimensionCordVector;

public class TreeConstants {
    public static final class Cords {
        public static final DimensionCordVector STAGE_ONE = new DimensionCordVector(16, 16, 32, 128);
        public static final DimensionCordVector STAGE_TWO = new DimensionCordVector(16, 16, 0, 128);
        public static final DimensionCordVector STAGE_THREE = new DimensionCordVector(16, 16, 16, 128);
        public static final DimensionCordVector STAGE_FOUR = new DimensionCordVector(16, 32, 16, 96);
        public static final DimensionCordVector STAGE_FIVE = new DimensionCordVector(48, 96, 0, 0);
    }

    public enum Tree {
        OAK
    }

    public enum TreePart {
        STAGE_ONE,
        STAGE_TWO,
        STAGE_THREE,
        STAGE_FOUR,
        STAGE_FIVE,
        EMPTY_TRUNK,
        TRUNK
    }
}
