package player.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;
import inputs.GameInputProcessor;
import levelManager.LevelManager;
import player.Player;

public class PlayScreen implements Screen {
    private MyGdxGame game;
    private LevelManager levelManager;
    private Player player;
    private ShapeRenderer sr;

    Sprite sprite;
    OrthographicCamera camera;
    final float GAME_WORLD_WIDTH = 100;
    final float GAME_WORLD_HEIGHT = 100;

    public PlayScreen(MyGdxGame game) {
        sprite = new Sprite(new Texture(Gdx.files.internal("testImg.jpg")));
        sprite.setSize(GAME_WORLD_WIDTH, GAME_WORLD_HEIGHT);
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        this.game = game;
        levelManager = new LevelManager();
        player = new Player();
        sr = new ShapeRenderer();
        camera.translate(camera.viewportWidth / 2, camera.viewportHeight / 2);
        Gdx.input.setInputProcessor(new GameInputProcessor(player));
    }

    @Override
    public void show() {

    }

    private void update(float delta) {
        player.update();
    }

    @Override
    public void render(float delta) {
        update(delta);
        ScreenUtils.clear(0, 0, 0, 1);
        camera.update();
        game.batch.begin();
        game.batch.setProjectionMatrix(camera.combined);

        levelManager.render(game.batch);
        player.draw(sr, game.batch);
        game.batch.end();
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
