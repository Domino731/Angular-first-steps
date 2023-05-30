import {Application, Container, Sprite, Rectangle, Texture, BaseTexture} from 'pixi.js';
import {DirectionInitialState} from "../../../scenes/const";
import {app} from "../../../index";
import {DEFAULT_TILE_CORDS, TILE_SIZE} from "../TilesRenderer.const";


export class Tile extends Container {
    sprite: Sprite;
    state: { velocity: { x: number; y: number } };
    direction: {
        top: boolean;
        right: boolean;
        bottom: boolean;
        left: boolean;
    }

    constructor() {
        super();
        // set class keys
        this.state = {velocity: {x: 1, y: 1}};
        this.direction = {...DirectionInitialState}

        this.update = this.update.bind(this);


        // create sprite
        const spritesheet: BaseTexture = app.loader.resources['assets/outdoors_spring.png'].texture as unknown as BaseTexture;
        const frame = new Texture(spritesheet, new Rectangle(DEFAULT_TILE_CORDS.X, DEFAULT_TILE_CORDS.Y, TILE_SIZE.WIDTH, TILE_SIZE.HEIGHT));
        this.sprite = new Sprite(
            frame
        );

        this.sprite.x = 0;
        this.sprite.y = 0;
        this.addChild(this.sprite);
        // Handle update
        app.ticker.add(this.update);
    }

    update(_: any) {

    }
}