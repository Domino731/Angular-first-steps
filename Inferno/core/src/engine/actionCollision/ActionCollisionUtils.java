package engine.actionCollision;

import utils.EngineLog;

public class ActionCollisionUtils {
    public static ActionTypes getActionTypeFromJson(String jsonActionType) {
        switch (jsonActionType) {
            case "cut_tree":
                return ActionTypes.CUT_TREE;
            case "mine":
                return ActionTypes.MINE_RESOURCE;
            default:
                EngineLog.error("Error in getActionTypeFromJson(), failed to match jsonActionType, default value returned");
                return ActionTypes.CUT_TREE;
        }
    }
}
