package environment.trees;

import engine.actors.staticDefaultActor.environmentDefaultActor.EnvironmentDefaultActor;
import utils.Checkbox;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public class TreeActor extends EnvironmentDefaultActor {
    public TreeActor() {
        super(new Vector<Integer>(150, 150), new ArrayList<Checkbox>(), "sprites/entities/player.png", new DimensionVector<Integer>(100, 100));
    }
}
