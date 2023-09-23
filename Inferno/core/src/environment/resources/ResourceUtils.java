package environment.resources;

import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

public class ResourceUtils {
    public static DimensionCordVector getDimCordVectorBySize(String isResourceBig) {
        switch (isResourceBig) {
            case "1":
                return new DimensionCordVector(16, 16, 0, 0);
            case "2":
                return new DimensionCordVector(32, 32, 0, 0);
            case "3":
                return new DimensionCordVector(48, 48, 0, 0);
            default:
                return new DimensionCordVector(16, 16, 0, 0);
        }
    }


    public static DimensionVector<Integer> getDimensionVectorForActionCollision(boolean isResourceBig) {
        if (isResourceBig) {
            return new DimensionVector<>(38, 38);
        }
        return new DimensionVector<>(21, 21);
    }

    public static Vector<Integer> getPositionForActionCollision(boolean isResourceBig, Vector<Integer> resourcePosition) {
        if (isResourceBig) {
            return new Vector<>(resourcePosition.x - 3, resourcePosition.y - 3);
        }
        return new Vector<>(resourcePosition.x - 2, resourcePosition.y - 2);
    }
}
