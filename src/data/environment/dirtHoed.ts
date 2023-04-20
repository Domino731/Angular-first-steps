import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, EngineObject, SPRITE_SRC} from "../types";
import {TOOLS} from "../tools/types";
import {TREE_ITEMS} from "./types";

const defaultHp = 0;
const dirtHoedFactory = (hydratedPercentage: 100 | 75 | 50 | 25) => {
    let xOffset: number = 0;
    let yOffset: number = 0;

    switch (hydratedPercentage) {
        case 100:
            xOffset = 4;
            yOffset = 4;
            break;
        case 75:
            xOffset = 0;
            yOffset = 4;
            break;
        case 50:
            xOffset = 4;
            yOffset = 0;
            break;
        case 25:
            xOffset = 0;
            yOffset = 0;
            break;
    }

    return [
        {
            id: `Dirt hydrated ${hydratedPercentage}% without border`,
            name: `Dirt hydrated ${hydratedPercentage}% without border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.DIRT_HOED,
                position: {
                    x: 0 + xOffset,
                    y: 0 + yOffset,
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
            id: `Dirt hydrated ${hydratedPercentage}% top-left border`,
            name: `Dirt hydrated ${hydratedPercentage}% top-left border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.DIRT_HOED,
                position: {
                    x: 1 + xOffset,
                    y: 0 + yOffset,
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
            id: `Dirt hydrated ${hydratedPercentage}% top border`,
            name: `Dirt hydrated ${hydratedPercentage}% top border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.DIRT_HOED,
                position: {
                    x: 2 + xOffset,
                    y: 0 + yOffset,
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
            id: `Dirt hydrated ${hydratedPercentage}% top-right border`,
            name: `Dirt hydrated ${hydratedPercentage}% top-right border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.DIRT_HOED,
                position: {
                    x: 3 + xOffset,
                    y: 0 + yOffset,
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
            id: `Dirt hydrated ${hydratedPercentage}% left-top-right border`,
            name: `Dirt hydrated ${hydratedPercentage}% left-top-right border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.DIRT_HOED,
                position: {
                    x: 0 + xOffset,
                    y: 1 + yOffset,
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
            id: `Dirt hydrated ${hydratedPercentage}% left border`,
            name: `Dirt hydrated ${hydratedPercentage}% left border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.DIRT_HOED,
                position: {
                    x: 1 + xOffset,
                    y: 1 + yOffset,
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
            id: `Dirt hydrated ${hydratedPercentage}% floor`,
            name: `Dirt hydrated ${hydratedPercentage}% floor`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.DIRT_HOED,
                position: {
                    x: 2 + xOffset,
                    y: 1 + yOffset,
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
            id: `Dirt hydrated ${hydratedPercentage}% right floor`,
            name: `Dirt hydrated ${hydratedPercentage}% right floor`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.DIRT_HOED,
                position: {
                    x: 3 + xOffset,
                    y: 1 + yOffset,
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
            id: `Dirt hydrated ${hydratedPercentage}% left-right border`,
            name: `Dirt hydrated ${hydratedPercentage}% left-right border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.DIRT_HOED,
                position: {
                    x: 0 + xOffset,
                    y: 2 + yOffset,
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
            id: `Dirt hydrated ${hydratedPercentage}% left-bottom border`,
            name: `Dirt hydrated ${hydratedPercentage}% left-bottom border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.DIRT_HOED,
                position: {
                    x: 1 + xOffset,
                    y: 2 + yOffset,
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
            id: `Dirt hydrated ${hydratedPercentage}% bottom border`,
            name: `Dirt hydrated ${hydratedPercentage}% bottom border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.DIRT_HOED,
                position: {
                    x: 2 + xOffset,
                    y: 2 + yOffset,
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
            id: `Dirt hydrated ${hydratedPercentage}% bottom-right border`,
            name: `Dirt hydrated ${hydratedPercentage}% bottom-right border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.DIRT_HOED,
                position: {
                    x: 3 + xOffset,
                    y: 2 + yOffset,
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
            id: `Dirt hydrated ${hydratedPercentage}% left-bottom-right border`,
            name: `Dirt hydrated ${hydratedPercentage}% left-bottom-right border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.DIRT_HOED,
                position: {
                    x: 0 + xOffset,
                    y: 3 + yOffset,
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
            id: `Dirt hydrated ${hydratedPercentage}% left-top-bottom border`,
            name: `Dirt hydrated ${hydratedPercentage}% left-top-bottom border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.DIRT_HOED,
                position: {
                    x: 1 + xOffset,
                    y: 3 + yOffset,
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
            id: `Dirt hydrated ${hydratedPercentage}% top-bottom border`,
            name: `Dirt hydrated ${hydratedPercentage}% top-bottom border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.DIRT_HOED,
                position: {
                    x: 2 + xOffset,
                    y: 3 + yOffset,
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
            id: `Dirt hydrated ${hydratedPercentage}% left-right-bottom border`,
            name: `Dirt hydrated ${hydratedPercentage}% left-right-bottom border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.DIRT_HOED,
                position: {
                    x: 3 + xOffset,
                    y: 3 + yOffset,
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

export const dirtHoed: Array<EngineObject> = [
    ...dirtHoedFactory(100),
    ...dirtHoedFactory(75),
    ...dirtHoedFactory(50),
    ...dirtHoedFactory(25),
].map(el => ({
    ...el,
    group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
    type: ENGINE_OBJECTS_TYPES.TREES
}))