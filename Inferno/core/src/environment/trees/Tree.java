package environment.trees;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import engine.Textures;
import engine.actionCollision.actorsManager.ActorsManager;
import engine.actionCollision.actorsManager.GameTime;
import engine.actors.DefaultActor;
import engine.actors.constants.ActorTypes;
import engine.utils.Draw;
import engine.utils.Update;
import environment.resources.ResourceAction;
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
    private int nextStageMinutes = 3;
    private byte currentIndex = 0;
    private final ActorsManager actorsManager;

    public Tree(String treeId, final Vector<Integer> position, ActorsManager actorsManager) {
        super(
                ActorTypes.STATIC,
                convertTilePosition(position),
                null,
                new DimensionVector<>(20, 20),
                new ArrayList<DimensionCordVector>(),
                new DimensionCordVector(32, 32, 0, 0)
        );
        this.actorsManager = actorsManager;
        config = TreesConfig.getTreeConfig(treeId);
        firstStage = config.getStages()[0];
        secondStage = config.getStages()[1];
        thirdStage = config.getStages()[2];
        fourthStage = config.getStages()[3];
        finalStage = config.getStages()[4];
        currentStage = config.getStages()[0];
        setUpdate(currentIndex);
        setStageDraw();
        currentStage = config.getStages()[0];
        setTreeGroundCheckbox();
        setActionCollision();
    }

    private void clearUpdate() {
        update = new Update() {
            @Override
            public void update(float delta, GameTime gameTime) {
            }
        };
    }

    private void setUpdate(int stageIndex) {
        if (stageIndex >= config.getStages().length) {
            return;
        }
        update = new Update() {
            @Override
            public void update(float delta, GameTime gameTime) {
//                stageMinutes = gameTime.getMinutes();
//                if (stageMinutes >= nextStageMinutes) {
//                    if (currentIndex == config.getStages().length - 1) {
//                        clearUpdate();
//                        setFinalStageDraw();
//                        setTreeGroundCheckboxByStage();
//                        return;
//                    }
//                    currentIndex++;
//                    currentStage = config.getStages()[currentIndex];
//                    nextStageMinutes += currentStage.getNextStage();
//                    setUpdate(currentIndex);
//                    setTreeGroundCheckboxByStage();
//                }
            }
        };
    }

    @Override
    public void draw(SpriteBatch sb) {
        draw.draw(sb);
    }

    @Override
    public void update(float delta, GameTime gameTime) {
        update.update(delta, gameTime);
    }


    private void setStageDraw() {
        draw = new Draw() {
            @Override
            public void draw(SpriteBatch sb) {
                sb.draw(Textures.checkbox, actionCollisions.get(0).position.x, actionCollisions.get(0).position.y, actionCollisions.get(0).dim.width, actionCollisions.get(0).dim.height);
                sb.draw(currentStage.getTxt(), position.x, position.y, currentStage.getTxt().getRegionWidth(), currentStage.getTxt().getRegionHeight());
            }
        };
    }

    private void setFinalStageDraw() {
        draw = new Draw() {
            @Override
            public void draw(SpriteBatch sb) {
                sb.draw(Textures.checkbox, groundCheckbox.position.x, groundCheckbox.position.y, groundCheckbox.dim.width, groundCheckbox.dim.height);
                sb.draw(config.getTrunkTxt(), position.x, position.y, config.getTrunkTxt().getRegionWidth(), config.getTrunkTxt().getRegionHeight());
                sb.draw(currentStage.getTxt(), position.x - 16, position.y, currentStage.getTxt().getRegionWidth(), currentStage.getTxt().getRegionHeight());
            }
        };
    }

    public void setTreeGroundCheckboxByStage() {
        actorsManager.removeGroundCheckbox(groundCheckbox);
        setGroundCheckbox(currentStage.getGroundCheckbox());
        actorsManager.addGroundCheckbox(groundCheckbox);
    }

    public void setTreeGroundCheckbox() {
        setGroundCheckbox(currentStage.getGroundCheckbox());
    }


    public void setActionCollision() {
        ResourceAction resourceAction = new ResourceAction() {
            @Override
            public void action() {
                System.out.println("TEST");
            }
        };

        actionCollisions.add(TreeUtils.getActionCollision(currentStage.getActionCollisionId(), position, id, resourceAction));
    }
//    private void setDraw() {
//        // ONLY FOR TEST PURPOSES - DISPLAY ALL TREE STAGES
//        draw = new Draw() {
//            @Override
//            public void draw(SpriteBatch sb) {
//                sb.draw(currentStage.getTxt(), position.x - 16, position.y + 32, currentStage.getTxt().getRegionWidth(), currentStage.getTxt().getRegionHeight());
//                sb.draw(config.getTrunkTxt(), position.x - 16, position.y, config.getTrunkTxt().getRegionWidth(), config.getTrunkTxt().getRegionHeight());
//                sb.draw(firstStage.getTxt(), position.x, position.y, firstStage.getTxt().getRegionWidth(), firstStage.getTxt().getRegionHeight());
//                sb.draw(secondStage.getTxt(), position.x + 16, position.y, firstStage.getTxt().getRegionWidth(), firstStage.getTxt().getRegionHeight());
//                sb.draw(thirdStage.getTxt(), position.x + 32, position.y, thirdStage.getTxt().getRegionWidth(), thirdStage.getTxt().getRegionHeight());
//                sb.draw(fourthStage.getTxt(), position.x + 48, position.y, fourthStage.getTxt().getRegionWidth(), fourthStage.getTxt().getRegionHeight());
//                sb.draw(config.getTrunkTxt(), position.x + 80, position.y, config.getTrunkTxt().getRegionWidth(), config.getTrunkTxt().getRegionHeight());
//                sb.draw(finalStage.getTxt(), position.x + 64, position.y, finalStage.getTxt().getRegionWidth(), finalStage.getTxt().getRegionHeight());
//
//            }
//        };
//    }
}
