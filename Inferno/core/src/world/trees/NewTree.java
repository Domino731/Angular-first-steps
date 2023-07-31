package world.trees;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import engine.actors.DefaultActor;
import engine.actors.constants.ActorTypes;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public class NewTree extends DefaultActor {
    TextureRegion rg;
    TreeTextures textures;

    public NewTree() {
        super(ActorTypes.STATIC, new Vector<>(10, 10), "sprites/trees/oak_spring.png", new DimensionVector<Integer>(20, 20), new ArrayList<DimensionCordVector>(), new DimensionCordVector(10, 10, 10, 10));
        textures = new TreeTextures();
        rg = new TextureRegion(texture, TreeConstants.Cords.STAGE_FIVE.x, TreeConstants.Cords.STAGE_FIVE.y, TreeConstants.Cords.STAGE_FIVE.width, TreeConstants.Cords.STAGE_FIVE.height);
    }


    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(rg, 10, 10);
//        sb.draw(rg, 10, 10, 10, 0, 50, 50, 1, 1, 20);
    }
}
