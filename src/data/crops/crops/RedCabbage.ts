import {CropObject} from "../types";
import {CROPS_NAMES} from "../const";
import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../../types";
import {cropStagesFactory} from "../utils";
import {CROPS_DESCRIPTIONS} from "../../descriptions/crops";

export const RedCabbage: CropObject = {
    id: CROPS_NAMES.RED_CABBAGE,
    name: CROPS_NAMES.RED_CABBAGE,
    hp: 100,
    sprite: {
        src: SPRITE_SRC.CROPS,
        position: {x: 38, y: 1}
    },
    stages: cropStagesFactory(3, 1, 6, CROPS_NAMES.RED_CABBAGE),
    tools: [],
    destroyable: true,
    checkboxes: [],
    items: [],
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.CROPS,
    description: CROPS_DESCRIPTIONS[CROPS_NAMES.RED_CABBAGE]
}