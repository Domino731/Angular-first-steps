import {CropObject} from "../types";
import {CROPS_NAMES} from "../const";
import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../../types";
import {cropStagesFactory} from "../utils";
import {CROPS_DESCRIPTIONS} from "../../descriptions/crops";

export const Amaranth: CropObject = {
    id: CROPS_NAMES.AMARANTH,
    name: CROPS_NAMES.AMARANTH,
    hp: 100,
    sprite: {
        src: SPRITE_SRC.CROPS,
        position: {x: 32, y: 1}
    },
    stages: cropStagesFactory(4, 1, 5, CROPS_NAMES.AMARANTH),
    tools: [],
    destroyable: true,
    checkboxes: [],
    items: [],
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.CROPS,
    description: CROPS_DESCRIPTIONS[CROPS_NAMES.AMARANTH]
}