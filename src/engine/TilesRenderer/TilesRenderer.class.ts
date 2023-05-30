import {app} from "../../index";
import {Tile} from "./Tile";
import {SceneJsonTile} from "../../types";
import {createTilesData} from "./TilesRenderer.utils";

export class TilesRenderer {
    private allTiles: Array<Array<SceneJsonTile>>;

    constructor(sceneTiles: Array<SceneJsonTile>) {
        this.allTiles = createTilesData(sceneTiles)
        this.render();
    }

    private render(): void {
        const tile = new Tile(this.allTiles[0][0]);
        app.stage.addChild(tile)
    }
}