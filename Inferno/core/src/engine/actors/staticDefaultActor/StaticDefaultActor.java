package engine.actors.staticDefaultActor;

import engine.actors.DefaultActor;
import engine.actors.constants.ActorTypes;
import utils.Checkbox;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public class StaticDefaultActor extends DefaultActor {

    public StaticDefaultActor(Vector<Integer> position, ArrayList<Checkbox> checkboxArray, String texturePath, DimensionVector<Integer> dim) {
        super(ActorTypes.STATIC, position, checkboxArray, texturePath, dim);
    }
}
