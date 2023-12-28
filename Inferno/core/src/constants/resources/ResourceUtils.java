package constants.resources;

import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

public class ResourceUtils {
    public static DimensionCordVector getDimCordVectorBySize(String groundCheckboxId) {
        switch (groundCheckboxId) {
            case "1":
                return new DimensionCordVector(16, 0, 0);
            case "2":
                return new DimensionCordVector(32, 0, 0);
            case "3":
                return new DimensionCordVector(48, 0, 0);
            default:
                return new DimensionCordVector(16, 0, 0);
        }
    }


    public static DimensionVector<Integer> getDimensionVectorForActionCollision(String actionCollisionId) {
        switch (actionCollisionId) {
            case "1":
                return new DimensionVector<>(20);
            case "2":
                return new DimensionVector<>(36);
            case "3":
                return new DimensionVector<>(48);
            default:
                return new DimensionVector<>(0);
        }
    }

    public static Vector<Integer> getPositionForActionCollision(String actionCollisionId, Vector<Integer> position) {
        switch (actionCollisionId) {
            case "1":
                return new Vector<>(position.x - 2, position.y - 2);
            case "2":
                return new Vector<>(position.x - 2, position.y - 2);
            case "3":
                return new Vector<>(position.x, position.y);
            default:
                return new Vector<>(position.x, position.y);
        }
    }
}
