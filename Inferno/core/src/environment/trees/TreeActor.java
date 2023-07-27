package environment.trees;

import engine.actors.staticDefaultActor.environmentDefaultActor.EnvironmentDefaultActor;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

public class TreeActor extends EnvironmentDefaultActor {
    private String id;

    public TreeActor() {
        super(
                new Vector<>(150, 150),
                TreesConfig.get("MAPLE").checkboxesCords,
                TreesConfig.get("MAPLE").spriteSrc,
                new DimensionVector<>((int) TreeConstants.FINAL_STAGE_WIDTH,
                        (int) TreeConstants.FINAL_STAGE_HEIGHT),
                TreesConfig.get("MAPLE").textures,
                new DimensionCordVector(10, 10, 0, 0)
        );
    }

    public void right() {

    }
}
