package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
    Texture newTexture;

    public PlayScreen(MyGdxGame game) {
        this.game = game;
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.translate(camera.viewportWidth / 2, camera.viewportHeight / 2);
        levelManager = new LevelManager();
        actorsManager = new ActorsManager();
        player = actorsManager.player;
        Gdx.input.setInputProcessor(new GameInputProcessor(actorsManager));
        camera.zoom = 0.2f;
        newTexture = createHair();
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

    static Texture createHair() {
        Texture texture = new Texture("sprites/style/hairs.png");
        texture = new TextureRegion(texture, 0, 0, 16, 16).getTexture();
        TextureData textureData = texture.getTextureData();
        if (!textureData.isPrepared()) {
            textureData.prepare();
        }

        Pixmap pixmap = textureData.consumePixmap();

        for (int x = 0; x < pixmap.getWidth(); x++) {
            for (int y = 0; y < pixmap.getHeight(); y++) {
                // Get the current pixel color
                int colorInt = pixmap.getPixel(x, y);

                // Extract the RGB components
                int r = (colorInt & 0xff000000) >>> 24; // Red component (8 bits)
                int g = (colorInt & 0x00ff0000) >>> 16; // Green component (8 bits)
                int b = (colorInt & 0x0000ff00) >>> 8;  // Blue component (8 bits)
                int a = colorInt & 0x000000ff;         // Alpha component (8 bits)

                // Increase the green component (you can adjust this value as needed)
                g = Math.min(g + 50, 255); // In this example, we're increasing green by 50

                // Recombine the components and update the pixel
                colorInt = (r << 24) | (g << 16) | (b << 8) | a;
                pixmap.drawPixel(x, y, colorInt);
            }
        }
        return new Texture(pixmap);

    }

    @Override
    public void render(float delta) {
        update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        levelManager.render(game.batch);
        actorsManager.draw(game.batch);
        game.batch.draw(newTexture, 0, 0);
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
//        sprite.getTexture().dispose();
    }
}
