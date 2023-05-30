import {app} from "../../index";
import {Tile} from "./Tile";
import {SceneJsonTile} from "../../types";
import {createTilesData} from "./TilesRenderer.utils";

export class TilesRenderer {
    constructor(sceneTiles: Array<SceneJsonTile>) {
        createTilesData(sceneTiles)
        this.render();
    }

    public render(): void {
        const tile = new Tile();
        app.stage.addChild(tile)
    }
}