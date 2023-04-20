import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, EngineObject, SPRITE_SRC} from "../types";
import {TREE_ITEMS, TREE_NAMES} from "../environment/types";
import {TOOLS} from "../tools/types";
import {RESOURCES_32_NAMES} from "./const";

const defaultHp = 2000;

export const resources32: Array<EngineObject> = [
    {
        id: RESOURCES_32_NAMES.TRUNK,
        name: RESOURCES_32_NAMES.TRUNK,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_32,
            position: {
                x: 0,
                y: 0,
            }
        },
        tools: [TOOLS.PICKAXE],
        destroyable: true,
        checkboxes: [
            {
                x: 0,
                y: 0,
                width: 40,
                height: 40
            }
        ],
        items: [TREE_ITEMS.WOOD]
    },
    {
        id: RESOURCES_32_NAMES.LOG,
        name: RESOURCES_32_NAMES.LOG,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_32,
            position: {
                x: 1,
                y: 0,
            }
        },
        tools: [TOOLS.PICKAXE],
        destroyable: true,
        checkboxes: [
            {
                x: 0,
                y: 0,
                width: 40,
                height: 40
            }
        ],
        items: [TREE_ITEMS.WOOD]
    },
    {
        id: RESOURCES_32_NAMES.RED_STONE,
        name: RESOURCES_32_NAMES.RED_STONE,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_32,
            position: {
                x: 2,
                y: 0,
            }
        },
        tools: [TOOLS.PICKAXE],
        destroyable: true,
        checkboxes: [
            {
                x: 0,
                y: 0,
                width: 40,
                height: 40
            }
        ],
        items: [TREE_ITEMS.WOOD]
    },
    {
        id: RESOURCES_32_NAMES.COAL,
        name: RESOURCES_32_NAMES.COAL,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_32,
            position: {
                x: 3,
                y: 0,
            }
        },
        tools: [TOOLS.PICKAXE],
        destroyable: true,
        checkboxes: [
            {
                x: 0,
                y: 0,
                width: 40,
                height: 40
            }
        ],
        items: [TREE_ITEMS.WOOD]
    },
    {
        id: RESOURCES_32_NAMES.BLUE_SLIME,
        name: RESOURCES_32_NAMES.BLUE_SLIME,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_32,
            position: {
                x: 4,
                y: 0,
            }
        },
        tools: [TOOLS.PICKAXE],
        destroyable: true,
        checkboxes: [
            {
                x: 0,
                y: 0,
                width: 40,
                height: 40
            }
        ],
        items: [TREE_ITEMS.WOOD]
    },
    {
        id: RESOURCES_32_NAMES.BLUE_GEM,
        name: RESOURCES_32_NAMES.BLUE_GEM,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_32,
            position: {
                x: 5,
                y: 0,
            }
        },
        tools: [TOOLS.PICKAXE],
        destroyable: true,
        checkboxes: [
            {
                x: 0,
                y: 0,
                width: 40,
                height: 40
            }
        ],
        items: [TREE_ITEMS.WOOD]
    },
    {
        id: RESOURCES_32_NAMES.ANDRONITE,
        name: RESOURCES_32_NAMES.ANDRONITE,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_32,
            position: {
                x: 6,
                y: 0,
            }
        },
        tools: [TOOLS.PICKAXE],
        destroyable: true,
        checkboxes: [
            {
                x: 0,
                y: 0,
                width: 40,
                height: 40
            }
        ],
        items: [TREE_ITEMS.WOOD]
    },
].map(el => ({...el, group: ENGINE_OBJECT_GROUPS.ENVIRONMENT, type: ENGINE_OBJECTS_TYPES.RESOURCES_32}))