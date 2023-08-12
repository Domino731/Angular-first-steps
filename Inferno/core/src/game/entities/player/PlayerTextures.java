package game.entities.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import spritesManager.SpritesManager;
import utils.EngineLog;
import utils.Json;
import utils.colors.ColorSorter;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.io.IOException;


public class PlayerTextures {
    // IDLE
    public static final int STATE_IDLE_UP = 0;
    public static final int STATE_IDLE_RIGHT = 1;
    public static final int STATE_IDLE_DOWN = 2;
    public static final int STATE_IDLE_LEFT = 3;
    // RUNNING
    public static final int STATE_RUNNING_UP = 4;
    public static final int STATE_RUNNING_RIGHT = 5;
    public static final int STATE_RUNNING_DOWN = 6;
    public static final int STATE_RUNNING_LEFT = 7;
    // HAIR
    public static final int STATE_HAIR_UP = 0;
    public static final int STATE_HAIR_RIGHT = 1;
    public static final int STATE_HAIR_DOWN = 2;
    public static final int STATE_HAIR_LEFT = 3;

    public static final int STATE_HAT_UP = 0;
    public static final int STATE_HAT_RIGHT = 1;
    public static final int STATE_HAT_DOWN = 2;
    public static final int STATE_HAT_LEFT = 3;

    public static final int MAX_ANIMATION_FRAMES = 6;
    public static final byte ARMS_MAX_TEXTURES = 8;
    private static final Texture hairTexture = new Texture("sprites/style/hairs.png");
    private static final Texture hatsTexture = new Texture("sprites/style/hats.png");
    private static final Texture shirtsTexture = new Texture("sprites/style/shirts.png");
    private Texture pantsTxt = new Texture("sprites/style/pants.png");

    public static final byte STATE_TEXTURE_UP = 0;
    public static final byte STATE_TEXTURE_RIGHT = 1;
    public static final byte STATE_TEXTURE_DOWN = 2;
    public static final byte STATE_TEXTURE_LEFT = 3;

    public TextureRegion[][] bodyTextures;
    public TextureRegion[][] armsTextures;
    public TextureRegion[][] pantsTextures;

    private final int textureWidth = 16;
    private final int textureHeight = 32;

    public PlayerTextures() {
        bodyTextures = new TextureRegion[ARMS_MAX_TEXTURES][MAX_ANIMATION_FRAMES];
        armsTextures = new TextureRegion[ARMS_MAX_TEXTURES][MAX_ANIMATION_FRAMES];
        pantsTextures = new TextureRegion[ARMS_MAX_TEXTURES][MAX_ANIMATION_FRAMES];

        readJson();
    }

    public static TextureRegion[] getShirts() {
        TextureRegion[] shirts = new TextureRegion[4];

        byte x = 2;
        byte y = 0;

        byte width = PlayerConstants.shirtDim.width;
        byte height = PlayerConstants.shirtDim.height;

        int xOffset = x * PlayerConstants.shirtDim.width;
        int yOffset = y * PlayerConstants.shirtDim.height;

        // top, right, left, bot
        shirts[STATE_TEXTURE_UP] = new TextureRegion(shirtsTexture, xOffset, yOffset + (3 * height), width, height);
        shirts[STATE_TEXTURE_RIGHT] = new TextureRegion(shirtsTexture, xOffset, yOffset + height, width, height);
        shirts[STATE_TEXTURE_LEFT] = new TextureRegion(shirtsTexture, xOffset, yOffset + (2 * height), width, height);
        shirts[STATE_TEXTURE_DOWN] = new TextureRegion(shirtsTexture, xOffset, yOffset, width, height);

        return shirts;
    }


    public static TextureRegion[] getHat(HatsNames hatId) {
        PlayerHatsData.Config hatData = PlayerHatsData.getHat(hatId);
        Vector<Byte> hairOffset = hatData.getOffset();
        TextureRegion[] hats = new TextureRegion[4];
        byte size = PlayerHatsData.HAT_SIZE;
        final int xOffset = hairOffset.x * size;
        final int yOffset = hairOffset.y * size;

        hats[STATE_HAT_DOWN] = new TextureRegion(hatsTexture, xOffset, yOffset + (size * 0), size, size);
        hats[STATE_HAT_RIGHT] = new TextureRegion(hatsTexture, xOffset, yOffset + (size * 1), size, size);
        hats[STATE_HAT_LEFT] = new TextureRegion(hatsTexture, xOffset, yOffset + (size * 2), size, size);
        hats[STATE_HAT_UP] = new TextureRegion(hatsTexture, xOffset, yOffset + (size * 3), size, size);
        return hats;
    }

    public static TextureRegion[] getHair(String hairId) {
        TextureData textureData = hairTexture.getTextureData();
        PlayerHairsData.Config hairData = PlayerHairsData.getHairData(hairId);
        Vector<Byte> hairOffset = hairData.getOffset();

        if (!textureData.isPrepared()) {
            textureData.prepare();
        }

        Pixmap pixmap = textureData.consumePixmap();

        Integer[] colors = ColorSorter.sort(PlayerConstants.skinColors);

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
                r = Math.min(r + 50, 255); // In this example, we're increasing green by 50

                // Recombine the components and update the pixel
                colorInt = (r << 24) | (g << 16) | (b << 8) | a;

                pixmap.drawPixel(x, y, colorInt);
//                pixmap.drawPixel(x, y, colorInt);
            }
        }

        Texture coloredHair = new Texture(pixmap);
        TextureRegion[] hairs = new TextureRegion[4];
        DimensionVector<Byte> HAIR_SIZE = PlayerHairsData.HAIR_SIZE;
        int xOffset = hairOffset.x * HAIR_SIZE.width;
        int yOffset = hairOffset.y * HAIR_SIZE.height;

        hairs[STATE_HAIR_UP] = new TextureRegion(coloredHair, xOffset, yOffset + (HAIR_SIZE.height * 2), HAIR_SIZE.width, HAIR_SIZE.height);
        hairs[STATE_HAIR_RIGHT] = new TextureRegion(coloredHair, xOffset, yOffset + (HAIR_SIZE.height * 1), HAIR_SIZE.width, HAIR_SIZE.height);
        hairs[STATE_HAIR_DOWN] = new TextureRegion(coloredHair, xOffset, yOffset + (HAIR_SIZE.height * 0), HAIR_SIZE.width, HAIR_SIZE.height);
        hairs[STATE_HAIR_LEFT] = new TextureRegion(coloredHair, xOffset, yOffset + (HAIR_SIZE.height * 1), HAIR_SIZE.width, HAIR_SIZE.height);
        hairs[STATE_HAIR_LEFT].flip(true, false);
        return hairs;
    }

    public static int hairTextureIndexByAction(int playerAction) {
        switch (playerAction) {
            case STATE_IDLE_UP:
            case STATE_RUNNING_UP:
                return STATE_HAIR_UP;
            case STATE_IDLE_RIGHT:
            case STATE_RUNNING_RIGHT:
                return STATE_HAIR_RIGHT;
            case STATE_IDLE_DOWN:
            case STATE_RUNNING_DOWN:
                return STATE_HAIR_DOWN;
            case STATE_IDLE_LEFT:
            case STATE_RUNNING_LEFT:
                return STATE_HAIR_LEFT;
            default:
                return 0;
        }
    }

    public static byte hatTextureIndexByAction(int playerAction) {
        switch (playerAction) {
            case STATE_IDLE_UP:
            case STATE_RUNNING_UP:
                return STATE_HAT_UP;
            case STATE_IDLE_RIGHT:
            case STATE_RUNNING_RIGHT:
                return STATE_HAT_RIGHT;
            case STATE_IDLE_DOWN:
            case STATE_RUNNING_DOWN:
                return STATE_HAT_DOWN;
            case STATE_IDLE_LEFT:
            case STATE_RUNNING_LEFT:
                return STATE_HAT_LEFT;
            default:
                return 0;
        }
    }

    public static int actionTextureAmount(int player_action) {
        switch (player_action) {
            // running
            case STATE_RUNNING_LEFT:
            case STATE_RUNNING_RIGHT:
            case STATE_RUNNING_DOWN:
            case STATE_RUNNING_UP:
                return 6;
            // idle
            case STATE_IDLE_UP:
            case STATE_IDLE_RIGHT:
            case STATE_IDLE_DOWN:
            case STATE_IDLE_LEFT:
                return 1;
            default:
                return 1;
        }
    }

    public static int idleActionByLastAction(int playerAction) {
        switch (playerAction) {
            case STATE_IDLE_UP:
            case STATE_IDLE_RIGHT:
            case STATE_IDLE_DOWN:
            case STATE_IDLE_LEFT:
                return playerAction;
            case STATE_RUNNING_UP:
                return STATE_IDLE_UP;
            case STATE_RUNNING_RIGHT:
                return STATE_IDLE_RIGHT;
            case STATE_RUNNING_DOWN:
                return STATE_IDLE_DOWN;
            case STATE_RUNNING_LEFT:
                return STATE_IDLE_LEFT;
            default:
                return STATE_IDLE_DOWN;
        }
    }

    private void readJson() {
        FileHandle fileHandle = Gdx.files.internal("config/playerConfig.json");
        if (fileHandle.exists()) {
            try {
                JsonNode jsonNode = Json.parse(fileHandle.readString()).get("animations");
                Texture texture = SpritesManager.loadSprite("sprites/entities/player_new_1.png");

                loadAnimationTextures(jsonNode.get("body"), bodyTextures, texture, true);
                loadAnimationTextures(jsonNode.get("arms"), armsTextures, texture, false);
            } catch (IOException e) {
                EngineLog.resourceError("config/playerConfig.json");
            }
        }
    }

    private void loadAnimationTextures(JsonNode animationNode, TextureRegion[][] textures, Texture texture, boolean loadPants) {
        if (animationNode == null) {
            return;
        }

        JsonNode runningHorizontally = animationNode.get("runningHorizontally");
        JsonNode runningDown = animationNode.get("runningDown");
        JsonNode runningUp = animationNode.get("runningUp");
        JsonNode idleUp = animationNode.get("idleUp");
        JsonNode idleHorizontally = animationNode.get("idleHorizontally");
        JsonNode idleDown = animationNode.get("idleDown");

        // IDLE
        if (idleUp != null && idleUp.isArray()) {
            loadTexturesForAnimationState(textures, STATE_IDLE_UP, idleUp, texture, loadPants);
        }
        if (idleHorizontally != null && idleHorizontally.isArray()) {
            loadHorizontallyTexturesForAnimationState(textures, STATE_IDLE_LEFT, STATE_IDLE_RIGHT, idleHorizontally, texture, loadPants);
        }
        if (idleDown != null && idleDown.isArray()) {
            loadTexturesForAnimationState(textures, STATE_IDLE_DOWN, idleDown, texture, loadPants);
        }
        // RUNNING
        if (runningHorizontally != null && runningHorizontally.isArray()) {
            loadHorizontallyTexturesForAnimationState(textures, STATE_RUNNING_LEFT, STATE_RUNNING_RIGHT, runningHorizontally, texture, loadPants);
        }
        if (runningDown != null && runningDown.isArray()) {
            loadTexturesForAnimationState(textures, STATE_RUNNING_DOWN, runningDown, texture, loadPants);
        }
        if (runningUp != null && runningUp.isArray()) {
            loadTexturesForAnimationState(textures, STATE_RUNNING_UP, runningUp, texture, loadPants);
        }
    }

    private void loadTexturesForAnimationState(TextureRegion[][] textures, int state, JsonNode animationNode, Texture texture, boolean loadPants) {
        int i = 0;
        for (JsonNode cord : animationNode) {
            int x = cord.get(0).shortValue() * textureWidth;
            int y = cord.get(1).shortValue() * textureHeight;
//            16
            textures[state][i] = new TextureRegion(
                    texture,
                    x,
                    y,
                    textureWidth,
                    textureHeight
            );
            if (loadPants) {
                int pantsX = cord.get(0).shortValue() * 16;
                int pantsY = cord.get(1).shortValue() * 16;
                pantsTextures[state][i] = new TextureRegion(
                        pantsTxt,
                        pantsX, pantsY, 16, 16
                );
            }
            i++;
            if (i >= MAX_ANIMATION_FRAMES) {
                break;
            }
        }
    }

    private void loadHorizontallyTexturesForAnimationState(TextureRegion[][] textures, int stateLeft, int stateRight, JsonNode animationNode, Texture texture, boolean loadPants) {
        int i = 0;
        for (JsonNode cord : animationNode) {
            int x = cord.get(0).shortValue() * textureWidth;
            int y = cord.get(1).shortValue() * textureHeight;

            // TODO later: fix offset, this fixed value should be in json file
//            if (stateLeft == STATE_RUNNING_LEFT || stateRight == STATE_RUNNING_RIGHT) {
//                if (i == 0 || i == 3) {
//                    y += 1;
//                }
//            }

            TextureRegion textureRight = new TextureRegion(
                    texture,
                    x,
                    y,
                    textureWidth,
                    textureHeight
            );
            // sprites are directed to the right, so create left version of texture
            TextureRegion textureLeft = new TextureRegion(
                    texture,
                    x,
                    y,
                    textureWidth,
                    textureHeight
            );
            textureLeft.flip(true, false);

            // put textures into array
            textures[stateLeft][i] = textureLeft;
            textures[stateRight][i] = textureRight;


            if (loadPants) {
                int pantsX = cord.get(0).shortValue() * 16;
                int pantsY = cord.get(1).shortValue() * 16;
                pantsTextures[stateRight][i] = new TextureRegion(
                        pantsTxt,
                        pantsX, pantsY, 16, 16
                );
                pantsTextures[stateLeft][i] = new TextureRegion(
                        pantsTxt,
                        pantsX, pantsY, 16, 16
                );
                pantsTextures[stateLeft][i].flip(true, false);
            }


            i++;
            if (i >= MAX_ANIMATION_FRAMES) {
                break;
            }
        }
    }
}