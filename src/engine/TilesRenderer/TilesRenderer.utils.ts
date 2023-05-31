import {SceneJsonTile} from "../../types";
import {APP_MAP_SIZE_HEIGHT, APP_MAP_SIZE_WIDTH} from "../../app/app.const";
import {DEFAULT_TILE_CORDS, DEFAULT_TILE_SPRITE_NAME} from "./TilesRenderer.const";

export const createTilesData = (sceneTiles: Array<SceneJsonTile>): Array<Array<SceneJsonTile>> => {
    const multiDimArray: Array<Array<SceneJsonTile>> = [];

    const mapWidth: number = APP_MAP_SIZE_WIDTH - 1;
    const mapHeight: number = APP_MAP_SIZE_HEIGHT - 1;

    // create multi-dimensional array - 100x100
    for (let i = 0; i < mapHeight; i++) {
        multiDimArray[i] = [];
    }
    for (let i = 0; i < mapHeight; i++) {
        for (let j = 0; j < mapWidth; j++) {
            multiDimArray[i][j] = {
                spriteCords: {x: DEFAULT_TILE_CORDS.X, y: DEFAULT_TILE_CORDS.Y},
                cords: {x: j, y: i},
                spriteName: DEFAULT_TILE_SPRITE_NAME,
            };
        }
    }

    // push tiles from scene
    sceneTiles.forEach((sceneTile: SceneJsonTile) => {
        const {cords: {x, y}} = sceneTile;
        multiDimArray[y][x] = {
            ...sceneTile,
            spriteCords: {x: sceneTile.spriteCords.x * 16, y: sceneTile.spriteCords.y * 16},
        };
    })

    return multiDimArray;
}