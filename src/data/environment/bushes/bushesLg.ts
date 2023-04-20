import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, EngineObject, FOOD_ITEMS} from "../../types";
import {BUSHES_NAMES} from "../types";
import {TOOLS} from "../../tools/types";

const defaultHp: number = 400;
export const bushesLg: Array<EngineObject> = [
    {
        group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
        type: ENGINE_OBJECTS_TYPES.BUSHES,
        id: BUSHES_NAMES.SUMMER_LG,
        name: BUSHES_NAMES.SUMMER_LG,
        hp: defaultHp,
        sprite: {
            src: 'bushes_lg.png',
            position: {
                x: 0,
                y: 0,
            }
        },
        tools: [TOOLS.GARDEN_SCISSORS],
        destroyable: true,
        checkboxes: [
            {
                x: 0,
                y: 0,
                width: 40,
                height: 40
            }
        ],
        items: [FOOD_ITEMS.STRAWBERRY]
    },
    {
        group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
        type: ENGINE_OBJECTS_TYPES.BUSHES,
        id: BUSHES_NAMES.WINTER_LG,
        name: BUSHES_NAMES.WINTER_LG,
        hp: defaultHp,
        sprite: {
            src: 'bushes_lg.png',
            position: {
                x: 0,
                y: 1,
            }
        },
        tools: [TOOLS.GARDEN_SCISSORS],
        destroyable: true,
        checkboxes: [
            {
                x: 0,
                y: 0,
                width: 40,
                height: 40
            }
        ],
        items: [FOOD_ITEMS.STRAWBERRY]
    },
    {
        group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
        type: ENGINE_OBJECTS_TYPES.BUSHES,
        id: BUSHES_NAMES.AUTUMN_LG,
        name: BUSHES_NAMES.AUTUMN_LG,
        hp: defaultHp,
        sprite: {
            src: 'bushes_lg.png',
            position: {
                x: 1,
                y: 0,
            }
        },
        tools: [TOOLS.GARDEN_SCISSORS],
        destroyable: true,
        checkboxes: [
            {
                x: 0,
                y: 0,
                width: 40,
                height: 40
            }
        ],
        items: [FOOD_ITEMS.STRAWBERRY]
    },
    {
        group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
        type: ENGINE_OBJECTS_TYPES.BUSHES,
        id: BUSHES_NAMES.SPRING_LG,
        name: BUSHES_NAMES.SPRING_LG,
        hp: defaultHp,
        sprite: {
            src: 'bushes_lg.png',
            position: {
                x: 1,
                y: 1,
            }
        },
        tools: [TOOLS.GARDEN_SCISSORS],
        destroyable: true,
        checkboxes: [
            {
                x: 0,
                y: 0,
                width: 40,
                height: 40
            }
        ],
        items: [FOOD_ITEMS.STRAWBERRY]
    },
];