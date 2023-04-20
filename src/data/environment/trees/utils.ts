import {TREE_NAMES} from "./const";
import {TREE_ITEMS, TreeObject, TreeStageObject} from "../types";
import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../../types";
import {TOOLS} from "../../tools/types";
import {TREES_DESCRIPTIONS} from "../../descriptions/trees";

const TREE_STAGES: number = 4;

export const treeFactory = (treeName: keyof typeof TREE_NAMES): TreeObject => {
    let xOffset: number = 0;

    switch (treeName) {
        case TREE_NAMES.MAPLE:
            xOffset = 0;
            break;
        case TREE_NAMES.OAK:
            xOffset = 1;
            break;
        case TREE_NAMES.PINE:
            xOffset = 2;
            break;
        case TREE_NAMES.MAHOGANY:
            xOffset = 3;
            break;
        default:
            break;
    }


    const Tree: TreeObject = {
        group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
        type: ENGINE_OBJECTS_TYPES.TREES,
        id: treeName,
        name: treeName,
        hp: 800,
        sprite: {
            // @ts-ignore
            src: SPRITE_SRC[`${treeName.toUpperCase()}_STAGE_5` as keyof SPRITE_SRC],
            position: {
                x: 0,
                y: 0,
            }
        },
        tools: [TOOLS.AXE],
        destroyable: true,
        checkboxes: [],
        items: [TREE_ITEMS.WOOD],
        stages: [],
        description: TREES_DESCRIPTIONS[treeName]
    }

    for (let i = 1; i <= TREE_STAGES; i++) {
        const stageObject: TreeStageObject = {
            group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
            type: ENGINE_OBJECTS_TYPES.TREES,
            id: `${treeName} stage ${i}`,
            name: `${treeName} stage ${i}`,
            hp: 800,
            sprite: {
                // @ts-ignore
                src: SPRITE_SRC[`TREE_STAGE_${i}`],
                position: {
                    x: xOffset,
                    y: 0,
                }
            },
            tools: [TOOLS.AXE],
            destroyable: true,
            checkboxes: [],
            items: [TREE_ITEMS.WOOD],
            stage: i,
            description: TREES_DESCRIPTIONS[treeName]
        }

        Tree.stages.push(stageObject)
    }

    Tree.stages.push({
        group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
        type: ENGINE_OBJECTS_TYPES.TREES,
        id: treeName,
        name: treeName,
        hp: 800,
        sprite: {
            // @ts-ignore
            src: SPRITE_SRC[`${treeName.toUpperCase()}_STAGE_5` as keyof SPRITE_SRC],
            position: {
                x: 0,
                y: 0,
            }
        },
        tools: [TOOLS.AXE],
        destroyable: true,
        checkboxes: [],
        items: [TREE_ITEMS.WOOD],
        stage: 5,
        description: TREES_DESCRIPTIONS[treeName]
    })
    return Tree;
}

export const treeStaticFactory = (treeName: keyof typeof TREE_NAMES) => {
    const Tree: TreeObject = {
        group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
        type: ENGINE_OBJECTS_TYPES.TREES,
        id: treeName,
        name: treeName,
        hp: 800,
        sprite: {
            // @ts-ignore
            src: SPRITE_SRC[`${treeName.toUpperCase()}_STAGE_5` as keyof SPRITE_SRC],
            position: {
                x: 0,
                y: 0,
            }
        },
        tools: [TOOLS.AXE],
        destroyable: true,
        checkboxes: [],
        items: [TREE_ITEMS.WOOD],
        stages: []
    }
}