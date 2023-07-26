package environment.trees;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import sprites.SpritesConfig;
import spritesManager.SpritesManager;
import utils.EngineLog;
import utils.Json;
import utils.vectors.DimensionCordVector;
import utils.vectors.Vector2s;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class TreesConfig {
    private static HashMap<String, TreeConfig> trees = setData();

    public static class TreeConfig {
        public String id;
        public String name;
        public String spriteSrc;
        public Vector2s position;
        public Short hp;
        public String description;
        public TextureRegion[] textures;
        // TODO: add info from json file
        public ArrayList<DimensionCordVector> checkboxesCords = new ArrayList<>();

        public TreeConfig(String id, String name, String spriteSrc, Vector2s position, Short hp, String description, Texture texture) {
            this.id = id;
            this.name = name;
            this.spriteSrc = spriteSrc;
            this.position = SpritesConfig.calculateObjectPosition(spriteSrc, position);
            this.hp = hp;
            this.description = description;
            this.textures = TreeConstants.createTreeTextureRegions(texture);
            checkboxesCords.add(new DimensionCordVector((short) 20, (short) 20, 0, 0));
        }

    }


    private static HashMap<String, TreeConfig> setData() {
        HashMap<String, TreeConfig> trees = new HashMap<>();
        try {
            FileHandle fileHandle = Gdx.files.internal("config/trees.json");
            if (fileHandle.exists()) {
                JsonNode treesData = Json.parse(fileHandle.readString());
                if (treesData.isArray()) {
                    for (JsonNode tree : treesData) {
                        Vector2s position = new Vector2s(
                                tree.get("sprite").get("position").get("x").shortValue(),
                                tree.get("sprite").get("position").get("y").shortValue()
                        );
                        String textureSrc = "sprites/" + tree.get("sprite").get("src").asText();
                        Texture texture = SpritesManager.loadSprite(textureSrc);

                        trees.put(tree.get("id").asText(), new TreeConfig(
                                tree.get("id").asText(),
                                tree.get("name").asText(),
                                textureSrc,
                                position,
                                tree.get("hp").shortValue(),
                                tree.get("description").asText(),
                                texture
                        ));
                    }
                }
            }
        } catch (IOException e) {
            EngineLog.resourceError("/config/sprites.json");
        }
        return trees;
    }

    public static TreeConfig get(String treeName) {
        return trees.get(treeName);
    }
}