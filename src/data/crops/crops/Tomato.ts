import {CropObject} from "../types";
import {CROPS_NAMES} from "../const";
import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../../types";
import {cropStagesFactory} from "../utils";
import {CROPS_DESCRIPTIONS} from "../../descriptions/crops";

export const Tomato: CropObject = {
    id: CROPS_NAMES.TOMATO,
    name: CROPS_NAMES.TOMATO,
    hp: 100,
    sprite: {
        src: SPRITE_SRC.CROPS,
        position: {x: 38, y: 5}
    },
    stages: cropStagesFactory(3, 5, 6, CROPS_NAMES.TOMATO),
    tools: [],
    destroyable: true,
    checkboxes: [],
    items: [],
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.CROPS,
    description: CROPS_DESCRIPTIONS[CROPS_NAMES.TOMATO]
}