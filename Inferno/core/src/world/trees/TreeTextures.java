package world.trees;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TreeTextures {
    public TextureRegion treeStage1;
    public TextureRegion treeStage2;
    public TextureRegion treeStage3;
    public TextureRegion treeStage4;
    public TextureRegion treeStage5;
    public TextureRegion trunk;
    public TextureRegion emptyTrunk;

    public TreeTextures(TreeConstants.Tree treeId) {
        treeStage1 = TreeTextureManager.get(String.valueOf(treeId), String.valueOf(TreeConstants.TreePart.STAGE_ONE));
        treeStage2 = TreeTextureManager.get(String.valueOf(treeId), String.valueOf(TreeConstants.TreePart.STAGE_TWO));
        treeStage3 = TreeTextureManager.get(String.valueOf(treeId), String.valueOf(TreeConstants.TreePart.STAGE_THREE));
        treeStage4 = TreeTextureManager.get(String.valueOf(treeId), String.valueOf(TreeConstants.TreePart.STAGE_FOUR));
        treeStage5 = TreeTextureManager.get(String.valueOf(treeId), String.valueOf(TreeConstants.TreePart.STAGE_FIVE));
        trunk = TreeTextureManager.get(String.valueOf(treeId), String.valueOf(TreeConstants.TreePart.TRUNK));
        emptyTrunk = TreeTextureManager.get(String.valueOf(treeId), String.valueOf(TreeConstants.TreePart.EMPTY_TRUNK));
    }
}
