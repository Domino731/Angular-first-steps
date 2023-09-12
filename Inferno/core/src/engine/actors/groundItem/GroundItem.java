package engine.actors.groundItem;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import engine.actionCollision.ActionCollision;
import engine.actionCollision.ActionTypes;
import environment.resources.ResourceAction;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

public class GroundItem {
    private Vector<Integer> position;
    private TextureRegion txt;
    private boolean isAvailableToPick = false;
    private ActionCollision actionCollision;

    public GroundItem(int positionX, int positionY, TextureRegion txt) {
        position = new Vector<>(positionX, positionY);
        this.txt = txt;
        actionCollision = createActionCollision();
    }

    public void update(double deltaTime) {

    }

    public void draw(SpriteBatch sb) {
        sb.draw(txt, position.x, position.y, GroundItemConstants.size, GroundItemConstants.size);
    }

    private ActionCollision createActionCollision() {
        return new ActionCollision(
                ActionTypes.ACTION_AREA,
                "",
                new Vector<>(position.x, position.y),
                new DimensionVector<>(16, 16),
                new Vector<>(0, 0),
                new ResourceAction() {
                    @Override
                    public void action() {
                        System.out.println("ITEM ON COLLISION");
                    }
                }
        );
    }


    // GETTERS //
    public ActionCollision getActionCollision() {
        return actionCollision;
    }
}
