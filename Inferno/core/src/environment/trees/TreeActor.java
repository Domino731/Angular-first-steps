package environment.trees;

import engine.actors.staticDefaultActor.environmentDefaultActor.EnvironmentDefaultActor;
import utils.Checkbox;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public class TreeActor extends EnvironmentDefaultActor {
    private String id;
    public int test = 0;

    public TreeActor() {
        super(new Vector<Integer>(150, 150), new ArrayList<Checkbox>(), TreesConfig.get("MAPLE").spriteSrc, new DimensionVector<>((int) TreeConstants.FINAL_STAGE_WIDTH, (int) TreeConstants.FINAL_STAGE_HEIGHT), TreesConfig.get("MAPLE").textures);
        id = TreesConfig.get("MAPLE").id;
    }

    public void right() {
        test++;
        if (test == 3) {
            id = "DUPA";

        }
        System.out.println(TreesConfig.get("MAPLE").spriteSrc);
        System.out.println(id);
    }
}
