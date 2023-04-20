import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, EngineObject, SPRITE_SRC} from "../types";
import {TOOLS} from "../tools/types";
import {TREE_ITEMS} from "./types";

const defaultHp = 100;
const flooringFactory = (flooringName: 'Oak' | 'Stone' | 'Pine' | 'Light stone' | 'Barn' | 'Dirt' | 'Plank' | 'Dungeon stone') => {
    let xOffset: number = 0;
    let yOffset: number = 0;

    switch (flooringName) {
        // y = 0
        case 'Stone':
            xOffset = 4;
            yOffset = 0;
            break;
        case 'Pine':
            xOffset = 8;
            yOffset = 0;
            break;
        case 'Light stone':
            xOffset = 12;
            yOffset = 0;
            break;
        // y = 1
        case 'Barn':
            xOffset = 0;
            yOffset = 4;
            break;
        case 'Dirt':
            xOffset = 4;
            yOffset = 4;
            break;
        // y = 3;
        case 'Dungeon stone':
            xOffset = 0;
            yOffset = 12;
            break;
        case 'Plank':
            xOffset = 8;
            yOffset = 4;
            break;
        //
        // default set oak flooring offsets
        default:
            xOffset = 0;
            yOffset = 0;
            break;
    }

    return [
        {
            id: `${flooringName} without border`,
            name: `${flooringName} without border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FLOORING,
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
            id: `${flooringName} top-left border`,
            name: `${flooringName} top-left border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FLOORING,
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
            id: `${flooringName} top border`,
            name: `${flooringName} top border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FLOORING,
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
            id: `${flooringName} top-right border`,
            name: `${flooringName} top-right border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FLOORING,
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
            id: `${flooringName} left-top-right border`,
            name: `${flooringName} left-top-right border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FLOORING,
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
            id: `${flooringName} left border`,
            name: `${flooringName} left border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FLOORING,
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
            id: `${flooringName} floor`,
            name: `${flooringName} floor`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FLOORING,
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
            id: `${flooringName} right floor`,
            name: `${flooringName} right floor`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FLOORING,
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
            id: `${flooringName} left-right border`,
            name: `${flooringName} left-right border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FLOORING,
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
            id: `${flooringName} left-bottom border`,
            name: `${flooringName} left-bottom border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FLOORING,
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
            id: `${flooringName} bottom border`,
            name: `${flooringName} bottom border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FLOORING,
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
            id: `${flooringName} bottom-right border`,
            name: `${flooringName} bottom-right border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FLOORING,
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
            id: `${flooringName} left-bottom-right border`,
            name: `${flooringName} left-bottom-right border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FLOORING,
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
            id: `${flooringName} left-top-bottom border`,
            name: `${flooringName} left-top-bottom border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FLOORING,
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
            id: `${flooringName} top-bottom border`,
            name: `${flooringName} top-bottom border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FLOORING,
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
            id: `${flooringName} left-right-bottom border`,
            name: `${flooringName} left-right-bottom border`,
            hp: defaultHp,
            sprite: {
                src: SPRITE_SRC.FLOORING,
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

export const flooring: Array<EngineObject> = [
    ...flooringFactory('Oak'),
    ...flooringFactory('Stone'),
    ...flooringFactory('Pine'),
    ...flooringFactory('Light stone'),
    ...flooringFactory('Barn'),
    ...flooringFactory('Dirt'),
    ...flooringFactory('Plank'),
    ...flooringFactory('Dungeon stone'),
]
    .map(el => ({
        ...el,
        group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
        type: ENGINE_OBJECTS_TYPES.TREES
    }))