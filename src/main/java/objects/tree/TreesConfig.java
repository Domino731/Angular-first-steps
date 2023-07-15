package objects.tree;


import com.fasterxml.jackson.databind.JsonNode;
import engine.spritesLoader.SpritesConfig;
import engine.utils.EngineLog;
import engine.utils.vectors.Vector2i;
import engine.utils.vectors.Vector2s;
import utils.json.Json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

// group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
//        type: ENGINE_OBJECTS_TYPES.TREES,
//        id: treeName,
//        name: treeName,
//        hp: 800,
//        sprite: {
//            // @ts-ignore
//            src: SPRITE_SRC[`${treeName.toUpperCase()}_STAGE_5` as keyof SPRITE_SRC],
//            position: {
//                x: 0,
//                y: 0,
//            }
//        },
//        tools: [TOOLS.AXE],
//        destroyable: true,
//        checkboxes: [],
//        items: [TREE_ITEMS.WOOD],
//        stages: [],
//        description: TREES_DESCRIPTIONS[treeName]
public class TreesConfig {
   public static HashMap<String , Config> trees = setData();

    private static class Config{
        public String id;
        public String name;
        public String spriteSrc;
        public Vector2s position;
        public Short hp;
        public List<String> tools = new ArrayList<String>();
        public String description;

        // TODO trees: add tools and checkboxes
        public Config(String id, String name, String spriteSrc, Vector2s position, Short hp, String description){
            this.id = id;
            this.name = name;
            this.spriteSrc = spriteSrc;
            this.position = SpritesConfig.calculateObjectPosition(spriteSrc, position);
            this.hp = hp;
            this.description = description;
        }

    }

    private static HashMap<String , Config> setData() {
        HashMap<String , Config> trees = new HashMap<String , Config>();
        try {
            JsonNode treesData = Json.parse(SpritesConfig.class.getResourceAsStream("/config/trees.json"));
            if(treesData.isArray()){
                for(JsonNode tree : treesData){
                    Vector2s position = new Vector2s(
                            (short) (tree.get("sprite").get("position").get("x").shortValue()),
                            (short) (tree.get("sprite").get("position").get("y").shortValue())
                    );

                    trees.put(tree.get("id").asText(), new Config(
                            tree.get("id").asText(),
                            tree.get("name").asText(),
                            tree.get("sprite").get("src").asText(),
                            position,
                            tree.get("hp").shortValue(),
                            tree.get("description").asText()
                    ));
                }
            }
        }
        catch (IOException e) {
            EngineLog.resourceError("/config/sprites.json");
        }
        return trees;
    }


}
