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
        // this.allTiles.forEach(nestedTiles => nestedTiles.forEach(tile => {
        //     // if (tile.spriteName !== 'Outdoors summer') {
        //     new Tile(tile);
        //     // }
        // }))
        const tile = new Tile(this.allTiles[0][0]);
        const til2 = new Tile(this.allTiles[0][1]);
        console.log(this.allTiles[0])
        app.stage.addChild(tile);
        app.stage.addChild(til2)
    }
}