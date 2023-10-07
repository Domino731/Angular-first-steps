package constants.actors.EnvironmentActor;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;
import engine.actionCollision.ActionCollision;
import engine.actionCollision.ActionTypes;
import engine.items.DropItemData;
import environment.resources.ResourceAction;
import utils.CollisionData;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;
import java.util.HashMap;

import static utils.Json.readFile;

public class EnvironmentActorConfig {
    private static HashMap<String, Config> data = createData();

    public static class Stage {
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
            Vector<Integer> position = new Vector<>(actionCollision.x + actorPosition.x, actionCollision.y + actorPosition.y);
            DimensionVector<Integer> dimension = new DimensionVector<>((int) actionCollision.width, (int) actionCollision.height);
            return new ActionCollision(ActionTypes.CUT_TREE, actorId, position, dimension, new Vector<>(0, 0), rscAction);
        }

        public int getNextStage() {
            return nextStage;
        }

        private ArrayList<DropItemData> getDrop() {
            return drop;
        }

    }

    public static class Config {
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

    private static HashMap<String, Config> createData() {
        HashMap<String, Config> payload = new HashMap<>();

        Config oakTree = createActorConfig(Urls.CONFIG_TREE_OAK_NEW);
        payload.put(oakTree.getId(), oakTree);
        Config mapleTree = createActorConfig(Urls.CONFIG_TREE_MAPLE_NEW);
        payload.put(mapleTree.getId(), mapleTree);
        Config pineTree = createActorConfig(Urls.CONFIG_TREE_PINE_NEW);
        payload.put(pineTree.getId(), pineTree);
        Config mahoganyTree = createActorConfig(Urls.CONFIG_TREE_MAHOGANY_NEW);
        payload.put(mahoganyTree.getId(), mahoganyTree);
        Config mushroomTree = createActorConfig(Urls.CONFIG_TREE_MUSHROOM_NEW);
        payload.put(mahoganyTree.getId(), mushroomTree);
        Config palmSmallTree = createActorConfig(Urls.CONFIG_TREE_PALM_SMALL_NEW);
        payload.put(palmSmallTree.getId(), palmSmallTree);
        Config palmMediumTree = createActorConfig(Urls.CONFIG_TREE_PALM_MEDIUM_NEW);
        payload.put(palmMediumTree.getId(), palmMediumTree);

        return payload;
    }

    private static Config createActorConfig(String configSource) {
        JsonNode node = readFile(configSource);

        String id = node.get("id").asText();
        String name = node.get("name").asText();

        return new Config(id, name);
    }

    public static Config getEnvironmentActorConfig(String actorId) {
        return data.get(actorId);
    }
}
