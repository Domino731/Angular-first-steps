package inputs;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import game.entities.player.NewPlayer;
import player.Player;

public class GameInputProcessor implements InputProcessor {

    private Player player;
    private NewPlayer newPlayer;

    public GameInputProcessor(Player player, NewPlayer newPlayer) {
        this.player = player;
        this.newPlayer = newPlayer;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                player.setUp(true);
                newPlayer.setTop(true);
                break;
            case Input.Keys.A:
                player.setLeft(true);
                newPlayer.setLeft(true);
                break;
            case Input.Keys.S:
                player.setDown(true);
                newPlayer.setBot(true);
                break;
            case Input.Keys.D:
                player.setRight(true);
                newPlayer.setRight(true);
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                player.setUp(false);
                newPlayer.setTop(false);
                break;
            case Input.Keys.A:
                player.setLeft(false);
                newPlayer.setLeft(false);
                break;
            case Input.Keys.S:
                player.setDown(false);
                newPlayer.setBot(false);
                break;
            case Input.Keys.D:
                player.setRight(false);
                newPlayer.setRight(false);
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
