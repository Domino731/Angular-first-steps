import {EngineObject} from "../types";

export interface TreeStageObject extends EngineObject {
    stage: number;
}

export interface TreeObject extends EngineObject {
    stages: Array<TreeStageObject>;
}

export interface TreeObjectStage {
    data: TreeObject
}

export interface TreeObjectStage extends EngineObject {
}

export enum TREE_NAMES {
    MAPLE_SUMMER = 'MAPLE_SUMMER',
    MAPLE_AUTUMN = 'MAPLE_AUTUMN',
    MAPLE_WINTER = 'MAPLE_WINTER',
    MAPLE_SPRING = 'MAPLE_SPRING',
    MAPLE_TREE_STAGE_4 = 'MAPLE_TREE_STAGE_4',
    MAPLE_TREE_STAGE_3 = 'MAPLE_TREE_STAGE_3',
    MAPLE_TREE_STAGE_2 = 'MAPLE_TREE_STAGE_2',
    MAPLE_TREE_STAGE_1 = 'MAPLE_TREE_STAGE_1',

    OAK_SUMMER = 'OAK_SUMMER',
    OAK_AUTUMN = 'OAK_AUTUMN',
    OAK_WINTER = 'OAK_WINTER',
    OAK_SPRING = 'OAK_SPRING',
    OAK_TREE_STAGE_4 = 'OAK_TREE_STAGE_4',
    OAK_TREE_STAGE_3 = 'OAK_TREE_STAGE_3',
    OAK_TREE_STAGE_2 = 'OAK_TREE_STAGE_2',
    OAK_TREE_STAGE_1 = 'OAK_TREE_STAGE_1',


    PINE_SUMMER = 'PINE_SUMMER',
    PINE_AUTUMN = 'PINE_AUTUMN',
    PINE_WINTER = 'PINE_WINTER',
    PINE_SPRING = 'PINE_SPRING',
    PINE_TREE_STAGE_4 = 'PINE_TREE_STAGE_4',
    PINE_TREE_STAGE_3 = 'PINE_TREE_STAGE_3',
    PINE_TREE_STAGE_2 = 'PINE_TREE_STAGE_2',
    PINE_TREE_STAGE_1 = 'PINE_TREE_STAGE_1',

    MAHOGANY_SUMMER = 'MAHOGANY_SUMMER',
    MAHOGANY_AUTUMN = 'MAHOGANY_AUTUMN',
    MAHOGANY_WINTER = 'MAHOGANY_WINTER',
    MAHOGANY_SPRING = 'MAHOGANY_SPRING',
    MAHOGANY_TREE_STAGE_4 = 'MAHOGANY_TREE_STAGE_4',
    MAHOGANY_TREE_STAGE_3 = 'MAHOGANY_TREE_STAGE_3',
    MAHOGANY_TREE_STAGE_2 = 'MAHOGANY_TREE_STAGE_2',
    MAHOGANY_TREE_STAGE_1 = 'MAHOGANY_TREE_STAGE_1',
}

export enum BUSHES_NAMES {
    SUMMER_LG = 'SUMMER_LG',
    AUTUMN_LG = 'AUTUMN_LG',
    SPRING_LG = 'SPRING_LG',
    WINTER_LG = 'WINTER_LG',

    SUMMER_MD = 'SUMMER_MD',
    AUTUMN_MD = 'AUTUMN_MD',
    SPRING_MD = 'SPRING_MD',
    WINTER_MD = 'WINTER_MD',

    SUMMER_SM = 'SUMMER_SM',
    AUTUMN_SM = 'AUTUMN_SM',
    SPRING_SM = 'SPRING_SM',
    WINTER_SM = 'WINTER_SM',

    SUMMER_SM_DB = 'SUMMER_SM_DB',
    AUTUMN_SM_DB = 'AUTUMN_SM_DB',
    SPRING_SM_DB = 'SPRING_SM_DB',
    WINTER_SM_DB = 'WINTER_SM_DB',
}

export enum BUILDINGS_NAMES {
    BARN_SM = 'Barn small',
    BARN_MD = 'Barn medium',
    BARN_LG = 'Barn large',
    HOUSE_SM = 'House small',
    HOUSE_MD = 'House medium',
    HOUSE_LG = 'House large',
    STUD_FARM_SM = 'Stud farm small',
    STUD_FARM_MD = 'Stud farm medium',
    STUD_FARM_LG = 'Stud farm large',
    SILO = 'Silo',
    GLASSHOUSE = 'Glasshouse',
    WELL = 'Well'
}

export enum TREE_ITEMS {
    WOOD = 'WOOD'
}

export enum FLOORING_NAMES {
    Oak = 'Oak',
    Pine = 'Pine',
    LightStone = 'Light stone',
    Barn = 'Barn',
    Dirt = 'Dirt',
    Plank = 'Plank',
    DungeonStone = 'Dungeon stone'
}