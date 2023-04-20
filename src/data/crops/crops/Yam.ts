import {CropObject} from "../types";
import {CROPS_NAMES} from "../const";
import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../../types";
import {cropStagesFactory} from "../utils";
import {CROPS_DESCRIPTIONS} from "../../descriptions/crops";

export const Yam: CropObject = {
    id: CROPS_NAMES.YAM,
    name: CROPS_NAMES.YAM,
    hp: 100,
    sprite: {
        src: SPRITE_SRC.CROPS,
        position: {x: 33, y: 4}
    },
    stages: cropStagesFactory(5, 4, 5, CROPS_NAMES.YAM),
    tools: [],
    destroyable: true,
    checkboxes: [],
    items: [],
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.CROPS,
    description: CROPS_DESCRIPTIONS[CROPS_NAMES.YAM]
}