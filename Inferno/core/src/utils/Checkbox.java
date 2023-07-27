package utils;

import utils.vectors.DimensionVector;
import utils.vectors.Vector;

public class Checkbox {
    public Vector<Integer> position;
    public Vector<Integer> absolutePosition;
    public DimensionVector<Integer> dim;
    private String actorId;

    public Checkbox(String actorId, Vector<Integer> position, DimensionVector<Integer> dim) {
        this.actorId = actorId;
        this.position = position;
        this.absolutePosition = new Vector<>(position.x, position.y);
        this.dim = dim;
    }

    public Checkbox(String actorId, Vector<Integer> position, DimensionVector<Integer> dim, Vector<Integer> absolutePosition) {
        this.actorId = actorId;
        this.position = position;
        this.absolutePosition = absolutePosition;
        this.dim = dim;
    }

    public String getActorId() {
        return actorId;
    }
}
