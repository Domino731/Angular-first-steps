package environment.trees;

import utils.EngineLog;
import utils.vectors.DimensionCordVector;
import utils.vectors.Vector;

public class TreeUtils {
    public static DimensionCordVector getGroundCheckboxById(String groundCheckboxId, Vector<Integer> position) {
        switch (groundCheckboxId) {
            case "1":
                return new DimensionCordVector(8, 8, position.x + 5, position.y);
            case "2":
                return new DimensionCordVector(12, 12, position.x + 12, position.y + 11);
            case "3":
                return new DimensionCordVector(14, 15, position.x + 1, position.y + 1);
            case "4":
                return new DimensionCordVector(13, 10, position.x + 1, position.y + 1);
            case "5":
                return new DimensionCordVector(16, 16, position.x, position.y);
            default:
                EngineLog.error("TreeUtils.getGroundCheckboxById() - default DimensionCordVector returned, no match for " + groundCheckboxId + " groundCheckboxId");
                return new DimensionCordVector(0, 0, 0);
        }
    }
}
