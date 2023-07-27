package engine.actors.staticDefaultActor;

import engine.actors.DefaultActor;
import engine.actors.constants.ActorTypes;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public class StaticDefaultActor extends DefaultActor {

    public StaticDefaultActor(Vector<Integer> position, ArrayList<DimensionCordVector> checkboxArray, String texturePath, DimensionVector<Integer> dim, DimensionCordVector dcv) {
        super(ActorTypes.STATIC, position, texturePath, dim, checkboxArray, dcv);
    }
}
