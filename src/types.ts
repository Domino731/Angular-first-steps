// This file is for global types
import {EngineObject} from "./data/types";

export interface example {
}

export interface Vector {
    x: number;
    y: number;
}

export interface ExtendedEngineObject extends EngineObject {
    mapId: string;
    map: {
        cord: Vector;
    }
}

export interface SpriteDim {
    cellWidth: number;
    cellHeight: number;
    spriteWidth: number;
    spriteHeight: number;
}

export interface SceneJsonTile {
    spriteCords: Vector;
    cords: Vector;
    spriteName: string;
}