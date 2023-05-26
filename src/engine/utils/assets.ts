import {TileSets} from "../../data/tileSets";
import {TileSetInterface} from "../../data/tileSets/types";

export const getTilesSetData = (spriteName: string): TileSetInterface | undefined => {
    return TileSets.find(({name}) => spriteName === name);
};