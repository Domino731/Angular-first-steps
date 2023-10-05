package constants.actors.EnvironmentActor;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import engine.actionCollision.ActionCollision;
import engine.actionCollision.ActionTypes;
import engine.items.DropItemData;
import environment.resources.ResourceAction;
import utils.CollisionData;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public class EnvironmentActorConfig {
    public class Stage {
        private final byte stage;
        private final TextureRegion txt;
        private final byte width;
        private final byte height;
        private final int nextStage;
        private final CollisionData actionCollision;
        private final CollisionData groundCollision;
        private final ArrayList<DropItemData> drop;

        public Stage(byte stage, TextureRegion txt, byte width, byte height, int nextStage, CollisionData actionCollision, CollisionData groundCollision, ArrayList<DropItemData> drop) {
            this.stage = stage;
            this.width = width;
            this.height = height;
            this.txt = txt;
            this.nextStage = nextStage;
            this.drop = drop;
            this.actionCollision = actionCollision;
            this.groundCollision = groundCollision;
        }

        public byte getStage() {
            return stage;
        }

        public TextureRegion getTxt() {
            return txt;
        }

        public byte getWidth() {
            return width;
        }

        public byte getHeight() {
            return height;
        }

        public DimensionCordVector getGroundCollision() {
            return new DimensionCordVector(groundCollision);
        }

        public ActionCollision getActionCollision(ResourceAction rscAction, String actorId, Vector<Integer> actorPosition) {
            Vector<Integer> position = new Vector<>(groundCollision.x + actorPosition.x, groundCollision.y + actorPosition.y);
            DimensionVector<Integer> dimension = new DimensionVector<Integer>((int) actionCollision.width, (int) actionCollision.height);
            return new ActionCollision(ActionTypes.CUT_TREE, actorId, position, dimension, new Vector<>(0, 0), rscAction);
        }

        public int getNextStage() {
            return nextStage;
        }

        private ArrayList<DropItemData> getDrop() {
            return drop;
        }

    }

    public class Config {
        private final String id;
        private final String name;

        public Config(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }


}
