package player.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;
import engine.actorsManager.ActorsManager;
import game.entities.player.NewPlayer;
import inputs.GameInputProcessor;
import levelManager.LevelManager;
import player.TestObject;
import utils.Checkbox;

import java.util.Vector;

public class PlayScreen implements Screen {
    private MyGdxGame game;
    private LevelManager levelManager;
    private ActorsManager actorsManager;
    private NewPlayer newPlayer;

    Sprite sprite;
    OrthographicCamera camera;
    final float GAME_WORLD_WIDTH = 100;
    final float GAME_WORLD_HEIGHT = 100;

    private TestObject testObject;
    public Vector<Checkbox> checkboxes = new Vector<>();

    public PlayScreen(MyGdxGame game) {
        sprite = new Sprite(new Texture(Gdx.files.internal("testImg.jpg")));
        sprite.setSize(GAME_WORLD_WIDTH, GAME_WORLD_HEIGHT);
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        this.game = game;
        levelManager = new LevelManager();

        actorsManager = new ActorsManager();
        newPlayer = actorsManager.player;

        camera.translate(camera.viewportWidth / 2, camera.viewportHeight / 2);
        Gdx.input.setInputProcessor(new GameInputProcessor(actorsManager));
        testObject = new TestObject();

        checkboxes.addAll(testObject.checkboxArrayList);
        checkboxes.addAll(newPlayer.getCheckboxArray());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        actorsManager.update();
        ScreenUtils.clear(0, 0, 0, 1);
        camera.update();
        game.batch.begin();
        game.batch.setProjectionMatrix(camera.combined);

        levelManager.render(game.batch);
        actorsManager.draw(game.batch);
        testObject.draw(game.batch);

        game.batch.end();
        if (game.showCheckboxes) {
            actorsManager.renderCheckboxes(game.sr);
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
        sprite.getTexture().dispose();
    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        sprite.getTexture().dispose();
    }
}
