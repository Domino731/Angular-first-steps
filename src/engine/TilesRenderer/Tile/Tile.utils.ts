import {TileSets} from "../../../data/tileSets";

export const getSpritePathBySpriteName = (spriteName: string): string | undefined => {
    return TileSets.find(({name}: { name: string }) => name === spriteName)?.src;
}