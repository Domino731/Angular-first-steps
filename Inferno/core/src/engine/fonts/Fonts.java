package engine.fonts;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;
import engine.Textures;
import utils.Json;

import java.util.HashMap;

import static utils.TxtUtils.getPixmapFromTextureRegion;

public class Fonts {
    private static final JsonNode configNode = Json.readFile(Urls.CONFIG_FONTS_4);
    private static final JsonNode configNode1 = Json.readFile(Urls.CONFIG_FONTS_1);
    private static final HashMap<String, Config> data = createFonts();
    private static final HashMap<String, Config> data1Black = new HashMap<>();
    private static final HashMap<String, Config> data1 = createFonts1();

    public static class Config {
        private final String id;
        private final TextureRegion txt;
        private final TextureRegion blackTxt;
        private final byte width;
        private final byte height;


        Config(String id, TextureRegion txt, TextureRegion blackTxt, byte width, byte height) {
            this.id = id;
            this.txt = txt;
            this.width = width;
            this.height = height;
            this.blackTxt = blackTxt;
        }

        public String getId() {
            return id;
        }
        public TextureRegion getTxt() {
            return txt;
        }
        public TextureRegion getBlackTxt() {
            return blackTxt;
        }
        public byte getWidth() {
            return width;
        }
        public byte getHeight() {
            return height;
        }
    }

    private static HashMap<String, Config> createFonts() {
        HashMap<String, Config> fonts = new HashMap<>();

        if(configNode.isArray()) {
            for (JsonNode node: configNode) {
               int x = node.get("x").asInt();
               int y= node.get("y").asInt();
               byte width = (byte) node.get("width").asInt();
               byte height = (byte) node.get("height").asInt();
               String id = node.get("letter").asText();
               TextureRegion  txt = createTexture(x,y,width,height);
               fonts.put(id, new Config(id, txt, txt, width, height));
            }
        }

        return fonts;
    }

    private static HashMap<String, Config> createFonts1() {
        HashMap<String, Config> fonts = new HashMap<>();

        if(configNode.isArray()) {
            for (JsonNode node: configNode1) {
                int x = node.get("x").asInt();
                int y= node.get("y").asInt();
                byte width = (byte) node.get("width").asInt();
                byte height = (byte) node.get("height").asInt();
                String id = node.get("letter").asText();
                TextureRegion  txt = createTexture(x,y,width,height);
                TextureRegion blackTxt = paintLetter(txt);
                fonts.put(id, new Config(id, txt, blackTxt, width, height));
            }
        }

        return fonts;
    }

    private static TextureRegion createTexture(int x, int y, int width, int height ) {
        return new TextureRegion(Textures.fontsTxt, x, y, width, height);
    }

    public static TextureRegion paintLetter(TextureRegion letterTexture) {
        Pixmap pixmap = getPixmapFromTextureRegion(letterTexture);
        pixmap.setBlending(Pixmap.Blending.None);

        for (int x = 0; x < pixmap.getWidth(); x++) {
            for (int y = 0; y < pixmap.getHeight(); y++) {
                int color = pixmap.getPixel(x, y);

                if(color == -1 || color == -171) {
                    pixmap.drawPixel(x, y, 255);
                }
                else {
                    pixmap.drawPixel(x, y, -1);
                }
            }
        }
//        Pixmap copiedPixmap = new Pixmap(pixmap .getWidth(), pixmap .getHeight(), pixmap.getFormat());
//
        for (int y = 0; y < pixmap.getHeight(); y++) {
            int firstBlackPixelIndex = -1;
            for (int x = 0; x < pixmap.getWidth(); x++) {
                if(pixmap.getPixel(x,y) == 255 && firstBlackPixelIndex == -1) {
                    firstBlackPixelIndex = x;
                    break;
                }
            }
            for (int x = 0; x < firstBlackPixelIndex; x++) {
                pixmap.drawPixel(x, y, pixmap.getPixel(x, y) & 0xffffff00);
            }

            int lastBlackPixelIndex = -1;
            for (int x = pixmap.getWidth() - 1; x >= 0; x--) {
                if(pixmap.getPixel(x,y) == 255 && lastBlackPixelIndex == -1) {
                    lastBlackPixelIndex = x + 1;
                    break;
                }
            }

            for (int x = lastBlackPixelIndex; x < pixmap.getWidth(); x++) {
                pixmap.drawPixel(x, y, pixmap.getPixel(x, y) & 0xffffff00);
            }
//            pixmap.drawPixel(lastBlackPixelIndex, y, pixmap.getPixel(lastBlackPixelIndex, y) & 1129837);

        }

        Texture newTxt = new Texture(pixmap);
        Pixmap newPixmap = getPixmapFromTextureRegion(new TextureRegion(newTxt));

//        pixmap.dispose();



        return new TextureRegion(newTxt);
    }

    public static Config getLetter(String letter) {
        return data.get(letter);
    }

    public static Config getLetter1(String letter) {
        return data1.get(letter);
    }

    public static TextureRegion getBlackLetter1(String letter) {
        return data1.get(letter).getBlackTxt();
    }
}
