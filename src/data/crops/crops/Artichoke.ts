import {CropObject} from "../types";
import {CROPS_NAMES} from "../const";
import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../../types";
import {cropStagesFactory} from "../utils";
import {CROPS_DESCRIPTIONS} from "../../descriptions/crops";

export const Artichoke: CropObject = {
    id: CROPS_NAMES.ARTICHOKE,
    name: CROPS_NAMES.ARTICHOKE,
    hp: 100,
    sprite: {
        src: SPRITE_SRC.CROPS,
        position: {x: 32, y: 3}
    },
    stages: cropStagesFactory(4, 3, 5, CROPS_NAMES.ARTICHOKE),
    tools: [],
    destroyable: true,
    checkboxes: [],
    items: [],
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.CROPS,
    description: CROPS_DESCRIPTIONS[CROPS_NAMES.ARTICHOKE]
}