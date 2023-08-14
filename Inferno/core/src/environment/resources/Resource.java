package environment.resources;

import engine.actors.DefaultActor;
import engine.actors.constants.ActorTypes;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public class Resource extends DefaultActor {
    public Resource(Vector<Integer> position) {
        super(ActorTypes.STATIC, position, "sprites/trees/oak_spring.png", new DimensionVector<Integer>(20, 20), new ArrayList<DimensionCordVector>(), new DimensionCordVector(10, 10, 10, 10));
    }
}
