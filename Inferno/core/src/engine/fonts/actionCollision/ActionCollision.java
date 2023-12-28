package engine.fonts.actionCollision;

import utils.Action;
import utils.Checkbox;
import utils.strings.StringUtils;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

public class ActionCollision extends Checkbox {
    private final ActionTypes type;
    private final Action rscAction;
    public final String id;

    public ActionCollision(ActionTypes type, String actorId, Vector<Integer> position, DimensionVector<Integer> dim, Vector<Integer> absolutePosition, Action rscAction) {
        super(actorId, position, dim, absolutePosition);
        this.type = type;
        this.rscAction = rscAction;
        id = StringUtils.generateRandomId();
    }

    public ActionCollision(ActionTypes type, String actorId, DimensionCordVector dimensionCordVector, Vector<Integer> absolutePosition, Action rscAction) {
        super(actorId, new Vector<>(dimensionCordVector.x, dimensionCordVector.y), new DimensionVector<>(dimensionCordVector.width, dimensionCordVector.height), absolutePosition);
        this.type = type;
        this.rscAction = rscAction;
        id = StringUtils.generateRandomId();
    }

    public void action() {
        rscAction.action();
    }
}
