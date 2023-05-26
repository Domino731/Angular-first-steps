import * as PIXI from 'pixi.js';
import {engineNotif} from "../utils/consoleNotifications";
import {getTilesSetData} from "../utils/assets";

// TODO any
export const loadTextures = (app: PIXI.Application, sceneData: any) => {
    const tilesSpriteNames: Array<string> = [];
    const texturesSrc: Array<string> = [];

    sceneData.tiles.forEach(({spriteName}: { spriteName: string }) => {
        if (!tilesSpriteNames.includes(spriteName)) {
            tilesSpriteNames.push(spriteName);
            const textureSrc = getTilesSetData(spriteName)?.src
            if (textureSrc) {
                texturesSrc.push(textureSrc);
            }
        }
    })
    console.log(texturesSrc);

    return new Promise<void>((resolve) => {
        // basic, for grass tiles
        app.loader.add('assets/outdoors_spring.png');
        // load textures from scene
        texturesSrc.forEach((src: string) => app.loader.add(src));

        app.loader.add('assets/trees-md.png');
        app.loader.add('assets/trees-lg.png');


        app.loader.load();
        app.loader.onComplete.add(() => {
            engineNotif('Textures loaded successfully')
            resolve();
        })
    });
};
