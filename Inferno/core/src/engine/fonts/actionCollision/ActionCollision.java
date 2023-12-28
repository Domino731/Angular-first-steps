package engine.fonts.actionCollision;

import constants.resources.ResourceAction;
import utils.Checkbox;
import utils.strings.StringUtils;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

public class ActionCollision extends Checkbox {
    private final ActionTypes type;
    private final ResourceAction rscAction;
    public final String id;

    public ActionCollision(ActionTypes type, String actorId, Vector<Integer> position, DimensionVector<Integer> dim, Vector<Integer> absolutePosition, ResourceAction rscAction) {
        super(actorId, position, dim, absolutePosition);
        this.type = type;
        this.rscAction = rscAction;
        id = StringUtils.generateRandomId();
    }

    public void action() {
        rscAction.action();
    }
}
