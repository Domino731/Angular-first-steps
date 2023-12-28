package game.player.playerTextures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;
import game.player.PlayerConstants;
import game.player.animations.config.BodyOffsets;
import game.player.animations.config.Offsets;
import game.player.style.data.HatsNames;
import game.player.style.data.PlayerHairsData;
import game.player.style.data.PlayerHatsData;
import spritesManager.SpritesManager;
import utils.Direction;
import utils.EngineLog;
import utils.Json;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.io.IOException;

import static constants.Urls.*;


public class PlayerTextures {
    private static final Texture hairTexture = new Texture(SPRITE_HAIRS);
    private static final Texture hatsTexture = new Texture(SPRITE_HATS);
    private static final Texture shirtsTexture = new Texture(SPRITE_SHIRTS);
    private static final Texture pantsTxt = new Texture(SPRITE_PANTS);
    public static final Texture toolsTxt = new Texture(SPRITE_TOOLS);

    // textures
    public TextureRegion[][] bodyTextures;
    public TextureRegion[][] armsTextures;
    public TextureRegion[][] pantsTextures;
    public TextureRegion pickaxe;

    // offsets
    public short[][] hairOffsets;
    public short[][] hatsYOffsets;
    public byte[][] hatsXOffsets;
    public short[][] shirtOffsets;

    public static byte hatSize = 20;
    private final int textureWidth = 16;
    private final int textureHeight = 32;
    public static final byte toolWidth = 16;
    public static final byte toolHeight = 32;
    public static final byte toolXOrigin = toolWidth / 2;
    public static final byte toolYOrigin = toolHeight / 2;

    public PlayerTextures() {
        bodyTextures = new TextureRegion[PlayerConstants.ANI_AMOUNT][PlayerConstants.ANI_MAX_FRAMES];
        armsTextures = new TextureRegion[PlayerConstants.ANI_AMOUNT][PlayerConstants.ANI_MAX_FRAMES];
        pantsTextures = new TextureRegion[PlayerConstants.ANI_AMOUNT][PlayerConstants.ANI_MAX_FRAMES];
        hairOffsets = new short[PlayerConstants.ANI_AMOUNT][PlayerConstants.ANI_MAX_FRAMES];
        hatsYOffsets = new short[PlayerConstants.ANI_AMOUNT][PlayerConstants.ANI_MAX_FRAMES];
        hatsXOffsets = new byte[PlayerConstants.ANI_AMOUNT][PlayerConstants.ANI_MAX_FRAMES];
        shirtOffsets = new short[PlayerConstants.ANI_AMOUNT][PlayerConstants.ANI_MAX_FRAMES];

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

        hats[Direction.down] = new TextureRegion(hatsTexture, xOffset, yOffset, size, size);
        hats[Direction.right] = new TextureRegion(hatsTexture, xOffset, yOffset + size, size, size);
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
        hairs[Direction.right] = new TextureRegion(coloredHair, xOffset, yOffset + HAIR_SIZE.height, HAIR_SIZE.width, HAIR_SIZE.height);
        hairs[Direction.down] = new TextureRegion(coloredHair, xOffset, yOffset, HAIR_SIZE.width, HAIR_SIZE.height);
        hairs[Direction.left] = new TextureRegion(coloredHair, xOffset, yOffset + HAIR_SIZE.height, HAIR_SIZE.width, HAIR_SIZE.height);
        hairs[Direction.left].flip(true, false);
        return hairs;
    }

    public static int idleActionByLastAction(int playerAction) {
        switch (playerAction) {
            case PlayerConstants.ANI_IDLE_UP:
            case PlayerConstants.ANI_IDLE_RIGHT:
            case PlayerConstants.ANI_IDLE_DOWN:
            case PlayerConstants.ANI_IDLE_LEFT:
                return playerAction;
            case PlayerConstants.ANI_RUNNING_UP:
                return PlayerConstants.ANI_IDLE_UP;
            case PlayerConstants.ANI_RUNNING_RIGHT:
                return PlayerConstants.ANI_IDLE_RIGHT;
            case PlayerConstants.ANI_RUNNING_DOWN:
                return PlayerConstants.ANI_IDLE_DOWN;
            case PlayerConstants.ANI_RUNNING_LEFT:
                return PlayerConstants.ANI_IDLE_LEFT;
            default:
                return PlayerConstants.ANI_IDLE_DOWN;
        }
    }


    public static int idleActionByLastActionForItem(int playerAction) {
        switch (playerAction) {
            case PlayerConstants.ANI_RUNNING_UP:
            case PlayerConstants.ANI_RUNNING_ITEM_UP:
            case PlayerConstants.ANI_IDLE_UP:
            case PlayerConstants.ANI_IDLE_ITEM_UP:
                return PlayerConstants.ANI_IDLE_ITEM_UP;
            case PlayerConstants.ANI_RUNNING_RIGHT:
            case PlayerConstants.ANI_RUNNING_ITEM_RIGHT:
            case PlayerConstants.ANI_IDLE_RIGHT:
            case PlayerConstants.ANI_IDLE_ITEM_RIGHT:
                return PlayerConstants.ANI_IDLE_ITEM_RIGHT;
            case PlayerConstants.ANI_RUNNING_DOWN:
            case PlayerConstants.ANI_RUNNING_ITEM_DOWN:
            case PlayerConstants.ANI_IDLE_DOWN:
            case PlayerConstants.ANI_IDLE_ITEM_DOWN:
                return PlayerConstants.ANI_IDLE_ITEM_DOWN;
            case PlayerConstants.ANI_RUNNING_LEFT:
            case PlayerConstants.ANI_RUNNING_ITEM_LEFT:
            case PlayerConstants.ANI_IDLE_LEFT:
            case PlayerConstants.ANI_IDLE_ITEM_LEFT:
                return PlayerConstants.ANI_IDLE_ITEM_LEFT;
            default:
                EngineLog.error("No match for player action in idleActionByLastActionForItem(), default value returned (STATE_IDLE_ITEM_DOWN)");
                return PlayerConstants.ANI_IDLE_ITEM_DOWN;
        }
    }

    private void readJson() {
        FileHandle fileHandle = Gdx.files.internal(Urls.PLAYER_CONFIG);
        if (fileHandle.exists()) {
            try {
                JsonNode jsonNode = Json.parse(fileHandle.readString()).get("animations");
                Texture texture = SpritesManager.loadSprite(SPRITE_PLAYER);

                loadAnimationTextures(jsonNode.get("body"), bodyTextures, texture, true);
                loadAnimationTextures(jsonNode.get("arms"), armsTextures, texture, false);
            } catch (IOException e) {
                EngineLog.resourceError(Urls.PLAYER_CONFIG);
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
            loadTexturesForAnimationState(textures, PlayerConstants.ANI_IDLE_UP, idleUp, texture, loadPants);
        }
        if (idleHorizontally != null && idleHorizontally.isArray()) {
            loadHorizontallyTexturesForAnimationState(textures, PlayerConstants.ANI_IDLE_LEFT, PlayerConstants.ANI_IDLE_RIGHT, idleHorizontally, texture, loadPants);
        }
        if (idleDown != null && idleDown.isArray()) {
            loadTexturesForAnimationState(textures, PlayerConstants.ANI_IDLE_DOWN, idleDown, texture, loadPants);
        }

        // RUNNING
        if (runningHorizontally != null && runningHorizontally.isArray()) {
            loadHorizontallyTexturesForAnimationState(textures, PlayerConstants.ANI_RUNNING_LEFT, PlayerConstants.ANI_RUNNING_RIGHT, runningHorizontally, texture, loadPants);
        }
        if (runningDown != null && runningDown.isArray()) {
            loadTexturesForAnimationState(textures, PlayerConstants.ANI_RUNNING_DOWN, runningDown, texture, loadPants);
        }
        if (runningUp != null && runningUp.isArray()) {
            loadTexturesForAnimationState(textures, PlayerConstants.ANI_RUNNING_UP, runningUp, texture, loadPants);
        }

        // MINE
        if (harvestUp != null && harvestUp.isArray()) {
            loadTexturesForAnimationState(textures, PlayerConstants.ANI_MINE_UP, harvestUp, texture, loadPants);
        }
        if (harvestHorizontally != null && harvestHorizontally.isArray()) {
            loadHorizontallyTexturesForAnimationState(textures, PlayerConstants.ANI_MINE_LEFT, PlayerConstants.ANI_MINE_RIGHT, harvestHorizontally, texture, loadPants);
        }
        if (mineResourceDown != null && mineResourceDown.isArray()) {
            loadTexturesForAnimationState(textures, PlayerConstants.ANI_MINE_DOWN, mineResourceDown, texture, loadPants);
        }

        // HARVEST WEED
        if (collectWeedUp != null && collectWeedUp.isArray()) {
            loadTexturesForAnimationState(textures, PlayerConstants.ANI_HARVEST_UP, collectWeedUp, texture, loadPants);
        }
        if (harvestHorizontally != null && harvestHorizontally.isArray()) {
            loadHorizontallyTexturesForAnimationState(textures, PlayerConstants.ANI_HARVEST_LEFT, PlayerConstants.ANI_HARVEST_RIGHT, collectWeedHorizontally, texture, loadPants);
        }
        if (collectWeedDown != null && collectWeedDown.isArray()) {
            loadTexturesForAnimationState(textures, PlayerConstants.ANI_HARVEST_DOWN, collectWeedDown, texture, loadPants);
        }

        // IDLE WITH Item
        if (idleHoldItemUp != null && idleHoldItemUp.isArray()) {
            loadTexturesForAnimationState(textures, PlayerConstants.ANI_IDLE_ITEM_UP, idleHoldItemUp, texture, loadPants);
        }
        if (idleHoldItemHorizontally != null && idleHoldItemHorizontally.isArray()) {
            loadHorizontallyTexturesForAnimationState(textures, PlayerConstants.ANI_IDLE_ITEM_LEFT, PlayerConstants.ANI_IDLE_ITEM_RIGHT, idleHoldItemHorizontally, texture, loadPants);
        }
        if (idleHoldItemDown != null && idleHoldItemDown.isArray()) {
            loadTexturesForAnimationState(textures, PlayerConstants.ANI_IDLE_ITEM_DOWN, idleHoldItemDown, texture, loadPants);
        }

        if (runningHoldItemUp != null && runningHoldItemUp.isArray()) {
            loadTexturesForAnimationState(textures, PlayerConstants.ANI_RUNNING_ITEM_UP, runningHoldItemUp, texture, loadPants);
        }
        if (runningHoldItemHorizontally != null && runningHoldItemHorizontally.isArray()) {
            loadHorizontallyTexturesForAnimationState(textures, PlayerConstants.ANI_RUNNING_ITEM_LEFT, PlayerConstants.ANI_RUNNING_ITEM_RIGHT, runningHoldItemHorizontally, texture, loadPants);
        }
        if (runningHoldItemDown != null && runningHoldItemDown.isArray()) {
            loadTexturesForAnimationState(textures, PlayerConstants.ANI_RUNNING_ITEM_DOWN, runningHoldItemDown, texture, loadPants);
        }
    }

    private void loadTexturesForAnimationState(TextureRegion[][] textures, int state, JsonNode animationNode, Texture texture, boolean loadPants) {
        int i = 0;
        for (JsonNode cord : animationNode) {
            int cordX = cord.get(0).shortValue();
            int cordY = cord.get(1).shortValue();
            int x = cordX * textureWidth;
            int y = cordY * textureHeight;

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
                hairOffsets[state][i] = (short) (PlayerHairsData.HAIR_SIZE.width - BodyOffsets.bodyYOffsets[cordY][cordX]);
                hatsYOffsets[state][i] = (short) (hatSize - BodyOffsets.bodyYOffsets[cordY][cordX]);
                hatsXOffsets[state][i] = BodyOffsets.bodyXOffsets[cordY][cordX];
                shirtOffsets[state][i] = (short) (32 - Offsets.shirts[cordY][cordX] - 8);
            }
            i++;
            if (i >= PlayerConstants.ANI_MAX_FRAMES) {
                break;
            }
        }
    }

    private void loadHorizontallyTexturesForAnimationState(TextureRegion[][] textures, int stateLeft, int stateRight, JsonNode animationNode, Texture texture, boolean loadPants) {
        int i = 0;
        for (JsonNode cord : animationNode) {
            int cordX = cord.get(0).shortValue();
            int cordY = cord.get(1).shortValue();
            int x = cordX * textureWidth;
            int y = cordY * textureHeight;

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

                hairOffsets[stateLeft][i] = (short) (PlayerHairsData.HAIR_SIZE.width - BodyOffsets.bodyYOffsets[cordY][cordX]);
                hairOffsets[stateRight][i] = (short) (PlayerHairsData.HAIR_SIZE.width - BodyOffsets.bodyYOffsets[cordY][cordX]);
                hatsYOffsets[stateLeft][i] = (short) (hatSize - BodyOffsets.bodyYOffsets[cordY][cordX]);
                hatsYOffsets[stateRight][i] = (short) (hatSize - BodyOffsets.bodyYOffsets[cordY][cordX]);
                hatsXOffsets[stateRight][i] = BodyOffsets.bodyXOffsets[cordY][cordX];
                hatsXOffsets[stateLeft][i] = BodyOffsets.bodyXOffsets[cordY][cordX];
                shirtOffsets[stateLeft][i] = (short) (32 - Offsets.shirts[cordY][cordX] - 8);
                shirtOffsets[stateRight][i] = (short) (32 - Offsets.shirts[cordY][cordX] - 8);
            }

            i++;
            if (i >= PlayerConstants.ANI_MAX_FRAMES) {
                break;
            }
        }
    }
}