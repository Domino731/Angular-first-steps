package world.trees;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TreeTextures {
    public Texture tree;
    TextureRegion trunk;

    public TreeTextures() {
        tree = TreeTextureManager.get(String.valueOf(TreeConstants.Tree.OAK));
    }
}
