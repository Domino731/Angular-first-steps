package engine.actors.staticDefaultActor.environmentDefaultActor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import engine.actors.staticDefaultActor.StaticDefaultActor;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public class EnvironmentDefaultActor extends StaticDefaultActor {
    protected TextureRegion[] textures;

    public EnvironmentDefaultActor(Vector<Integer> position, ArrayList<DimensionCordVector> checkboxArray, String texturePath, DimensionVector<Integer> dim, TextureRegion[] textures) {
        super(position, checkboxArray, texturePath, dim);
        this.textures = textures;
    }

    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(textures[0], position.x, position.y, dim.width, dim.height);
    }
}
