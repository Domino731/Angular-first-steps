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
    private int playerSpeed = 1;
    public Vector<Integer> position = new Vector<>(200, 200);
    private Vector<Integer> finalPosition = new Vector<>(0, 0);
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    public ArrayList<Checkbox> checkboxArray;
    private Texture txt;
    public boolean isCollision = false;

    private final short width = 64;
    private final short height = 64;

    public Player() {
        checkboxArray = new ArrayList<>();
        checkboxArray.add(new Checkbox("test", new Vector<Integer>(position.x, position.y), new DimensionVector<Integer>(100, 100)));

        txt = SpritesManager.loadSprite("badlogic.jpg");
        loadAnimations();
    }

    public void loadAnimations() {
        Texture texture = SpritesManager.loadSprite(PlayerConstants.SPRITE);
        byte texturesInColumn = 9;
        byte texturesInRow = 6;
        byte textureWidth = 64;
        byte textureHeight = 40;

        animations = new TextureRegion[texturesInColumn][texturesInRow];
        for (int j = 0; j < animations.length; j++)
            for (int i = 0; i < animations[j].length; i++)
                animations[j][i] = new TextureRegion(texture, i * textureWidth, j * textureHeight, textureWidth, textureHeight);

    }

    public Vector<Integer> getPosition() {
        return position;
    }

    public void resetPosition() {
        position.x = finalPosition.x;
        position.y = finalPosition.y;
        checkboxArray.get(0).position.x = finalPosition.x;
        checkboxArray.get(0).position.y = finalPosition.y;
    }

    public void update() {
        if (!isCollision) {
            finalPosition.x = position.x;
            finalPosition.y = position.y;
        }

//        updatePos();
        updateAnimationTick();
        setAnimation();
    }

    private void setAnimation() {
        int startAni = playerAction;

        if (moving)
            playerAction = PlayerConstants.Actions.RUNNING;
        else
            playerAction = PlayerConstants.Actions.IDLE;

        if (attacking)
            playerAction = PlayerConstants.Actions.ATTACK_1;

        if (startAni != playerAction)
            resetAniTick();
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= PlayerConstants.GetSpriteAmount(playerAction)) {
                aniIndex = 0;
                attacking = false;
            }
        }
    }

    private void resetAniTick() {
        aniTick = 0;
        aniIndex = 0;
    }

    public void updatePos() {
        moving = false;
        if (left && !right) {
            position.x -= playerSpeed;
            for (Checkbox cb : checkboxArray) {
                cb.position.x -= playerSpeed;
            }
            moving = true;
        } else if (right && !left) {
            position.x += playerSpeed;
            for (Checkbox cb : checkboxArray) {
                cb.position.x += playerSpeed;
            }
            moving = true;
        }

        if (up && !down) {
            position.y -= playerSpeed;
            for (Checkbox cb : checkboxArray) {
                cb.position.y -= playerSpeed;
            }
            moving = true;
        } else if (down && !up) {
            position.y += playerSpeed;
            for (Checkbox cb : checkboxArray) {
                cb.position.y += playerSpeed;
            }
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
//        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
//        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
//        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
//        this.down = down;
    }

    public void draw(ShapeRenderer sr, SpriteBatch sb) {
        // 100 x 100
        sb.draw(animations[playerAction][aniIndex], finalPosition.x, finalPosition.y, width, height);
    }
}
