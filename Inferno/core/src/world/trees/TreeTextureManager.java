package world.trees;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

public class TreeTextureManager {
    private static HashMap<String, Texture> textures = new HashMap<>();
    private static HashMap<String, TextureRegion> textureRegions = new HashMap<>();


    public static TextureRegion get(String treeId, String treePart) {
        Texture treeTexture = textures.get(treeId);

        if (treeTexture == null) {
            textures.put(treeId, new Texture("sprites/trees/oak_spring.png"));
            createTextureRegions(treeId);
        }

        return textureRegions.get(treeId + "_" + treePart);
    }

    private static void createTextureRegions(String treeId) {
        Texture texture = textures.get(treeId);
        textureRegions.put(treeId + "_" + TreeConstants.TreePart.STAGE_ONE, new TextureRegion(texture, TreeConstants.Cords.STAGE_ONE.x, TreeConstants.Cords.STAGE_ONE.y, TreeConstants.Cords.STAGE_ONE.width, TreeConstants.Cords.STAGE_ONE.height));
        textureRegions.put(treeId + "_" + TreeConstants.TreePart.STAGE_TWO, new TextureRegion(texture, TreeConstants.Cords.STAGE_TWO.x, TreeConstants.Cords.STAGE_TWO.y, TreeConstants.Cords.STAGE_TWO.width, TreeConstants.Cords.STAGE_TWO.height));
        textureRegions.put(treeId + "_" + TreeConstants.TreePart.STAGE_THREE, new TextureRegion(texture, TreeConstants.Cords.STAGE_THREE.x, TreeConstants.Cords.STAGE_THREE.y, TreeConstants.Cords.STAGE_THREE.width, TreeConstants.Cords.STAGE_THREE.height));
        textureRegions.put(treeId + "_" + TreeConstants.TreePart.STAGE_FOUR, new TextureRegion(texture, TreeConstants.Cords.STAGE_FOUR.x, TreeConstants.Cords.STAGE_FOUR.y, TreeConstants.Cords.STAGE_FOUR.width, TreeConstants.Cords.STAGE_FOUR.height));
        textureRegions.put(treeId + "_" + TreeConstants.TreePart.STAGE_FIVE, new TextureRegion(texture, TreeConstants.Cords.STAGE_FIVE.x, TreeConstants.Cords.STAGE_FIVE.y, TreeConstants.Cords.STAGE_FIVE.width, TreeConstants.Cords.STAGE_FIVE.height));
        textureRegions.put(treeId + "_" + TreeConstants.TreePart.TRUNK, new TextureRegion(texture, TreeConstants.Cords.TRUNK.x, TreeConstants.Cords.TRUNK.y, TreeConstants.Cords.TRUNK.width, TreeConstants.Cords.TRUNK.height));
        textureRegions.put(treeId + "_" + TreeConstants.TreePart.EMPTY_TRUNK, new TextureRegion(texture, TreeConstants.Cords.EMPTY_TRUNK.x, TreeConstants.Cords.EMPTY_TRUNK.y, TreeConstants.Cords.EMPTY_TRUNK.width, TreeConstants.Cords.EMPTY_TRUNK.height));
    }
}
