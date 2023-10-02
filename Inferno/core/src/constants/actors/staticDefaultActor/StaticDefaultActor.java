package constants.actors.staticDefaultActor;

import constants.actors.DefaultActor;
import constants.actors.constants.ActorTypes;
import utils.vectors.Vector;

public class StaticDefaultActor extends DefaultActor {
    public StaticDefaultActor(Vector<Integer> position) {
        super(ActorTypes.STATIC, position);
    }
}
