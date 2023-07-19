package utils;

import utils.vectors.DimensionVector;
import utils.vectors.Vector;

public class Checkbox {
    public Vector<Integer> position;
    public DimensionVector<Integer> dim;

    public Checkbox(Vector<Integer> position, DimensionVector<Integer> dim){
        this.position = position;
        this.dim = dim;
    }
}
