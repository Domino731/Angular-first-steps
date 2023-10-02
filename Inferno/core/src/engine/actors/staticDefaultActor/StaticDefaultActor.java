package engine.actors.staticDefaultActor;

import engine.actors.DefaultActor;
import engine.actors.constants.ActorTypes;
import utils.vectors.Vector;

public class StaticDefaultActor extends DefaultActor {
    public StaticDefaultActor(Vector<Integer> position) {
        super(ActorTypes.STATIC, position);
    }
}
