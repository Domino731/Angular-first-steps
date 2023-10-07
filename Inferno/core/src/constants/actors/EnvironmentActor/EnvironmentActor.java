package constants.actors.EnvironmentActor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import constants.actors.DefaultActor;
import constants.actors.constants.ActorTypes;
import constants.actors.groundItem.GroundItem;
import engine.actionCollision.ActionCollision;
import engine.actionCollision.actorsManager.ActorsManager;
import engine.actionCollision.actorsManager.ActorsUtils;
import engine.actionCollision.actorsManager.GameTime;
import engine.utils.Draw;
import engine.utils.Update;
import utils.Checkbox;
import utils.vectors.Vector;

import java.util.ArrayList;

import static constants.actors.EnvironmentActor.EnvironmentActorConfig.getEnvironmentActorConfig;
import static engine.utils.PositionUtils.convertTilePosition;

public class EnvironmentActor extends DefaultActor {
    private boolean isDestroyed = false;
    private Draw currentDraw;
    private final ActorsManager actorsManager;
    private ArrayList<GroundItem> items = new ArrayList<>();
    private ArrayList<ActionCollision> itemsCollisions = new ArrayList<>();
    private boolean isCollisionWithNextStage = false;
    private EnvironmentActorConfig.Config config;
    private Update update;
    private int stageMinutes;
    private byte currentIndex = 0;

    Draw draw;
    private EnvironmentActorConfig.Stage currentStage;

    public EnvironmentActor(String actorId, Vector<Integer> position, ActorsManager actorsManager) {
        super(ActorTypes.DYNAMIC, convertTilePosition(position));
        this.actorsManager = actorsManager;
        config = getEnvironmentActorConfig(actorId);
        currentStage = config.getStages()[0];
        stageMinutes = currentStage.getNextStage();
        setUpdate(currentIndex);
    }

    private void setUpdate(int stageIndex) {
        // TODO: move to GameTime handlers
        if (stageIndex >= config.getStages().length) {
            return;
        }
        update = new Update() {
            @Override
            public void update(float delta, GameTime gameTime) {
                if (stageMinutes == 0) {
                    if (currentIndex != config.getStages().length - 1) {
                        EnvironmentActorConfig.Stage nextStage = config.getStages()[currentIndex + 1];
                        Checkbox nextStageChekbox = getGroundCheckboxTest(nextStage.getGroundCollision());
                        isCollisionWithNextStage = ActorsUtils.checkCollision(nextStageChekbox, actorsManager.getPlayerCheckboxArray().get(0));
                        if (isCollisionWithNextStage) {
                            return;
                        }
                    }
                    if (currentIndex == config.getStages().length - 1) {
                        clearUpdate();
                        setFinalStageDraw();
                        setTreeGroundCheckboxByStage();
                        return;
                    }

                    currentIndex++;
                    currentStage = config.getStages()[currentIndex];
                    stageMinutes = currentStage.getNextStage();
                    setUpdate(currentIndex);
                    setTreeGroundCheckboxByStage();
                }
            }
        };
    }

    public void setTreeGroundCheckboxByStage() {
        actorsManager.removeGroundCheckbox(groundCheckbox);
        setGroundCheckbox(currentStage.getGroundCollision());
        actorsManager.addGroundCheckbox(groundCheckbox);
    }

    private void setFinalStageDraw() {
        draw = new Draw() {
            @Override
            public void draw(SpriteBatch sb) {
                // TODO: add trunk
//                sb.draw(Textures.checkbox, groundCheckbox.position.x, groundCheckbox.position.y, groundCheckbox.dim.width, groundCheckbox.dim.height);
//                sb.draw(config.getTrunkTxt(), position.x, position.y, config.getTrunkTxt().getRegionWidth(), config.getTrunkTxt().getRegionHeight());
                sb.draw(currentStage.getTxt(), position.x - 16, position.y, currentStage.getTxt().getRegionWidth(), currentStage.getTxt().getRegionHeight());
            }
        };
    }

    private void clearUpdate() {
        update = new Update() {
            @Override
            public void update(float delta, GameTime gameTime) {
            }
        };
    }

    private void setStageDraw() {
        draw = new Draw() {
            @Override
            public void draw(SpriteBatch sb) {
//                sb.draw(Textures.checkbox, actionCollisions.get(0).position.x, actionCollisions.get(0).position.y, actionCollisions.get(0).dim.width, actionCollisions.get(0).dim.height);
//                sb.draw(Textures.checkbox, groundCheckbox.position.x, groundCheckbox.position.y, groundCheckbox.dim.width, groundCheckbox.dim.height);
                sb.draw(currentStage.getTxt(), position.x, position.y, currentStage.getTxt().getRegionWidth(), currentStage.getTxt().getRegionHeight());
            }
        };
    }


    @Override
    public void draw(SpriteBatch sb) {
        draw.draw(sb);
    }
}
