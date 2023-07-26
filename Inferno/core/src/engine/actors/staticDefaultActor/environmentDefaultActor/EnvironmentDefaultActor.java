package engine.actors.staticDefaultActor.environmentDefaultActor;

import engine.actors.staticDefaultActor.StaticDefaultActor;
import utils.Checkbox;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public class EnvironmentDefaultActor extends StaticDefaultActor {
    public EnvironmentDefaultActor(Vector<Integer> position, ArrayList<Checkbox> checkboxArray, String texturePath, DimensionVector<Integer> dim) {
        super(position, checkboxArray, texturePath, dim);
    }
}
