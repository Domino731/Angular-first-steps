import {app} from "../../index";
import {Tile} from "./Tile";
import {SceneJsonTile} from "../../types";
import {createTilesData} from "./TilesRenderer.utils";
import {DirectionInitialState} from "../../scenes/const";

export class TilesRenderer {
    private allTiles: Array<Array<SceneJsonTile>>;
    private tiles: Array<Tile>;
    private direction: {
        top: boolean;
        right: boolean;
        bottom: boolean;
        left: boolean;
    }

    constructor(sceneTiles: Array<SceneJsonTile>) {
        this.allTiles = createTilesData(sceneTiles);
        this.direction = {...DirectionInitialState}
        this.tiles = [];
        this.init();
    }

    private init(): void {
        this.render();
        this.keyboardEvents();
    };

    private render(): void {
        this.allTiles.forEach(nestedTiles => nestedTiles.forEach(tile => {
            // if (tile.spriteName !== 'Outdoors summer') {
            const newTile = new Tile(tile);
            this.tiles.push(newTile);
            app.stage.addChild(newTile);
        }))
    }

    private setTilesDirections(): void {
        this.tiles.forEach(tile => tile.setDirection(this.direction));
    }

    private keyboardEvents(): void {
        document.addEventListener('keypress', ({key}) => {
            switch (key) {
                case 'w':
                    this.direction.top = true;
                    this.setTilesDirections();
                    break;
                case 'd':
                    this.direction.right = true;
                    this.setTilesDirections();
                    break;
                case 's':
                    this.direction.bottom = true;
                    this.setTilesDirections();
                    break;
                case 'a':
                    this.direction.left = true;
                    this.setTilesDirections();
                    break;
            }
        });

        document.addEventListener('keyup', ({key}) => {
            switch (key) {
                case 'w':
                    this.direction.top = false;
                    this.setTilesDirections();
                    break;
                case 'd':
                    this.direction.right = false;
                    this.setTilesDirections();
                    break;
                case 's':
                    this.direction.bottom = false;
                    this.setTilesDirections();
                    break;
                case 'a':
                    this.direction.left = false;
                    this.setTilesDirections();
                    break;
            }
        });
    }
}