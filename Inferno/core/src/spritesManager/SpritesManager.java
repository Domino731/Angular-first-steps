package spritesManager;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

public class SpritesManager {
    private static HashMap<String, TextureRegion> textureRegionMap = new HashMap<>();
    private static AssetManager assetManager = loadData();


    public SpritesManager(){

    }

    private static AssetManager loadData() {
        AssetManager assetManager = new AssetManager();
        assetManager.load("sprites/tileSets/outdoors_summer.png", Texture.class);
        assetManager.finishLoading();

        // set default tile
        Texture mySpriteTexture = assetManager.get("sprites/tileSets/outdoors_summer.png", Texture.class);
        TextureRegion spriteRegion = new TextureRegion(mySpriteTexture, Constants.DEFAULT_TILE_CORDS.x, Constants.DEFAULT_TILE_CORDS.y, Constants.TILE_SIZE, Constants.TILE_SIZE);
        textureRegionMap.put(Constants.DEFAULT_TILE_TEXTURE_REGION, spriteRegion);

        return assetManager;
    }

    public static TextureRegion test() {
        Texture mySpriteTexture = assetManager.get("sprites/tileSets/outdoors_summer.png", Texture.class);
        TextureRegion spriteRegion = new TextureRegion(mySpriteTexture, Constants.DEFAULT_TILE_CORDS.x, Constants.DEFAULT_TILE_CORDS.y, Constants.TILE_SIZE, Constants.TILE_SIZE);

        return spriteRegion;
    }
}
