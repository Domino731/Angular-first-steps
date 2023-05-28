import {Application, Container, Sprite, Rectangle, Texture, BaseTexture} from 'pixi.js';
import {DirectionInitialState} from "../../../scenes/const";
import {app} from "../../../index";
import {TILE_SIZE} from "./Tile.types";


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
        const frame = new Texture(spritesheet, new Rectangle(0, 0, TILE_SIZE.WIDTH, TILE_SIZE.HEIGHT));
        this.sprite = new Sprite(
            frame
        );

        this.sprite.x = 0;
        this.sprite.y = 0;
        this.addChild(this.sprite);

        this.initEvents();
        // Handle update
        app.ticker.add(this.update);
    }

    changeDirection(): void {
    }

    initEvents(): void {

    }

    update(_: any) {

    }
}