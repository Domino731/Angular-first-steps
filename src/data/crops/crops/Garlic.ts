import {CropObject} from "../types";
import {CROPS_NAMES} from "../const";
import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../../types";
import {cropStagesFactory} from "../utils";
import {CROPS_DESCRIPTIONS} from "../../descriptions/crops";

export const Garlic: CropObject = {
    id: CROPS_NAMES.GARLIC,
    name: CROPS_NAMES.GARLIC,
    hp: 100,
    sprite: {
        src: SPRITE_SRC.CROPS,
        position: {x: 28, y: 3}
    },
    stages: cropStagesFactory(0, 3, 5, CROPS_NAMES.GARLIC),
    tools: [],
    destroyable: true,
    checkboxes: [],
    items: [],
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.CROPS,
    description: CROPS_DESCRIPTIONS[CROPS_NAMES.GARLIC]
}