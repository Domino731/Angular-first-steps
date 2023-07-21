package player;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import spritesManager.SpritesManager;
import utils.Checkbox;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public class Player {
    private TextureRegion[][] animations;
    private int aniTick, aniIndex, aniSpeed = 25;
    private int playerAction = PlayerConstants.Actions.IDLE;
    private boolean moving = false, attacking = false;
    private boolean left, up, right, down;
    private int playerSpeed = 2;
    private Vector<Integer> position = new Vector<>(200, 200);
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private ArrayList<Checkbox> checkboxArray;
    private Texture txt;

    public Player() {
        checkboxArray = new ArrayList<>();
        checkboxArray.add(new Checkbox(new Vector<Integer>(10, 10), new DimensionVector<Integer>(30, 30)));

        txt = SpritesManager.loadSprite(PlayerConstants.SPRITE);
    }

    public void update() {
        updatePos();
//        updateAnimationTick();
//        setAnimation();
    }

    private void resetAniTick() {
        aniTick = 0;
        aniIndex = 0;
    }

    private void updatePos() {
        moving = false;

        if (left && !right) {
            position.x -= playerSpeed;
            moving = true;
        } else if (right && !left) {
            position.x += playerSpeed;
            moving = true;
        }

        if (up && !down) {
            position.y -= playerSpeed;

            moving = true;
        } else if (down && !up) {
            position.y += playerSpeed;
            moving = true;
        }
    }

    public void resetDirBooleans() {
        left = false;
        right = false;
        up = false;
        down = false;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void draw(ShapeRenderer sr, SpriteBatch sb) {
        sb.draw(txt, position.x, position.y, 100, 100);

    }
}
