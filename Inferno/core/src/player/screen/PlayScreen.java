package player.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;
import environment.trees.ExampleTree;
import game.entities.player.NewPlayer;
import inputs.GameInputProcessor;
import levelManager.LevelManager;
import player.Player;
import player.TestObject;
import utils.Checkbox;

import java.util.Vector;

public class PlayScreen implements Screen {
    private MyGdxGame game;
    private LevelManager levelManager;
    private Player player;
    private NewPlayer newPlayer;
    private ExampleTree exampleTree;
    private ShapeRenderer sr;

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
        player = new Player();
        newPlayer = new NewPlayer();
        exampleTree = new ExampleTree();
        sr = new ShapeRenderer();
        camera.translate(camera.viewportWidth / 2, camera.viewportHeight / 2);
        Gdx.input.setInputProcessor(new GameInputProcessor(player, newPlayer));
        testObject = new TestObject();

        checkboxes.addAll(testObject.checkboxArrayList);
        checkboxes.addAll(newPlayer.getCheckboxArray());
    }

    @Override
    public void show() {

    }

    private void update(float delta) {
//        player.isCollision = false;
        newPlayer.setIsCollision(false);

//        player.updatePos();
        newPlayer.updatePos();

        // Loop to check collisions
        for (int i = 0; i < checkboxes.size(); i++) {
            Checkbox checkbox1 = checkboxes.get(i);
            for (int j = i + 1; j < checkboxes.size(); j++) {
                Checkbox checkbox2 = checkboxes.get(j);
                if (checkCollision(checkbox1, checkbox2)) {
//                    player.isCollision = true;
                    newPlayer.setIsCollision(true);

                    player.resetPosition();
                    newPlayer.resetPosition();
                }
            }
        }

        player.update();
        newPlayer.update();
    }


    public static boolean checkCollision(Checkbox checkbox1, Checkbox checkbox2) {
        // Calculate the coordinates of the bounding boxes
        int x1 = checkbox1.position.x;
        int y1 = checkbox1.position.y;
        int width1 = checkbox1.dim.width;
        int height1 = checkbox1.dim.height;
        int x2 = checkbox2.position.x;
        int y2 = checkbox2.position.y;
        int width2 = checkbox2.dim.width;
        int height2 = checkbox2.dim.height;
        if (x1 < x2 + width2 && x1 + width1 > x2 && y1 < y2 + height2 && y1 + height1 > y2) {
            return true;
        }
        return false;
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
        newPlayer.draw(game.batch);
        testObject.draw(game.batch);
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
