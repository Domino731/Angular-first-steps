import * as PIXI from 'pixi.js';
import {engineNotif} from "../utils/consoleNotifications";
import {TileSets} from "../../data/tileSets";
import {getTextureWithPrefix} from "./utils";
import {SpritesConfig} from "../../data/spritesConfig";

export const loadTextures = (app: PIXI.Application) => {
    // get all textures paths
    const texturesPaths: Array<string> = [
        ...TileSets.map(({src}) => getTextureWithPrefix(src)),
        ...SpritesConfig.map(({sprite}) => getTextureWithPrefix(sprite))
    ]

    console.log(texturesPaths);
    return new Promise<void>((resolve) => {
        app.loader.add('assets/trees-md.png');
        app.loader.add('assets/trees-lg.png');
        app.loader.load();
        app.loader.onComplete.add(() => {
            engineNotif('Textures loaded successfully')
            resolve();
        })
    });
};
