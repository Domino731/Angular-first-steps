import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, EngineObject, SPRITE_SRC} from "../types";
import {TOOLS} from "../tools/types";
import {RESOURCES_16_NAMES} from "./const";

const defaultHp = 2000;

export const resources16: Array<EngineObject> = [
    {
        id: RESOURCES_16_NAMES.STONE,
        name: RESOURCES_16_NAMES.STONE,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.WOOD,
        name: RESOURCES_16_NAMES.WOOD,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.HARDWOOD,
        name: RESOURCES_16_NAMES.HARDWOOD,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.SAP,
        name: RESOURCES_16_NAMES.SAP,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.MIXED_SEEDS,
        name: RESOURCES_16_NAMES.MIXED_SEEDS,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.COAL,
        name: RESOURCES_16_NAMES.COAL,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.COPPER_ORE,
        name: RESOURCES_16_NAMES.COPPER_ORE,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.IRON_ORE,
        name: RESOURCES_16_NAMES.IRON_ORE,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
            position: {
                x: 7,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.GOLD_ORE,
        name: RESOURCES_16_NAMES.GOLD_ORE,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
            position: {
                x: 8,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.IRIDIUM,
        name: RESOURCES_16_NAMES.IRIDIUM,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
            position: {
                x: 9,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.CAVE_CARROT,
        name: RESOURCES_16_NAMES.CAVE_CARROT,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
            position: {
                x: 10,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.GEODE,
        name: RESOURCES_16_NAMES.GEODE,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
            position: {
                x: 11,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.FROZEN_GEODE,
        name: RESOURCES_16_NAMES.FROZEN_GEODE,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
            position: {
                x: 12,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.MAGMA_GEODE,
        name: RESOURCES_16_NAMES.MAGMA_GEODE,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
            position: {
                x: 13,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.OMNI_GEODE,
        name: RESOURCES_16_NAMES.OMNI_GEODE,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
            position: {
                x: 14,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.AMETHYST,
        name: RESOURCES_16_NAMES.AMETHYST,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
            position: {
                x: 15,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.TOPAZ,
        name: RESOURCES_16_NAMES.TOPAZ,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
            position: {
                x: 16,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.AQUAMARINE,
        name: RESOURCES_16_NAMES.AQUAMARINE,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
            position: {
                x: 17,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.JADE,
        name: RESOURCES_16_NAMES.JADE,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
            position: {
                x: 18,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.EMERALD,
        name: RESOURCES_16_NAMES.EMERALD,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
            position: {
                x: 19,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.RUBY,
        name: RESOURCES_16_NAMES.RUBY,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
            position: {
                x: 20,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.BONE_FRAGMENT,
        name: RESOURCES_16_NAMES.BONE_FRAGMENT,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
            position: {
                x: 21,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.QUARTZ,
        name: RESOURCES_16_NAMES.QUARTZ,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
            position: {
                x: 22,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.FROZEN_TEAR,
        name: RESOURCES_16_NAMES.FROZEN_TEAR,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
            position: {
                x: 23,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.FIRE_QUARTZ,
        name: RESOURCES_16_NAMES.FIRE_QUARTZ,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
            position: {
                x: 24,
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
        items: []
    },
    {
        id: RESOURCES_16_NAMES.STONE,
        name: RESOURCES_16_NAMES.STONE,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.RESOURCES_16,
            position: {
                x: 0,
                y: 1,
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
        items: []
    },
].map(el => ({...el, group: ENGINE_OBJECT_GROUPS.ENVIRONMENT, type: ENGINE_OBJECTS_TYPES.RESOURCES_16}))