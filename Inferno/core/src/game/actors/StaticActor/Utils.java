package game.actors.StaticActor;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import engine.Textures;
import utils.vectors.DimensionCordVector;

/**
 * Class with utils for static actor
 */
public class Utils {
    /**
     * Create a ground checkbox data for static actor
     */
    public static DimensionCordVector createGroundCheckbox(JsonNode node) {
        short groundCheckboxWidth = (short) node.get("width").asInt();
        short groundCheckboxHeight = (short) node.get("height").asInt();
        short groundCheckboxX = (short) node.get("x").asInt();
        short groundCheckboxY = (short) node.get("y").asInt();
        return new DimensionCordVector(groundCheckboxWidth, groundCheckboxHeight, groundCheckboxX, groundCheckboxY);
    }

    /**
     * Create a ground checkbox data for static actor
     */
    public static TextureRegion createTexture(JsonNode node) {
        int width = node.get("width").asInt();
        int height = node.get("height").asInt();
        int x = node.get("x").asInt();
        int y = node.get("y").asInt();
        return new TextureRegion(Textures.treesSprite, x, y, width, height);
    }
}
