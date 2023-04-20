import {CropObject} from "../types";
import {CROPS_NAMES} from "../const";
import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../../types";
import {cropStagesFactory} from "../utils";
import {CROPS_DESCRIPTIONS} from "../../descriptions/crops";

export const Starfruit: CropObject = {
    id: CROPS_NAMES.STARFRUIT,
    name: CROPS_NAMES.STARFRUIT,
    hp: 100,
    sprite: {
        src: SPRITE_SRC.CROPS,
        position: {x: 38, y: 2}
    },
    stages: cropStagesFactory(3, 2, 6, CROPS_NAMES.STARFRUIT),
    tools: [],
    destroyable: true,
    checkboxes: [],
    items: [],
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.CROPS,
    description: CROPS_DESCRIPTIONS[CROPS_NAMES.STARFRUIT]
}