package environment.trees;

import utils.EngineLog;
import utils.vectors.DimensionCordVector;

public class TreeUtils {
    public static DimensionCordVector getGroundCheckboxById(String groundCheckboxId) {
        switch (groundCheckboxId) {
            case "1":
                return new DimensionCordVector(8, 7, 5, 3);
            case "2":
                return new DimensionCordVector(11, 12, 3, 3);
            case "3":
                return new DimensionCordVector(14, 15, 1, 1);
            case "4":
                return new DimensionCordVector(13, 10, 1, 1);
            case "5":
                return new DimensionCordVector(16, 16, 0, 0);
            default:
                EngineLog.error("TreeUtils.getGroundCheckboxById() - default DimensionCordVector returned, no match for " + groundCheckboxId + " groundCheckboxId");
                return new DimensionCordVector(0, 0, 0);
        }
    }
}
