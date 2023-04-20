import {SpriteDim, SpriteNamesUnion} from "../../types";
import {SpriteTypesUnion} from "../../const/types";
import {SPRITE_SRC} from "../types";

export enum TILES_NAMES {
    OUTDOOR_SPRING = 'OUTDOOR_SPRING'
}

export interface TilesSpriteSheet {
    label: string;
    src: string;
    size: SpriteDim;
    spriteName: keyof typeof TILES_NAMES;
    type: SpriteTypesUnion;
    appSrc: keyof typeof SPRITE_SRC
}