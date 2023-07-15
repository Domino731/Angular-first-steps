package objects.tree;


import engine.utils.vectors.Vector2i;

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

    private static class Config{
        public String name;
        public String spriteSrc;
        public Vector2i position;
        public Short hp;
    }


}
