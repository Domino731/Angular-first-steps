import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, EngineObject, SPRITE_SRC} from "../types";
import {BUILDINGS_NAMES, TREE_ITEMS, TREE_NAMES} from "./types";
import {TOOLS} from "../tools/types";

const defaultHp: number = 0;

export const buildings: Array<EngineObject> = [
    {
        id: BUILDINGS_NAMES.BARN_SM,
        name: BUILDINGS_NAMES.BARN_SM,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.BARN_SM,
            position: {
                x: 0,
                y: 0,
            }
        },
        tools: [],
        destroyable: false,
        checkboxes: [],
        items: []
    },
    {
        id: BUILDINGS_NAMES.BARN_MD,
        name: BUILDINGS_NAMES.BARN_MD,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.BARN_MD,
            position: {
                x: 0,
                y: 0,
            }
        },
        tools: [],
        destroyable: false,
        checkboxes: [],
        items: []
    },
    {
        id: BUILDINGS_NAMES.BARN_LG,
        name: BUILDINGS_NAMES.BARN_LG,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.BARN_LG,
            position: {
                x: 0,
                y: 0,
            }
        },
        tools: [],
        destroyable: false,
        checkboxes: [],
        items: []
    },
    {
        id: BUILDINGS_NAMES.HOUSE_SM,
        name: BUILDINGS_NAMES.HOUSE_SM,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.HOUSE_SM,
            position: {
                x: 0,
                y: 0,
            }
        },
        tools: [],
        destroyable: false,
        checkboxes: [],
        items: []
    },
    {
        id: BUILDINGS_NAMES.HOUSE_MD,
        name: BUILDINGS_NAMES.HOUSE_MD,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.HOUSE_SM,
            position: {
                x: 0,
                y: 0,
            }
        },
        tools: [],
        destroyable: false,
        checkboxes: [],
        items: []
    },
    {
        id: BUILDINGS_NAMES.HOUSE_LG,
        name: BUILDINGS_NAMES.HOUSE_LG,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.HOUSE_LG,
            position: {
                x: 0,
                y: 0,
            }
        },
        tools: [],
        destroyable: false,
        checkboxes: [],
        items: []
    },
    {
        id: BUILDINGS_NAMES.STUD_FARM_SM,
        name: BUILDINGS_NAMES.STUD_FARM_SM,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.STUD_FARM_SM,
            position: {
                x: 0,
                y: 0,
            }
        },
        tools: [],
        destroyable: false,
        checkboxes: [],
        items: []
    },
    {
        id: BUILDINGS_NAMES.STUD_FARM_MD,
        name: BUILDINGS_NAMES.STUD_FARM_MD,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.STUD_FARM_MD,
            position: {
                x: 0,
                y: 0,
            }
        },
        tools: [],
        destroyable: false,
        checkboxes: [],
        items: []
    },
    {
        id: BUILDINGS_NAMES.STUD_FARM_LG,
        name: BUILDINGS_NAMES.STUD_FARM_LG,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.STUD_FARM_LG,
            position: {
                x: 0,
                y: 0,
            }
        },
        tools: [],
        destroyable: false,
        checkboxes: [],
        items: []
    },
    {
        id: BUILDINGS_NAMES.SILO,
        name: BUILDINGS_NAMES.SILO,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.SILO,
            position: {
                x: 0,
                y: 0,
            }
        },
        tools: [],
        destroyable: false,
        checkboxes: [],
        items: []
    },
    {
        id: BUILDINGS_NAMES.GLASSHOUSE,
        name: BUILDINGS_NAMES.GLASSHOUSE,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.GLASSHOUSE,
            position: {
                x: 0,
                y: 0,
            }
        },
        tools: [],
        destroyable: false,
        checkboxes: [],
        items: []
    },
    {
        id: BUILDINGS_NAMES.WELL,
        name: BUILDINGS_NAMES.WELL,
        hp: defaultHp,
        sprite: {
            src: SPRITE_SRC.WELL,
            position: {
                x: 0,
                y: 0,
            }
        },
        tools: [],
        destroyable: false,
        checkboxes: [],
        items: []
    }
].map(el => ({...el, group: ENGINE_OBJECT_GROUPS.ENVIRONMENT, type: ENGINE_OBJECTS_TYPES.BUILDING}))