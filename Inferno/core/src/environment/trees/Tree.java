package environment.trees;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import engine.actors.DefaultActor;
import engine.actors.constants.ActorTypes;
import engine.utils.Draw;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

import static engine.utils.PositionUtils.convertTilePosition;

public class Tree extends DefaultActor {
    private final TreesConfig.Config config;
    private final TreesConfig.Stage firstStage;
    private Draw draw;


    public Tree(String treeId, final Vector<Integer> position) {
        super(
                ActorTypes.STATIC,
                convertTilePosition(position),
                null,
                new DimensionVector<>(20, 20),
                new ArrayList<DimensionCordVector>(),
                new DimensionCordVector(32, 32, 0, 0)
        );
        config = TreesConfig.getTreeConfig(treeId);
        firstStage = config.getStages()[0];
        setDraw();
    }

    @Override
    public void draw(SpriteBatch sb) {

        draw.draw(sb);
    }

    private void setDraw() {
        draw = new Draw() {
            @Override
            public void draw(SpriteBatch sb) {
                sb.draw(firstStage.getTxt(), position.x, position.y, firstStage.getTxt().getRegionWidth(), firstStage.getTxt().getRegionHeight());
            }
        };
    }
}
