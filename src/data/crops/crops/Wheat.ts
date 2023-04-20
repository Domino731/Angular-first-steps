import {CropObject} from "../types";
import {CROPS_NAMES} from "../const";
import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../../types";
import {cropStagesFactory} from "../utils";
import {CROPS_DESCRIPTIONS} from "../../descriptions/crops";

export const Wheat: CropObject = {
    id: CROPS_NAMES.WHEAT,
    name: CROPS_NAMES.WHEAT,
    hp: 100,
    sprite: {
        src: SPRITE_SRC.CROPS,
        position: {x: 32, y: 0}
    },
    stages: cropStagesFactory(4, 0, 5, CROPS_NAMES.WHEAT),
    tools: [],
    destroyable: true,
    checkboxes: [],
    items: [],
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.CROPS,
    description: CROPS_DESCRIPTIONS[CROPS_NAMES.WHEAT]
}