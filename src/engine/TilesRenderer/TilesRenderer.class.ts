import {app} from "../../index";
import {Tile} from "./Tile";
import {SceneJsonTile} from "../../types";
import {createTilesData} from "./TilesRenderer.utils";

export class TilesRenderer {
    private allTiles: Array<Array<SceneJsonTile>>;
    private tiles: Array<Tile>;

    constructor(sceneTiles: Array<SceneJsonTile>) {
        this.allTiles = createTilesData(sceneTiles);
        this.tiles = [];
        this.render();
    }

    private render(): void {
        this.allTiles.forEach(nestedTiles => nestedTiles.forEach(tile => {
            // if (tile.spriteName !== 'Outdoors summer') {
            const newTile = new Tile(tile);
            this.tiles.push(newTile);
            app.stage.addChild(newTile)
        }))
    }
}