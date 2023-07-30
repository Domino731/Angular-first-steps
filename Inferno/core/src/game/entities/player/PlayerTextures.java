package game.entities.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import spritesManager.SpritesManager;
import utils.EngineLog;
import utils.Json;

import java.io.IOException;


public class PlayerTextures {
    public static final int STATE_RUNNING_HORIZONTALLY = 0;
    public static final int STATE_RUNNING_DOWN = 1;
    public static final int STATE_RUNNING_UP = 2;
    public static final int STATE_IDLE_UP = 3;
    public static final int STATE_IDLE_DOWN = 4;
    public static final int STATE_IDLE_HORIZONTALLY = 5;
    public static final int STATE_RUNNING_RIGHT = 6;
    public static final int STATE_RUNNING_LEFT = 7;

    private static final int MAX_ANIMATION_FRAMES = 6;

    public TextureRegion[][] bodyTextures;
    public TextureRegion[][] armsTextures;
    private final int textureWidth = 16;
    private final int textureHeight = 32;

    public static int actionTextureAmount(int player_action) {
        switch (player_action) {
            // running
            case STATE_RUNNING_LEFT:
            case STATE_RUNNING_RIGHT:
            case STATE_RUNNING_DOWN:
            case STATE_RUNNING_UP:
                return 6;
            // idle
            case STATE_IDLE_DOWN:
            case STATE_IDLE_UP:
                return 1;
            default:
                return 1;
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

        if (idleUp != null && idleUp.isArray()) {
            loadTexturesForAnimationState(textures, STATE_IDLE_UP, idleUp, texture);
        }
        if (idleHorizontally != null && idleHorizontally.isArray()) {
            loadTexturesForAnimationState(textures, STATE_IDLE_HORIZONTALLY, idleHorizontally, texture);
//            loadHorizontallyTexturesForAnimationState(textures, STATE_RUNNING_LEFT, STATE_RUNNING_RIGHT, runningHorizontally, texture);
        }
        if (idleDown != null && idleDown.isArray()) {
            loadTexturesForAnimationState(textures, STATE_IDLE_DOWN, idleDown, texture);
        }

        // handle running textures
        if (runningHorizontally != null && runningHorizontally.isArray()) {
            loadTexturesForAnimationState(textures, STATE_RUNNING_HORIZONTALLY, runningHorizontally, texture);
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