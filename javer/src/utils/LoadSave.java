package javer.src.utils;

import javer.src.Engine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave {
    public static final String PLAYER_ATLAS_NAME = "player_sprites.png";
    public static final String LEVEL_ATLAS_NAME = "outside_sprites.png";
    public static final String LEVEL_1_DATA = "level_one_data.png";
    public static final String LEVEL_ATLAS = "outside_sprites.png";

    public static BufferedImage getSpriteAtlas(String fileName){
        InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);
        BufferedImage img = null;
        try {
           img = ImageIO.read(is);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }

    public static int[][] getLevelData() {
        int[][] lvlData = new int[Engine.TILES_IN_HEIGHT][Engine.TILES_IN_WIDTH];
        BufferedImage img = getSpriteAtlas(LEVEL_1_DATA);

        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getRed();
                if (value >= 48)
                    value = 0;
                lvlData[j][i] = value;
            }
        return lvlData;

    }
}
