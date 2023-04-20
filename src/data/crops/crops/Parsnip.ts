import {CropObject} from "../types";
import {CROPS_NAMES} from "../const";
import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../../types";
import {cropStagesFactory} from "../utils";
import {CROPS_DESCRIPTIONS} from "../../descriptions/crops";

export const Parsnip: CropObject = {
    id: CROPS_NAMES.PARSNIP,
    name: CROPS_NAMES.PARSNIP,
    hp: 100,
    sprite: {
        src: SPRITE_SRC.CROPS,
        position: {x: 29, y: 0}
    },
    stages: cropStagesFactory(1, 0, 5, CROPS_NAMES.PARSNIP),
    tools: [],
    destroyable: true,
    checkboxes: [],
    items: [],
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.CROPS,
    description: CROPS_DESCRIPTIONS[CROPS_NAMES.PARSNIP]
}