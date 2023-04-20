import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, EngineObject, FOOD_ITEMS} from "../../types";
import {BUSHES_NAMES} from "../types";
import {TOOLS} from "../../tools/types";

const defaultHp: number = 100;
export const bushesDouble: Array<EngineObject> = [
    {
        group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
        type: ENGINE_OBJECTS_TYPES.BUSHES,
        id: BUSHES_NAMES.SUMMER_SM_DB,
        name: BUSHES_NAMES.SUMMER_SM_DB,
        hp: defaultHp,
        sprite: {
            src: 'bushes_double_sm.png',
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
        id: BUSHES_NAMES.AUTUMN_SM_DB,
        name: BUSHES_NAMES.AUTUMN_SM_DB,
        hp: defaultHp,
        sprite: {
            src: 'bushes_double_sm.png',
            position: {
                x: 4,
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
    }, {
        group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
        type: ENGINE_OBJECTS_TYPES.BUSHES,
        id: BUSHES_NAMES.WINTER_SM_DB,
        name: BUSHES_NAMES.WINTER_SM_DB,
        hp: defaultHp,
        sprite: {
            src: 'bushes_double_sm.png',
            position: {
                x: 6,
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
        id: BUSHES_NAMES.SPRING_SM_DB,
        name: BUSHES_NAMES.SPRING_SM_DB,
        hp: defaultHp,
        sprite: {
            src: 'bushes_double_sm.png',
            position: {
                x: 2,
                y: 0,
            }
        },
        tools: [TOOLS.GARDEN_SCISSORS],
        destroyable: true,
        checkboxes: [
            {
                x: 2,
                y: 0,
                width: 40,
                height: 40
            }
        ],
        items: [FOOD_ITEMS.STRAWBERRY]
    },
]