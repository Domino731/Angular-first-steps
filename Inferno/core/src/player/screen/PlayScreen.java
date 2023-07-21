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
import player.TestObject;
import utils.Checkbox;

import java.util.Vector;

public class PlayScreen implements Screen {
    private MyGdxGame game;
    private LevelManager levelManager;
    private Player player;
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
        sr = new ShapeRenderer();
        camera.translate(camera.viewportWidth / 2, camera.viewportHeight / 2);
        Gdx.input.setInputProcessor(new GameInputProcessor(player));
        testObject = new TestObject();

        checkboxes.addAll(testObject.checkboxArrayList);
        checkboxes.addAll(player.checkboxArray);
    }

    @Override
    public void show() {

    }

    private void update(float delta) {
        // Loop to check collisions
        for (int i = 0; i < checkboxes.size(); i++) {
            Checkbox checkbox1 = checkboxes.get(i);
            for (int j = i + 1; j < checkboxes.size(); j++) {
                Checkbox checkbox2 = checkboxes.get(j);

                if (checkCollision(checkbox1, checkbox2)) {
                    // Collision detected between checkbox1 and checkbox2
                    System.out.println("Collision between checkbox " + i + " and checkbox " + j);
                }
            }
        }

        player.update();
    }

    public static boolean checkCollision(Checkbox checkbox1, Checkbox checkbox2) {
        // Check for collision using the separating axis theorem
        boolean xCollision = Math.abs(checkbox1.position.x - checkbox2.position.x) < (checkbox1.dim.width + checkbox2.dim.width) / 2;
        boolean yCollision = Math.abs(checkbox1.position.y - checkbox2.position.y) < (checkbox1.dim.height + checkbox2.dim.height) / 2;

        // Calculate the coordinates of the bounding boxes
        int x1 = checkbox1.position.x;
        int y1 = checkbox1.position.y;
        int width1 = checkbox1.dim.width;
        int height1 = checkbox1.dim.height;
        int x2 = checkbox2.position.x;
        int y2 = checkbox2.position.y;
        int width2 = checkbox2.dim.width;
        int height2 = checkbox2.dim.height;

        // Check for overlap
        if (x1 < x2 + width2 && x1 + width1 > x2 && y1 < y2 + height2 && y1 + height1 > y2) {
            // Overlapping
            return true;
        }

        // No overlap
        return false;
//        return xCollision && yCollision;
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
