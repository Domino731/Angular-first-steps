import {CropObject} from "../types";
import {CROPS_NAMES} from "../const";
import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../../types";
import {cropStagesFactory} from "../utils";
import {CROPS_DESCRIPTIONS} from "../../descriptions/crops";

export const Potato: CropObject = {
    id: CROPS_NAMES.POTATO,
    name: CROPS_NAMES.POTATO,
    hp: 100,
    sprite: {
        src: SPRITE_SRC.CROPS,
        position: {x: 29, y: 1}
    },
    stages: cropStagesFactory(1, 1, 5, CROPS_NAMES.POTATO),
    tools: [],
    destroyable: true,
    checkboxes: [],
    items: [],
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.CROPS,
    description: CROPS_DESCRIPTIONS[CROPS_NAMES.POTATO]
}