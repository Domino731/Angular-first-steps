package inputs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import engine.actionCollision.actorsManager.ActorsManager;
import game.entities.player.Player;

public class GameInputProcessor implements InputProcessor {
    private ActorsManager actorsManager;
    private Player player;
    private static int screenXOffset = 800;

    public GameInputProcessor(ActorsManager actorsManager) {
        this.actorsManager = actorsManager;
        player = this.actorsManager.player;
    }

    public static int getScreenXOffset() {
        return screenXOffset;
    }

    public static void setScreenXOffset(int screenXOffset) {
        GameInputProcessor.screenXOffset = screenXOffset;
    }

    public static void increaseScreenXOffset(int increaseValue) {
        int multiplier = 5;
        GameInputProcessor.screenXOffset += increaseValue * multiplier;
        System.out.println("NEW OFFSET: " + screenXOffset);
    }

    public static void decreaseScreenXOffset(int increaseValue) {
        int multiplier = 5;
        GameInputProcessor.screenXOffset -= increaseValue * multiplier;
        System.out.println("NEW OFFSET: " + screenXOffset);
    }

    @Override
    public boolean keyDown(int keycode) {
        System.err.println(keycode);
        switch (keycode) {
            // PLAYER MOVEMENT
            case Input.Keys.W:
                player.setTop(true);
                break;
            case Input.Keys.A:
                player.setLeft(true);
                break;
            case Input.Keys.S:
                player.setBot(true);
                break;
            case Input.Keys.D:
                player.setRight(true);
                break;
            case Input.Keys.E:
//                if (actorsManager.currentAction != null) {
                player.startStaticAction();
//                }
                break;
            case Input.Keys.NUM_1:
                player.changeInventorySlot((byte) 0);
                break;
            case Input.Keys.NUM_2:
                player.changeInventorySlot((byte) 1);
                break;
            case Input.Keys.NUM_3:
                player.changeInventorySlot((byte) 2);
                break;
            case Input.Keys.NUM_4:
                player.changeInventorySlot((byte) 3);
                break;
            case Input.Keys.NUM_5:
                player.changeInventorySlot((byte) 4);
                break;
            case Input.Keys.NUM_6:
                player.changeInventorySlot((byte) 5);
                break;
            case Input.Keys.NUM_7:
                player.changeInventorySlot((byte) 6);
                break;
            case Input.Keys.NUM_8:
                player.changeInventorySlot((byte) 7);
                break;
            case Input.Keys.NUM_9:
                player.changeInventorySlot((byte) 8);
                break;
            case Input.Keys.NUM_0:
                player.changeInventorySlot((byte) 9);
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                player.setTop(false);
                break;
            case Input.Keys.A:
                player.setLeft(false);
                break;
            case Input.Keys.S:
                player.setBot(false);
                break;
            case Input.Keys.D:
                player.setRight(false);
                break;
        }
        return true;
    }

    // Implement other methods of the InputProcessor interface as needed
    // such as touchDown, touchUp, etc. (you can leave them empty if not used)

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        System.out.println("button: " + button);
        if (button == Input.Buttons.LEFT) {
            actorsManager.onMouseRightClick(x, y);
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        // TODO: make xOffset dynamic based on player spawn
        int tileX2 = (int) (screenX * 0.2) / 16;
        int tileY2 = (int) (screenX * 0.2);
        int tileX = (int) ((screenX - screenXOffset) * 0.2);
        int tileY = (int) ((Gdx.graphics.getHeight() - screenY) * 0.2);
        tileX /= 16;
        tileY /= 16;
        System.out.println(screenXOffset);
        System.out.println("HOVER TILE: " + tileX + " " + tileY);
        actorsManager.hoverTile(tileX, tileY);
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    public boolean scrolled(int amount) {
        return false;
    }
}
