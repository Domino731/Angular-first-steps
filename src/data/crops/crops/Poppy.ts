import {CropObject} from "../types";
import {CROPS_NAMES} from "../const";
import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../../types";
import {cropStagesFactory} from "../utils";
import {CROPS_DESCRIPTIONS} from "../../descriptions/crops";

export const Poppy: CropObject = {
    id: CROPS_NAMES.POPPY,
    name: CROPS_NAMES.POPPY,
    hp: 100,
    sprite: {
        src: SPRITE_SRC.CROPS,
        position: {x: 30, y: 5}
    },
    stages: cropStagesFactory(2, 5, 5, CROPS_NAMES.POPPY),
    tools: [],
    destroyable: true,
    checkboxes: [],
    items: [],
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.CROPS,
    description: CROPS_DESCRIPTIONS[CROPS_NAMES.POPPY]
}