import {CropObject} from "../types";
import {CROPS_NAMES} from "../const";
import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../../types";
import {cropStagesFactory} from "../utils";
import {CROPS_DESCRIPTIONS} from "../../descriptions/crops";

export const SweetGemBerry: CropObject = {
    id: CROPS_NAMES.SWEET_GEM_BERRY,
    name: CROPS_NAMES.SWEET_GEM_BERRY,
    hp: 100,
    sprite: {
        src: SPRITE_SRC.CROPS,
        position: {x: 41, y: 4}
    },
    stages: cropStagesFactory(6, 4, 6, CROPS_NAMES.SWEET_GEM_BERRY),
    tools: [],
    destroyable: true,
    checkboxes: [],
    items: [],
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.CROPS,
    description: CROPS_DESCRIPTIONS[CROPS_NAMES.SWEET_GEM_BERRY]
}