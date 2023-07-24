package engine.actors.movableDefaultActor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import engine.actors.DefaultActor;
import engine.actors.constants.ActorTypes;
import engine.actors.utils.ActorDirection;
import spritesManager.SpritesManager;
import utils.Checkbox;
import utils.TextureData;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public class MovableDefaultActor extends DefaultActor {
    protected boolean isMoving = false;
    protected ActorDirection direction = new ActorDirection();
    protected byte speed = 1;
    private TextureRegion[][] textureRegions;
    private TextureData textureData;
    private int aniTick, aniIndex, aniSpeed = 25;
    private Vector<Integer> finalPosition;

    public MovableDefaultActor(Vector<Integer> position, ArrayList<Checkbox> checkboxArray, String texturePath, TextureData textureData, DimensionVector<Integer> dim) {
        super(ActorTypes.DYNAMIC, position, checkboxArray, texturePath, dim);
        this.textureData = textureData;
        this.finalPosition = position;
        loadAnimations();
    }

    private void loadAnimations() {
        short texturesInColumn = textureData.getTexturesInColumn();
        short texturesInRow = textureData.getTexturesInRow();
        short textureWidth = textureData.getTextureWidth();
        short textureHeight = textureData.getTextureHeight();
        Texture texture = SpritesManager.loadSprite(textureData.getSrc());
        textureRegions = new TextureRegion[texturesInColumn][texturesInRow];

        for (int j = 0; j < textureRegions.length; j++)
            for (int i = 0; i < textureRegions[j].length; i++)
                textureRegions[j][i] = new TextureRegion(texture, i * textureWidth, j * textureHeight, textureWidth, textureHeight);
    }

    public void setRight(boolean v) {
        direction.right = v;
    }

    public void setLeft(boolean v) {
        direction.left = v;
    }

    public void setTop(boolean v) {
        direction.top = v;
    }

    public void setBot(boolean v) {
        direction.bot = v;
    }

    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(textureRegions[0][0], finalPosition.x, finalPosition.y, dim.width, dim.height);
    }
}
