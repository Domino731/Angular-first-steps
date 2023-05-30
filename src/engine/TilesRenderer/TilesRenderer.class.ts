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
                    console.log('w');
                    this.direction = {
                        ...DirectionInitialState,
                        top: true
                    }
                    this.setTilesDirections();
                    break;
                case 'd':
                    this.direction = {
                        ...DirectionInitialState,
                        right: true
                    }
                    this.setTilesDirections();
                    break;
                case 's':
                    this.direction = {
                        ...DirectionInitialState,
                        bottom: true
                    }
                    this.setTilesDirections();
                    break;
                case 'a':
                    this.direction = {
                        ...DirectionInitialState,
                        left: true
                    }
                    this.setTilesDirections();
                    break;
            }
        });

        document.addEventListener('keyup', ({key}) => {
            if (key === 'w' || key === 'd' || key === 's' || key === 'a') {
                this.direction = {...DirectionInitialState};
                this.setTilesDirections();
            }
        });
    }
}