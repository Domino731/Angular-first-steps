import {CropObject} from "../types";
import {CROPS_NAMES} from "../const";
import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../../types";
import {cropStagesFactory} from "../utils";
import {CROPS_DESCRIPTIONS} from "../../descriptions/crops";

export const SummerSpangle: CropObject = {
    id: CROPS_NAMES.SUMMER_SPANGLE,
    name: CROPS_NAMES.SUMMER_SPANGLE,
    hp: 100,
    sprite: {
        src: SPRITE_SRC.CROPS,
        position: {x: 31, y: 3}
    },
    stages: cropStagesFactory(3, 3, 5, CROPS_NAMES.SUMMER_SPANGLE),
    tools: [],
    destroyable: true,
    checkboxes: [],
    items: [],
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.CROPS,
    description: CROPS_DESCRIPTIONS[CROPS_NAMES.SUMMER_SPANGLE]
}