package environment.trees;

import engine.actors.staticDefaultActor.environmentDefaultActor.EnvironmentDefaultActor;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

public class TreeActor extends EnvironmentDefaultActor {
    private String id;

    public TreeActor(int x, int y) {
        super(
                new Vector<>(x, y),
                TreesConfig.get("MAPLE").checkboxesCords,
                TreesConfig.get("MAPLE").spriteSrc,
                new DimensionVector<>((int) TreeConstants.FINAL_STAGE_WIDTH,
                        (int) TreeConstants.FINAL_STAGE_HEIGHT),
                TreesConfig.get("MAPLE").textures,
                new DimensionCordVector(20, 17, 14, 0)
        );
    }

    public void right() {

    }
}
