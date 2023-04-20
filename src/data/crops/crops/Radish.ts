import {CropObject} from "../types";
import {CROPS_NAMES} from "../const";
import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../../types";
import {cropStagesFactory} from "../utils";
import {CROPS_DESCRIPTIONS} from "../../descriptions/crops";

export const Radish: CropObject = {
    id: CROPS_NAMES.RADISH,
    name: CROPS_NAMES.RADISH,
    hp: 100,
    sprite: {
        src: SPRITE_SRC.CROPS,
        position: {x: 31, y: 0}
    },
    stages: cropStagesFactory(3, 0, 5, CROPS_NAMES.RADISH),
    tools: [],
    destroyable: true,
    checkboxes: [],
    items: [],
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.CROPS,
    description: CROPS_DESCRIPTIONS[CROPS_NAMES.RADISH]
}