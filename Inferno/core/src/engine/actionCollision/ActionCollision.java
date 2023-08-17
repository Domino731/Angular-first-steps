package engine.actionCollision;

import utils.Checkbox;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

public class ActionCollision extends Checkbox {
    ActionTypes type;

    public ActionCollision(ActionTypes type, String actorId, Vector<Integer> position, DimensionVector<Integer> dim) {
        super(actorId, position, dim);
        this.type = type;
    }

    public ActionCollision(ActionTypes type, String actorId, Vector<Integer> position, DimensionVector<Integer> dim, Vector<Integer> absolutePosition) {
        super(actorId, position, dim, absolutePosition);
        this.type = type;
    }

    public void execute() {
        System.out.println("ACTION EXECUTE");
    }
}
