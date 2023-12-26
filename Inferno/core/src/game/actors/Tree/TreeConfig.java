package game.actors.Tree;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import engine.objectConfig.ObjectConfig;

public class TreeConfig extends ObjectConfig {
    private final TreeStageConfig[] stages;
    private final TextureRegion trunkTxt;

    public TreeConfig(String id, String type, String name, JsonNode specs, TreeStageConfig[] stages, TextureRegion trunkTxt) {
        super(id, type, name, specs);
        this.stages = stages;
        this.trunkTxt = trunkTxt;
    }

    public TreeStageConfig[] getStages() {
        return stages;
    }

    public TextureRegion getTrunkTxt() {
        return trunkTxt;
    }
}
