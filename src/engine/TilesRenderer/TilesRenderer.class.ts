import {app} from "../../index";
import {Sprite} from 'pixi.js';
import {Tile} from "./Tile";

export class TilesRenderer {
    constructor() {
        this.render();
    }

    public render(): void {
        const tile = new Tile();
        app.stage.addChild(tile)
    }
}