package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;
import engine.actorsManager.ActorsManager;
import game.entities.player.Player;
import inputs.GameInputProcessor;
import levelManager.LevelManager;
import utils.vectors.Vector;


public class PlayScreen implements Screen {
    private MyGdxGame game;
    private LevelManager levelManager;
    private ActorsManager actorsManager;
    private Player player;
    Sprite sprite;
    OrthographicCamera camera;

    public PlayScreen(MyGdxGame game) {
        this.game = game;
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.translate(camera.viewportWidth / 2, camera.viewportHeight / 2);
        levelManager = new LevelManager();
        actorsManager = new ActorsManager();
        player = actorsManager.player;
        Gdx.input.setInputProcessor(new GameInputProcessor(actorsManager));
        camera.zoom = 0.1f;
    }

    @Override
    public void show() {

    }

    private void update() {
        ScreenUtils.clear(0, 0, 0, 1);
        Vector<Integer> position = player.getPosition();
        camera.position.set(position.x, position.y, 0);
        camera.update();
        actorsManager.update();
    }

    @Override
    public void render(float delta) {
        update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        levelManager.render(game.batch);
        actorsManager.draw(game.batch);
        game.batch.end();


        player.inventory.draw();
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
//        sprite.getTexture().dispose();
    }
}
