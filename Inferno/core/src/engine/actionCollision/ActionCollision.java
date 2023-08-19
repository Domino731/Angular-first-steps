package engine.actionCollision;

import environment.resources.ResourceAction;
import utils.Checkbox;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

public class ActionCollision extends Checkbox {
    private ActionTypes type;
    private ResourceAction rscAction;

    public ActionCollision(ActionTypes type, String actorId, Vector<Integer> position, DimensionVector<Integer> dim) {
        super(actorId, position, dim);
        this.type = type;
    }

    public ActionCollision(ActionTypes type, String actorId, Vector<Integer> position, DimensionVector<Integer> dim, Vector<Integer> absolutePosition, ResourceAction rscAction) {
        super(actorId, position, dim, absolutePosition);
        this.type = type;
        this.rscAction = rscAction;
    }


    public void action() {
        rscAction.action();
    }
}
