package player;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import spritesManager.SpritesManager;
import utils.vectors.Vector;

public class Player {
    private TextureRegion[][] animations;
    private int aniTick, aniIndex, aniSpeed = 25;
    private int playerAction = PlayerConstants.Actions.IDLE;
    private boolean moving = false, attacking = false;
    private boolean left, up, right, down;
    private float playerSpeed = 2.0f;
    private Vector<Integer> position = new Vector<>(200, 200);

    public Player() {
          define();
    }

    private void define() {
     System.out.println(SpritesManager.loadSprite(PlayerConstants.SPRITE));

    }
}
