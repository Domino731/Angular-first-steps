import * as PIXI from 'pixi.js';
import {engineNotif} from "../utils/consoleNotifications";

export const loadTextures = (app: PIXI.Application) => {
    return new Promise<void>((resolve) => {
        app.loader.add('assets/trees-md.png').load(() => {
        });
        app.loader.onComplete.add(() => {
            engineNotif('Textures loaded successfully')
            resolve();
        })
    });
};
