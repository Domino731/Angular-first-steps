package environment.trees;

import engine.actionCollision.ActionCollision;
import engine.actionCollision.ActionTypes;
import environment.resources.ResourceAction;
import utils.EngineLog;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

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

    public static ActionCollision getActionCollision(String actionCollisionId, Vector<Integer> actorPosition, String actorId, ResourceAction action) {
        DimensionVector<Integer> dimensionVector = getDimensionVectorForActionCollision(actionCollisionId);
        Vector<Integer> position = getPositionForActionCollision(actionCollisionId, actorPosition);

        return new ActionCollision(ActionTypes.CUT_TREE, actorId, position, dimensionVector, new Vector<>(0, 0), action);
    }

    public static DimensionVector<Integer> getDimensionVectorForActionCollision(String actionCollisionId) {
        switch (actionCollisionId) {
            case "1":
                return new DimensionVector<>(20);
            case "2":
                return new DimensionVector<>(36);
            case "3":
                return new DimensionVector<>(48);
            case "4":
                return new DimensionVector<>(48);
            case "5":
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
            case "4":
                return new Vector<>(position.x - 2, position.y - 2);
            case "5":
                return new Vector<>(position.x, position.y);
            default:
                return new Vector<>(position.x, position.y);
        }
    }
}
