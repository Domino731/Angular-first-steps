package environment.trees;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import engine.actionCollision.actorsManager.GameTime;
import engine.actors.DefaultActor;
import engine.actors.constants.ActorTypes;
import engine.utils.Draw;
import engine.utils.Update;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

import static engine.utils.PositionUtils.convertTilePosition;

public class Tree extends DefaultActor {
    private final TreesConfig.Config config;
    private final TreesConfig.Stage firstStage;
    private final TreesConfig.Stage secondStage;
    private final TreesConfig.Stage thirdStage;
    private final TreesConfig.Stage fourthStage;
    private final TreesConfig.Stage finalStage;
    private Draw draw;
    private TreesConfig.Stage currentStage;
    private Update update;
    private int stageMinutes = 0;

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
        secondStage = config.getStages()[1];
        thirdStage = config.getStages()[2];
        fourthStage = config.getStages()[3];
        finalStage = config.getStages()[4];
        currentStage = config.getStages()[0];
        setDraw();
        setUpdate(0);
    }

    @Override
    public void draw(SpriteBatch sb) {
        draw.draw(sb);
    }

    private void setUpdate(int stageIndex) {
        if (stageIndex >= config.getStages().length) {
            return;
        }
        update = new Update() {
            @Override
            public void update(float delta, GameTime gameTime) {
                stageMinutes = gameTime.getMinutes();
            }
        };
    }

    private void setDraw() {
        // ONLY FOR TEST PURPOSES - DISPLAY ALL TREE STAGES
        draw = new Draw() {
            @Override
            public void draw(SpriteBatch sb) {
                sb.draw(config.getTrunkTxt(), position.x - 16, position.y, config.getTrunkTxt().getRegionWidth(), config.getTrunkTxt().getRegionHeight());
                sb.draw(firstStage.getTxt(), position.x, position.y, firstStage.getTxt().getRegionWidth(), firstStage.getTxt().getRegionHeight());
                sb.draw(secondStage.getTxt(), position.x + 16, position.y, firstStage.getTxt().getRegionWidth(), firstStage.getTxt().getRegionHeight());
                sb.draw(thirdStage.getTxt(), position.x + 32, position.y, thirdStage.getTxt().getRegionWidth(), thirdStage.getTxt().getRegionHeight());
                sb.draw(fourthStage.getTxt(), position.x + 48, position.y, fourthStage.getTxt().getRegionWidth(), fourthStage.getTxt().getRegionHeight());
                sb.draw(config.getTrunkTxt(), position.x + 80, position.y, config.getTrunkTxt().getRegionWidth(), config.getTrunkTxt().getRegionHeight());
                sb.draw(finalStage.getTxt(), position.x + 64, position.y, finalStage.getTxt().getRegionWidth(), finalStage.getTxt().getRegionHeight());

            }
        };
    }
}
