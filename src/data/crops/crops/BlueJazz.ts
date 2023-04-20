import {CropObject} from "../types";
import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../../types";
import {CROPS_NAMES} from "../const";
import {cropStagesFactory} from "../utils";
import {CROPS_DESCRIPTIONS} from "../../descriptions/crops";

export const BlueJazz: CropObject = {
    id: CROPS_NAMES.BLUE_JAZZ,
    name: CROPS_NAMES.BLUE_JAZZ,
    hp: 100,
    sprite: {
        src: SPRITE_SRC.CROPS,
        position: {x: 28, y: 0}
    },
    stages: cropStagesFactory(0, 0, 5, CROPS_NAMES.BLUE_JAZZ),
    tools: [],
    destroyable: true,
    checkboxes: [],
    items: [],
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.CROPS,
    description: CROPS_DESCRIPTIONS[CROPS_NAMES.BLUE_JAZZ]
}