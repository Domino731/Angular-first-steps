package environment.trees;

import utils.vectors.DimensionCordVector;

public class TreeUtils {
    public static DimensionCordVector getGroundCheckboxById(String groundCheckboxId) {
        switch (groundCheckboxId) {
            case "1":
                return new DimensionCordVector(0, 0, 0);
            case "2":
                return new DimensionCordVector(0, 0, 0);
            case "3":
                return new DimensionCordVector(0, 0, 0);
            case "4":
                return new DimensionCordVector(0, 0, 0);
            case "5":
                return new DimensionCordVector(0, 0, 0);
            default:
                return new DimensionCordVector(0, 0, 0);
        }
    }
}
