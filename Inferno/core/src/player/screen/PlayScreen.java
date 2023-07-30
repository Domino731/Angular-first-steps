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
import utils.vectors.Vector;


public class PlayScreen implements Screen {
    private MyGdxGame game;
    private LevelManager levelManager;
    private ActorsManager actorsManager;
    private NewPlayer newPlayer;
    Texture txt;
    Sprite sprite;
    OrthographicCamera camera;
    final float GAME_WORLD_WIDTH = 100;
    final float GAME_WORLD_HEIGHT = 100;

    private TestObject testObject;

    public PlayScreen(MyGdxGame game) {
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.translate(camera.viewportWidth / 2, camera.viewportHeight / 2);
        sprite = new Sprite(new Texture(Gdx.files.internal("testImg.jpg")));
        sprite.setSize(GAME_WORLD_WIDTH, GAME_WORLD_HEIGHT);
        this.game = game;
        levelManager = new LevelManager();
        txt = new Texture("download.jpg");
        actorsManager = new ActorsManager();
        newPlayer = actorsManager.player;

        Gdx.input.setInputProcessor(new GameInputProcessor(actorsManager));
        testObject = new TestObject();

        camera.zoom = 0.5f;
    }

    @Override
    public void show() {

    }

    private void update() {
        ScreenUtils.clear(0, 0, 0, 1);
        Vector<Integer> position = newPlayer.getPosition();
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
//        game.batch.draw(txt, 0, 0);

//        game.batch.draw(txt, 10, 10);
//        game.batch.draw(txt, 20, 20, 100, 100);
        game.batch.end();

//        game.batch.begin();

//        levelManager.render(game.batch);

//        game.batch.end();

//        actorsManager.update();

//        game.batch.begin();
//
//        levelManager.render(game.batch);
//        actorsManager.draw(game.batch);
//
//        game.batch.end();
//
//        if (game.showCheckboxes) {
//            actorsManager.renderCheckboxes(game.sr);
//        }
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
