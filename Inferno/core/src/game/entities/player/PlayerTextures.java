package game.entities.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import spritesManager.SpritesManager;
import utils.Direction;
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
    // HARVEST
    public static final byte STATE_MINE_UP = 8;
    public static final byte STATE_MINE_RIGHT = 9;
    public static final byte STATE_MINE_LEFT = 10;
    public static final byte STATE_MINE_DOWN = 11;
    // HARVEST WEED
    public static final byte STATE_HARVEST_UP = 12;
    public static final byte STATE_HARVEST_RIGHT = 13;
    public static final byte STATE_HARVEST_LEFT = 14;
    public static final byte STATE_HARVEST_DOWN = 15;
    // IDLE WITH ITEM
    public static final byte STATE_IDLE_ITEM_UP = 16;
    public static final byte STATE_IDLE_ITEM_RIGHT = 17;
    public static final byte STATE_IDLE_ITEM_DOWN = 18;
    public static final byte STATE_IDLE_ITEM_LEFT = 19;
    // RUNNING WITH ITEM
    public static final byte STATE_RUNNING_ITEM_UP = 20;
    public static final byte STATE_RUNNING_ITEM_RIGHT = 21;
    public static final byte STATE_RUNNING_ITEM_DOWN = 22;
    public static final byte STATE_RUNNING_ITEM_LEFT = 23;

    public static final int MAX_ANIMATION_FRAMES = 6;
    public static final byte ANIMATION_AMOUNT = 24;

    private static final Texture hairTexture = new Texture("sprites/style/hairs.png");
    private static final Texture hatsTexture = new Texture("sprites/style/hats.png");
    private static final Texture shirtsTexture = new Texture("sprites/style/shirts.png");
    private static final Texture pantsTxt = new Texture("sprites/style/pants.png");
    public static final Texture toolsTxt = new Texture("sprites/tools.png");

    // textures
    public TextureRegion[][] bodyTextures;
    public TextureRegion[][] armsTextures;
    public TextureRegion[][] pantsTextures;
    public TextureRegion pickaxe;

    private final int textureWidth = 16;
    private final int textureHeight = 32;
    public static final byte toolWidth = 16;
    public static final byte toolHeight = 32;
    public static final byte toolXOrigin = toolWidth / 2;
    public static final byte toolYOrigin = toolHeight / 2;

    public PlayerTextures() {
        bodyTextures = new TextureRegion[ANIMATION_AMOUNT][MAX_ANIMATION_FRAMES];
        armsTextures = new TextureRegion[ANIMATION_AMOUNT][MAX_ANIMATION_FRAMES];
        pantsTextures = new TextureRegion[ANIMATION_AMOUNT][MAX_ANIMATION_FRAMES];

        readJson();
        loadTools();
    }

    private void loadTools() {
        pickaxe = new TextureRegion(toolsTxt, 2 * toolWidth, 7 * toolWidth, toolWidth, toolHeight);
    }

    public static TextureRegion[] getShirts() {
        TextureRegion[] shirts = new TextureRegion[4];

        byte x = 2;
        byte y = 0;

        byte width = PlayerConstants.shirtDim.width;
        byte height = PlayerConstants.shirtDim.height;

        int xOffset = x * PlayerConstants.shirtDim.width;
        int yOffset = y * PlayerConstants.shirtDim.height;

        shirts[Direction.up] = new TextureRegion(shirtsTexture, xOffset, yOffset + (3 * height), width, height);
        shirts[Direction.right] = new TextureRegion(shirtsTexture, xOffset, yOffset + height, width, height);
        shirts[Direction.left] = new TextureRegion(shirtsTexture, xOffset, yOffset + (2 * height), width, height);
        shirts[Direction.down] = new TextureRegion(shirtsTexture, xOffset, yOffset, width, height);

        return shirts;
    }

    public static TextureRegion[] getHat(HatsNames hatId) {
        PlayerHatsData.Config hatData = PlayerHatsData.getHat(hatId);
        Vector<Byte> hairOffset = hatData.getOffset();
        TextureRegion[] hats = new TextureRegion[4];
        byte size = PlayerHatsData.HAT_SIZE;
        final int xOffset = hairOffset.x * size;
        final int yOffset = hairOffset.y * size;

        hats[Direction.down] = new TextureRegion(hatsTexture, xOffset, yOffset + (size * 0), size, size);
        hats[Direction.right] = new TextureRegion(hatsTexture, xOffset, yOffset + (size * 1), size, size);
        hats[Direction.left] = new TextureRegion(hatsTexture, xOffset, yOffset + (size * 2), size, size);
        hats[Direction.up] = new TextureRegion(hatsTexture, xOffset, yOffset + (size * 3), size, size);
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

        hairs[Direction.up] = new TextureRegion(coloredHair, xOffset, yOffset + (HAIR_SIZE.height * 2), HAIR_SIZE.width, HAIR_SIZE.height);
        hairs[Direction.right] = new TextureRegion(coloredHair, xOffset, yOffset + (HAIR_SIZE.height * 1), HAIR_SIZE.width, HAIR_SIZE.height);
        hairs[Direction.down] = new TextureRegion(coloredHair, xOffset, yOffset + (HAIR_SIZE.height * 0), HAIR_SIZE.width, HAIR_SIZE.height);
        hairs[Direction.left] = new TextureRegion(coloredHair, xOffset, yOffset + (HAIR_SIZE.height * 1), HAIR_SIZE.width, HAIR_SIZE.height);
        hairs[Direction.left].flip(true, false);
        return hairs;
    }

    public static int hairTextureIndexByAction(int playerAction) {
        switch (playerAction) {
            case STATE_IDLE_UP:
            case STATE_RUNNING_UP:
                return Direction.up;
            case STATE_IDLE_RIGHT:
            case STATE_RUNNING_RIGHT:
                return Direction.right;
            case STATE_IDLE_DOWN:
            case STATE_RUNNING_DOWN:
                return Direction.down;
            case STATE_IDLE_LEFT:
            case STATE_RUNNING_LEFT:
                return Direction.left;
            default:
                return 0;
        }
    }

    public static byte hatTextureIndexByAction(int playerAction) {
        switch (playerAction) {
            case STATE_IDLE_UP:
            case STATE_RUNNING_UP:
                return Direction.up;
            case STATE_IDLE_RIGHT:
            case STATE_RUNNING_RIGHT:
                return Direction.right;
            case STATE_IDLE_DOWN:
            case STATE_RUNNING_DOWN:
                return Direction.down;
            case STATE_IDLE_LEFT:
            case STATE_RUNNING_LEFT:
                return Direction.left;
            default:
                return 0;
        }
    }

    public static int actionTextureAmount(int player_action) {
        switch (player_action) {
            case STATE_MINE_LEFT:
            case STATE_MINE_RIGHT:
            case STATE_MINE_UP:
            case STATE_MINE_DOWN:
                return 5;
            // running
            case STATE_RUNNING_LEFT:
            case STATE_RUNNING_RIGHT:
            case STATE_RUNNING_DOWN:
            case STATE_RUNNING_UP:
            case STATE_HARVEST_UP:
            case STATE_HARVEST_RIGHT:
            case STATE_HARVEST_DOWN:
            case STATE_HARVEST_LEFT:
            case STATE_RUNNING_ITEM_UP:
            case STATE_RUNNING_ITEM_RIGHT:
            case STATE_RUNNING_ITEM_DOWN:
            case STATE_RUNNING_ITEM_LEFT:
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

        JsonNode harvestUp = animationNode.get("mineUp");
        JsonNode harvestHorizontally = animationNode.get("mineHorizontally");
        JsonNode mineResourceDown = animationNode.get("mineDown");

        JsonNode collectWeedHorizontally = animationNode.get("harvestHorizontally");
        JsonNode collectWeedUp = animationNode.get("harvestUp");
        JsonNode collectWeedDown = animationNode.get("harvestDown");

        JsonNode idleHoldItemHorizontally = animationNode.get("idleHoldItemHorizontally");
        JsonNode idleHoldItemUp = animationNode.get("idleHoldItemUp");
        JsonNode idleHoldItemDown = animationNode.get("idleHoldItemDown");

        JsonNode runningHoldItemHorizontally = animationNode.get("runningHoldItemHorizontally");
        JsonNode runningHoldItemUp = animationNode.get("runningHoldItemUp");
        JsonNode runningHoldItemDown = animationNode.get("runningHoldItemDown");

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

        // HARVEST
        if (harvestUp != null && harvestUp.isArray()) {
            loadTexturesForAnimationState(textures, STATE_MINE_UP, harvestUp, texture, loadPants);
        }
        if (harvestHorizontally != null && harvestHorizontally.isArray()) {
            loadHorizontallyTexturesForAnimationState(textures, STATE_MINE_LEFT, STATE_MINE_RIGHT, harvestHorizontally, texture, loadPants);
        }
        if (mineResourceDown != null && mineResourceDown.isArray()) {
            loadTexturesForAnimationState(textures, STATE_MINE_DOWN, mineResourceDown, texture, loadPants);
        }

        // HARVEST WEED
        if (collectWeedUp != null && collectWeedUp.isArray()) {
            loadTexturesForAnimationState(textures, STATE_HARVEST_UP, collectWeedUp, texture, loadPants);
        }
        if (harvestHorizontally != null && harvestHorizontally.isArray()) {
            loadHorizontallyTexturesForAnimationState(textures, STATE_HARVEST_LEFT, STATE_HARVEST_RIGHT, collectWeedHorizontally, texture, loadPants);
        }
        if (collectWeedDown != null && collectWeedDown.isArray()) {
            loadTexturesForAnimationState(textures, STATE_HARVEST_DOWN, collectWeedDown, texture, loadPants);
        }

        // IDLE WITH Item
        if (idleHoldItemUp != null && idleHoldItemUp.isArray()) {
            loadTexturesForAnimationState(textures, STATE_IDLE_ITEM_UP, idleHoldItemUp, texture, loadPants);
        }
        if (idleHoldItemHorizontally != null && idleHoldItemHorizontally.isArray()) {
            loadHorizontallyTexturesForAnimationState(textures, STATE_IDLE_ITEM_LEFT, STATE_IDLE_ITEM_RIGHT, idleHoldItemHorizontally, texture, loadPants);
        }
        if (idleHoldItemDown != null && idleHoldItemDown.isArray()) {
            loadTexturesForAnimationState(textures, STATE_IDLE_ITEM_DOWN, idleHoldItemDown, texture, loadPants);
        }

        if (runningHoldItemUp != null && runningHoldItemUp.isArray()) {
            loadTexturesForAnimationState(textures, STATE_RUNNING_ITEM_UP, runningHoldItemUp, texture, loadPants);
        }
        if (runningHoldItemHorizontally != null && runningHoldItemHorizontally.isArray()) {
            loadHorizontallyTexturesForAnimationState(textures, STATE_RUNNING_ITEM_LEFT, STATE_RUNNING_ITEM_RIGHT, runningHoldItemHorizontally, texture, loadPants);
        }
        if (runningHoldItemDown != null && runningHoldItemDown.isArray()) {
            loadTexturesForAnimationState(textures, STATE_RUNNING_ITEM_DOWN, runningHoldItemDown, texture, loadPants);
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