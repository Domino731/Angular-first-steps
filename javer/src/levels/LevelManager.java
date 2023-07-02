package javer.src.levels;

import javer.src.Engine;
import javer.src.utils.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelManager {

    private Engine engine;
    private BufferedImage[] levelSprite;
    private Level levelOne;

    public LevelManager(Engine engine) {
        this.engine = engine;
        importOutsideSprites();
        levelOne = new Level(LoadSave.getLevelData());
    }

    private void importOutsideSprites() {
        BufferedImage img = LoadSave.getSpriteAtlas(LoadSave.LEVEL_ATLAS);
        levelSprite = new BufferedImage[48];
        for (int j = 0; j < 4; j++)
            for (int i = 0; i < 12; i++) {
                int index = j * 12 + i;
                levelSprite[index] = img.getSubimage(i * 32, j * 32, 32, 32);
            }
    }

    public void draw(Graphics g) {
        for (int j = 0; j < Engine.TILES_IN_HEIGHT; j++)
            for (int i = 0; i < Engine.TILES_IN_WIDTH; i++) {
                int index = levelOne.getSpriteIndex(i, j);
                g.drawImage(levelSprite[index], Engine.TILES_SIZE * i, Engine.TILES_SIZE * j, Engine.TILES_SIZE, Engine.TILES_SIZE, null);
            }
    }

    public void update() {

    }

}
