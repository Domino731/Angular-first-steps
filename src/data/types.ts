import {TREE_ITEMS, TREE_NAMES} from "./environment/types";
import {TOOLS} from "./tools/types";
import {ExtendedEngineObject, Vector} from "../types";

export interface Checkbox {
    x: number,
    y: number,
    width: number,
    height: number
}


export interface EngineObject {
    group: keyof typeof ENGINE_OBJECT_GROUPS,
    type: keyof typeof ENGINE_OBJECTS_TYPES,
    id: string,
    name: string,
    hp: number,
    sprite: {
        src: string,
        position: {
            x: number,
            y: number,
        }
    },
    tools: Array<keyof typeof TOOLS>,
    destroyable: boolean,
    checkboxes: Array<Checkbox>,
    items: Array<string>;
    description?: string;
    toolsFor?: Array<ObjectToolInterface>
}

export interface EngineStageObject {
    id: string,
    name: string,
    hp: number,
    sprite: {
        src: string,
        position: {
            x: number,
            y: number,
        }
    },
    tools: Array<keyof typeof TOOLS>,
    destroyable: boolean,
    checkboxes: Array<Checkbox>,
    items: Array<string>,
    stage: number
}

export interface EngineObjectWithStages extends EngineObject {
    stages: Array<EngineStageObject>
}

export interface EngineObjectWithStages extends EngineObject {
}

export enum FOOD_ITEMS {
    STRAWBERRY = "STRAWBERRY"
}

export interface SpriteSize {
    cellWidth: number,
    cellHeight: number,
    height: number,
    width: number
}

export interface SpriteConfig {
    sprite: string,
    spriteContainerWidth?: number;
    size: SpriteSize
}

export const SPRITE_SRC = {
    BUSHES_DOUBLE_SM_PNG: 'bushes_double_sm.png',
    BUSHES_LG: 'bushes_lg.png',
    BUSHES_MD: 'bushes_md.png',
    BUSHES_SM: 'bushes_sm.png',
    MAHOGANY_STAGE_5: 'tree_stage_5_mahogany.png',
    MAPLE_STAGE_5: 'tree_stage_5_maple.png',
    OAK_STAGE_5: 'tree_stage_5_oak.png',
    PINE_STAGE_5: 'tree_stage_5_pine.png',
    OUTDOORS_SPRING: 'outdoors_spring.png',

    TREE_STAGE_1: 'trees-stage-1.png',
    TREE_STAGE_2: 'trees-stage-2.png',
    TREE_STAGE_3: 'trees-stage-3.png',
    TREE_STAGE_4: 'trees-stage-4.png',
    TREE_MD: 'trees-md.png',
    TREE_LG: 'trees-lg.png',
    TREE_XL: 'trees-xl.png',

    // resources
    RESOURCES_32: 'resources-32.png',
    RESOURCES_16: 'resources-16.png',

    // fences
    FENCES: 'fences.png',

    // flooring
    FLOORING: 'flooring.png',
    DIRT_HOED: 'dirt-hoed.png',

    // buildings
    BARN_SM: 'buildings/barn-sm.png',
    BARN_MD: 'buildings/barn-md.png',
    BARN_LG: 'buildings/barn-lg.png',
    HOUSE_SM: 'buildings/house-sm.png',
    HOUSE_MD: 'buildings/house-md.png',
    HOUSE_LG: 'buildings/house-lg.png',
    SILO: 'buildings/silo.png',
    GLASSHOUSE: 'buildings/glasshouse.png',
    STUD_FARM_SM: 'buildings/stud-farm-sm.png',
    STUD_FARM_MD: 'buildings/stud-farm-md.png',
    STUD_FARM_LG: 'buildings/stud-farm-lg.png',
    WELL: 'buildings/well.png',

    // crops
    CROPS: 'crops/crops-stages.png',
    CROPS_GIANT: 'crops/crops-giant.png'

}

export interface GameMapData {
    objects: Array<ExtendedEngineObject>;
    tiles: Array<GameMapTileData>;
}

export interface GameMapDataJson {
    tiles: Array<GameMapTileData>;
    objects: Record<EngineObjectTypesUnion, Array<ExtendedEngineObject>>;
}

export interface GameMapTileData {
    spriteName: string;
    cords: Vector;
    spriteCords: Vector;
}

export interface GroundData {
    spriteSrc: string;
    spriteCords: Vector;
    groundCellCords: Vector;
}

export interface MapObjectData {
    id: string,
    spriteSrc: string;
    spriteCords: Vector;
    positionCords: Vector;
}

export enum ENGINE_OBJECT_GROUPS {
    ENVIRONMENT = "ENVIRONMENT"
}

export enum ENGINE_OBJECTS_TYPES {
    TREES = 'TREES',
    RESOURCES_32 = 'RESOURCES_32',
    RESOURCES_16 = 'RESOURCES_16',
    BUILDING = 'BUILDING',
    CROPS = "CROPS",
    BUSHES = 'BUSHES'
}

export type EngineObjectTypesUnion = keyof typeof ENGINE_OBJECTS_TYPES;


export interface MapJsonData {
    ground: Array<GroundData>;
    objects: {
        environment: {
            trees: Array<MapObjectData>
        }
    }
}

export type EngineObjectsTypesUnion = keyof typeof ENGINE_OBJECTS_TYPES;

export interface DropItemInterface {
    id: string | number,
    chance: [number, number] | number;
    amount: number;
}

export interface ObjectToolInterface {
    id: string | number,
    damage: [number, number] | number;
    usage: number;
}

export interface ObjectStageInterface extends EngineObject {
    stage: number;
}