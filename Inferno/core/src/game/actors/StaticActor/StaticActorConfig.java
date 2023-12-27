package game.actors.StaticActor;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import engine.objectConfig.ObjectConfig;
import utils.vectors.DimensionCordVector;

import static game.actors.StaticActor.Utils.createGroundCheckbox;
import static game.actors.StaticActor.Utils.createTexture;

public class StaticActorConfig extends ObjectConfig {
    private final TextureRegion txt;
    private final DimensionCordVector groundCheckbox;

    public StaticActorConfig(String id, String type, String name, JsonNode specs) {
        super(id, type, name, specs);
        groundCheckbox = createGroundCheckbox(specs.get("ground_checkbox"));
        txt = createTexture(specs.get("texture"));
    }

    public DimensionCordVector getGroundCheckbox() {
        return new DimensionCordVector(groundCheckbox.width, groundCheckbox.height, groundCheckbox.x, groundCheckbox.y);
    }

    public TextureRegion getTxt() {
        return txt;
    }
}
