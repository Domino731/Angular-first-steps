package world.trees;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import constants.actors.DefaultActor;
import constants.actors.constants.ActorTypes;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public class NewTree extends DefaultActor {

    TreeTextures textures;
    private Vector<Integer> treeCrownPosition;
    private int xVelocity = 2; // Adjust this value to change the speed of bouncing.
    private float boundary = 40.0f;

    public NewTree(Vector<Integer> position) {
        super(ActorTypes.STATIC, position, "sprites/trees/oak_spring.png", new DimensionVector<Integer>(20, 20), new ArrayList<DimensionCordVector>(), new DimensionCordVector(10, 10, 10, 10));
        textures = new TreeTextures(TreeConstants.Tree.OAK);
        treeCrownPosition = new Vector<>(this.position.x - 16, this.position.y);
    }


    public void update() {
        // Update the position based on velocity.
        treeCrownPosition.x += xVelocity;

        // Check boundaries and bounce back if necessary.
        if (treeCrownPosition.x <= 0 || treeCrownPosition.x >= Gdx.graphics.getWidth() - texture.getWidth()) {
            xVelocity = -xVelocity; // Reverse the velocity to make it bounce back.
        }
    }

    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(textures.emptyTrunk, position.x, position.y);
        sb.draw(textures.treeStage5, treeCrownPosition.x, treeCrownPosition.y);
    }
}
