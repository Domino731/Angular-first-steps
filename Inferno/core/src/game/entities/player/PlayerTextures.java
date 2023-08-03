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
import utils.vectors.DimensionVector;

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

    public static final DimensionVector<Byte> HAIR_SIZE = new DimensionVector<>((byte) 16, (byte) 32);
    private static final int MAX_ANIMATION_FRAMES = 6;
    public static TextureRegion[] hairsTexture = getHair();

    public TextureRegion[][] bodyTextures;
    public TextureRegion[][] armsTextures;
    private final int textureWidth = 16;
    private final int textureHeight = 32;

    private static TextureRegion[] getHair() {
        Texture texture = new Texture("sprites/style/hairs.png");
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
                r = Math.min(r + 50, 255); // In this example, we're increasing green by 50

                // Recombine the components and update the pixel
                colorInt = (r << 24) | (g << 16) | (b << 8) | a;
                pixmap.drawPixel(x, y, colorInt);
            }
        }

        Texture coloredHair = new Texture(pixmap);
        TextureRegion[] hairs = new TextureRegion[4];
        hairs[STATE_HAIR_UP] = new TextureRegion(coloredHair, 0, HAIR_SIZE.height * 2, HAIR_SIZE.width, HAIR_SIZE.height);
        hairs[STATE_HAIR_RIGHT] = new TextureRegion(coloredHair, 0, HAIR_SIZE.height * 1, HAIR_SIZE.width, HAIR_SIZE.height);
        hairs[STATE_HAIR_DOWN] = new TextureRegion(coloredHair, 0, HAIR_SIZE.height * 0, HAIR_SIZE.width, HAIR_SIZE.height);
        hairs[STATE_HAIR_LEFT] = new TextureRegion(coloredHair, 0, HAIR_SIZE.height * 1, HAIR_SIZE.width, HAIR_SIZE.height);
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

    public PlayerTextures() {
        bodyTextures = new TextureRegion[8][MAX_ANIMATION_FRAMES];
        armsTextures = new TextureRegion[8][MAX_ANIMATION_FRAMES];
        readJson();
    }

    private void readJson() {
        FileHandle fileHandle = Gdx.files.internal("config/playerConfig.json");
        if (fileHandle.exists()) {
            try {
                JsonNode jsonNode = Json.parse(fileHandle.readString()).get("animations");
                Texture texture = SpritesManager.loadSprite("sprites/entities/player_new_1.png");

                loadAnimationTextures(jsonNode.get("body"), bodyTextures, texture);
                loadAnimationTextures(jsonNode.get("arms"), armsTextures, texture);
            } catch (IOException e) {
                EngineLog.resourceError("config/playerConfig.json");
            }
        }
    }

    private void loadAnimationTextures(JsonNode animationNode, TextureRegion[][] textures, Texture texture) {
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
            loadTexturesForAnimationState(textures, STATE_IDLE_UP, idleUp, texture);
        }
        if (idleHorizontally != null && idleHorizontally.isArray()) {
            loadHorizontallyTexturesForAnimationState(textures, STATE_IDLE_LEFT, STATE_IDLE_RIGHT, idleHorizontally, texture);
        }
        if (idleDown != null && idleDown.isArray()) {
            loadTexturesForAnimationState(textures, STATE_IDLE_DOWN, idleDown, texture);
        }
        // RUNNING
        if (runningHorizontally != null && runningHorizontally.isArray()) {
            loadHorizontallyTexturesForAnimationState(textures, STATE_RUNNING_LEFT, STATE_RUNNING_RIGHT, runningHorizontally, texture);
        }
        if (runningDown != null && runningDown.isArray()) {
            loadTexturesForAnimationState(textures, STATE_RUNNING_DOWN, runningDown, texture);
        }
        if (runningUp != null && runningUp.isArray()) {
            loadTexturesForAnimationState(textures, STATE_RUNNING_UP, runningUp, texture);
        }
    }

    private void loadTexturesForAnimationState(TextureRegion[][] textures, int state, JsonNode animationNode, Texture texture) {
        int i = 0;
        for (JsonNode cord : animationNode) {
            int x = cord.get(0).shortValue() * textureWidth;
            int y = cord.get(1).shortValue() * textureHeight;
            textures[state][i] = new TextureRegion(
                    texture,
                    x,
                    y,
                    textureWidth,
                    textureHeight
            );
            i++;
            if (i >= MAX_ANIMATION_FRAMES) {
                break;
            }
        }
    }

    private void loadHorizontallyTexturesForAnimationState(TextureRegion[][] textures, int stateLeft, int stateRight, JsonNode animationNode, Texture texture) {
        int i = 0;
        for (JsonNode cord : animationNode) {
            int x = cord.get(0).shortValue() * textureWidth;
            int y = cord.get(1).shortValue() * textureHeight;

            // TODO later: fix offset, this fixed value should be in json file
            if (stateLeft == STATE_RUNNING_LEFT || stateRight == STATE_RUNNING_RIGHT) {
                if (i == 0 || i == 3) {
                    y += 1;
                }
            }

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

            i++;
            if (i >= MAX_ANIMATION_FRAMES) {
                break;
            }
        }
    }
}