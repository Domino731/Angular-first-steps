package engine.actionCollision;

import utils.Checkbox;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

public class ActionCollision extends Checkbox {
    public ActionCollision(String actorId, Vector<Integer> position, DimensionVector<Integer> dim) {
        super(actorId, position, dim);
    }

    public ActionCollision(String actorId, Vector<Integer> position, DimensionVector<Integer> dim, Vector<Integer> absolutePosition) {
        super(actorId, position, dim, absolutePosition);
    }
}
