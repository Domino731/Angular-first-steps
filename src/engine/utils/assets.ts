import {TileSets} from "../../data/tileSets";
import {TileSetInterface} from "../../data/tileSets/types";

export const getTilesSetData = (spriteName: string): TileSetInterface | undefined => {
    let data = TileSets.find(({name}) => spriteName === name);
    if (data) {
        data = {...data, src: `assets/${data.src}`};
    }
    return data;
};