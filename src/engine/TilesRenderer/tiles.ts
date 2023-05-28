import {app} from "../../index";
import {Sprite} from 'pixi.js';

export class TilesRenderer {
    constructor() {
    }

    public render(): void {
        const tile1 = new Sprite(app.loader.resources['assets/trees-md.png'].texture);
        tile1.position.set(0, 0);
        tile1.scale.set(1);

        // Add the tiles to the stage
        app.stage.addChild(tile1);
        console.log(tile1);
    }
}