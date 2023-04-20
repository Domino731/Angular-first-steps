import {CropObject} from "../types";
import {CROPS_NAMES} from "../const";
import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../../types";
import {cropStagesFactory} from "../utils";
import {CROPS_DESCRIPTIONS} from "../../descriptions/crops";

export const Eggplant: CropObject = {
    id: CROPS_NAMES.EGGPLANT,
    name: CROPS_NAMES.EGGPLANT,
    hp: 100,
    sprite: {
        src: SPRITE_SRC.CROPS,
        position: {x: 40, y: 0}
    },
    stages: cropStagesFactory(5, 0, 6, CROPS_NAMES.EGGPLANT),
    tools: [],
    destroyable: true,
    checkboxes: [],
    items: [],
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.CROPS,
    description: CROPS_DESCRIPTIONS[CROPS_NAMES.EGGPLANT]
}