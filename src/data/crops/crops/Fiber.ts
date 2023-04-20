import {CropObject} from "../types";
import {CROPS_NAMES} from "../const";
import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../../types";
import {cropStagesFactory} from "../utils";
import {CROPS_DESCRIPTIONS} from "../../descriptions/crops";

export const Fiber: CropObject = {
    id: CROPS_NAMES.FIBER,
    name: CROPS_NAMES.FIBER,
    hp: 100,
    sprite: {
        src: SPRITE_SRC.CROPS,
        position: {x: 34, y: 1}
    },
    stages: cropStagesFactory(6, 1, 5, CROPS_NAMES.FIBER),
    tools: [],
    destroyable: true,
    checkboxes: [],
    items: [],
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.CROPS,
    description: CROPS_DESCRIPTIONS[CROPS_NAMES.FIBER]
}