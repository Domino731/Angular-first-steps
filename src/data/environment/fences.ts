import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, EngineObject, SPRITE_SRC} from "../types";
import {TREE_ITEMS, TREE_NAMES} from "./types";
import {TOOLS} from "../tools/types";

const defaultHp: number = 400;

const fencesDataFactory = (fenceName: 'Oak' | 'Stone' | 'Iron' | 'Pine') => {
    let increaseX = 0;

    switch (fenceName) {
        case "Iron":
            increaseX += 3;
            break;
        case "Stone":
            increaseX += 6;
            break;
        case "Pine":
            increaseX += 9;
            break;
        case "Oak":
            break;
    }

    return [
        {
            id: `${fenceName} right direction`,
            name: `${fenceName} right direction`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FENCES,
                position: {
                    x: 0 + increaseX,
                    y: 0,
                }
            },
            tools: [TOOLS.AXE],
            destroyable: true,
            checkboxes: [
                {
                    x: 0,
                    y: 0,
                    width: 40,
                    height: 40
                }
            ],
            items: [TREE_ITEMS.WOOD]
        },
        {
            id: `${fenceName} left direction`,
            name: `${fenceName} left direction`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FENCES,
                position: {
                    x: 2 + increaseX,
                    y: 0,
                }
            },
            tools: [TOOLS.AXE],
            destroyable: true,
            checkboxes: [
                {
                    x: 0,
                    y: 0,
                    width: 40,
                    height: 40
                }
            ],
            items: [TREE_ITEMS.WOOD]
        },
        {
            id: `${fenceName} top direction`,
            name: `${fenceName} top direction`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FENCES,
                position: {
                    x: 0 + increaseX,
                    y: 1,
                }
            },
            tools: [TOOLS.AXE],
            destroyable: true,
            checkboxes: [
                {
                    x: 0,
                    y: 0,
                    width: 40,
                    height: 40
                }
            ],
            items: [TREE_ITEMS.WOOD]
        },
        {
            id: `${fenceName} column`,
            name: `${fenceName} column`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FENCES,
                position: {
                    x: 2 + increaseX,
                    y: 1,
                }
            },
            tools: [TOOLS.AXE],
            destroyable: true,
            checkboxes: [
                {
                    x: 0,
                    y: 0,
                    width: 40,
                    height: 40
                }
            ],
            items: [TREE_ITEMS.WOOD]
        },
        {
            id: `${fenceName} connect`,
            name: `${fenceName} connect`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FENCES,
                position: {
                    x: 1 + increaseX,
                    y: 1,
                }
            },
            tools: [TOOLS.AXE],
            destroyable: true,
            checkboxes: [
                {
                    x: 0,
                    y: 0,
                    width: 40,
                    height: 40
                }
            ],
            items: [TREE_ITEMS.WOOD]
        },
        {
            id: `${fenceName} left i direction`,
            name: `${fenceName} left i direction`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FENCES,
                position: {
                    x: 0 + increaseX,
                    y: 3,
                }
            },
            tools: [TOOLS.AXE],
            destroyable: true,
            checkboxes: [
                {
                    x: 0,
                    y: 0,
                    width: 40,
                    height: 40
                }
            ],
            items: [TREE_ITEMS.WOOD]
        },
        {
            id: `${fenceName} right i direction`,
            name: `${fenceName} right i direction`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FENCES,
                position: {
                    x: 1 + increaseX,
                    y: 3,
                }
            },
            tools: [TOOLS.AXE],
            destroyable: true,
            checkboxes: [
                {
                    x: 0,
                    y: 0,
                    width: 40,
                    height: 40
                }
            ],
            items: [TREE_ITEMS.WOOD]
        },
    ]
}

export const fences: Array<EngineObject> = [
    ...fencesDataFactory(`Oak`),
    ...fencesDataFactory(`Iron`),
    ...fencesDataFactory(`Stone`),
    ...fencesDataFactory(`Pine`)
].map(el => ({
    ...el,
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.TREES
}))