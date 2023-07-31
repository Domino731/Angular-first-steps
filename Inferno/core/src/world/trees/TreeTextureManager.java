package world.trees;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

public class TreeTextureManager {
    private static HashMap<String, Texture> textures = new HashMap<>();
    private static HashMap<String, TextureRegion> textureRegions = new HashMap<>();


    public static Texture get(String treeId) {
        Texture treeTexture = textures.get(treeId);

        if (treeTexture == null) {
            textures.put(treeId, new Texture("sprites/trees/oak_spring.png"));
        }
        return textures.get(treeId);
    }

    private void createTextureRegions(String treeId) {
        
    }
}
