import {CropObject} from "../types";
import {CROPS_NAMES} from "../const";
import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../../types";
import {cropStagesFactory} from "../utils";
import {CROPS_DESCRIPTIONS} from "../../descriptions/crops";

export const GreenBean: CropObject = {
    id: CROPS_NAMES.GREEN_BEAN,
    name: CROPS_NAMES.GREEN_BEAN,
    hp: 100,
    sprite: {
        src: SPRITE_SRC.CROPS,
        position: {x: 28, y: 4}
    },
    stages: cropStagesFactory(0, 4, 6, CROPS_NAMES.GREEN_BEAN),
    tools: [],
    destroyable: true,
    checkboxes: [],
    items: [],
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.CROPS,
    description: CROPS_DESCRIPTIONS[CROPS_NAMES.GREEN_BEAN]
}