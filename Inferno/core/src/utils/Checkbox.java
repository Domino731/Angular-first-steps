package utils;

import utils.vectors.DimensionVector;
import utils.vectors.Vector;

public class Checkbox {
    public Vector<Integer> position;
    public DimensionVector<Integer> dim;
    private String actorId;

    public Checkbox(String actorId, Vector<Integer> position, DimensionVector<Integer> dim) {
        this.actorId = actorId;
        this.position = position;
        this.dim = dim;
    }
}
