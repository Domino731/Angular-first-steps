package environment.resources;

import utils.vectors.DimensionCordVector;

public class ResourceUtils {
    public static DimensionCordVector getDimCordVectorBySize(boolean isBig) {
        if(isBig) {
            return new DimensionCordVector(ResourceConstants.bigMineSize, ResourceConstants.bigMineSize, 0, 0);
        }
        return new DimensionCordVector(ResourceConstants.normalMineSize, ResourceConstants.normalMineSize, 0, 0);
    }
}
