package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import levelManager.LevelManager;

public class PlayScreen implements Screen {
    private MyGdxGame game;
    private OrthographicCamera gameCam;
    private Viewport gamePort;
    private Texture img;
    private LevelManager levelManager;

    
    OrthographicCamera camera = new OrthographicCamera();
    public PlayScreen(MyGdxGame game) {
        this.game = game;
        img = new Texture("badlogic.jpg");
        gameCam = new OrthographicCamera();
        gameCam.zoom = 0.3F;
        gamePort = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), gameCam);

        gamePort = new FitViewport(1920, 1080, gameCam);
        int screenWidth = 800;
        int screenHeight = 600;
        levelManager = new LevelManager();
        camera.setToOrtho(false, screenWidth, screenHeight);

//        gamePort.update(windowWidth, windowHeight, true);

        gameCam.position.set(0, 0, 0);
    }

    @Override
    public void show() {

    }

    private void update(float delta) {
        if(Gdx.input.isTouched()){
            System.out.println(1);
            gameCam.position.x += 100 * delta;
        }

        gameCam.update();
    }

    @Override
    public void render(float delta) {
        update(delta);
        ScreenUtils.clear(0, 0, 0, 1);
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        levelManager.render(game.batch);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
//          gamePort.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
