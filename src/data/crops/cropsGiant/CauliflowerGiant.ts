import {CropObject} from "../types";
import {CROPS_NAMES} from "../const";
import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../../types";

export const CauliflowerGiant: CropObject = {
    id: CROPS_NAMES.CAULIFLOWER_GIANT,
    name: CROPS_NAMES.CAULIFLOWER_GIANT,
    hp: 100,
    sprite: {
        src: SPRITE_SRC.CROPS_GIANT,
        position: {x: 0, y: 0}
    },
    tools: [],
    stages: [],
    destroyable: true,
    checkboxes: [],
    items: [],
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.CROPS
}