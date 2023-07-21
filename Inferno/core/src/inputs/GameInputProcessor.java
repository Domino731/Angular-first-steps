package inputs;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import player.Player;

public class GameInputProcessor implements InputProcessor {

    private Player player;

    public GameInputProcessor(Player player) {
        this.player = player;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                player.setUp(true);
                break;
            case Input.Keys.A:
                player.setLeft(true);
                break;
            case Input.Keys.S:
                player.setDown(true);
                break;
            case Input.Keys.D:
                player.setRight(true);
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                player.setUp(false);
                break;
            case Input.Keys.A:
                player.setLeft(false);
                break;
            case Input.Keys.S:
                player.setDown(false);
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
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
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
