import {Container, Sprite, Rectangle, Texture, BaseTexture} from 'pixi.js';
import {DirectionInitialState} from "../../../scenes/const";
import {app} from "../../../index";
import {DEFAULT_TILE_CORDS, TILE_SIZE} from "../TilesRenderer.const";
import {SceneJsonTile} from "../../../types";
import {getSpritePathBySpriteName} from "./Tile.utils";
import {APP_SPEED} from "../../../app/app.const";


export class Tile extends Container {
    sprite: Sprite;
    state: { velocity: { x: number; y: number } };
    direction: {
        top: boolean;
        right: boolean;
        bottom: boolean;
        left: boolean;
    }

    constructor(sceneTile: SceneJsonTile) {
        super();
        // set class keys
        this.state = {velocity: {x: 1, y: 1}};
        this.direction = {...DirectionInitialState}

        this.update = this.update.bind(this);
        const spritesheet: BaseTexture = app.loader.resources[getSpritePathBySpriteName(sceneTile.spriteName) ?? ''].texture as unknown as BaseTexture;
        const frame = new Texture(spritesheet, new Rectangle(sceneTile.spriteCords.x, sceneTile.spriteCords.y, TILE_SIZE.WIDTH, TILE_SIZE.HEIGHT));
        this.sprite = new Sprite(
            frame
        );

        this.sprite.x = sceneTile.cords.x * 16;
        this.sprite.y = sceneTile.cords.y * 16;
        this.addChild(this.sprite);
        // Handle update
        app.ticker.add(this.update);
    }

    public setDirection(direction: any): void {
        this.direction = direction;
    }

    update(delta: number) {
        let newX = this.sprite.x;
        let newY = this.sprite.y;
        if (this.direction.top) {
            newY = this.sprite.y + APP_SPEED * delta
        } else if (this.direction.bottom) {
            newY = this.sprite.y - APP_SPEED * delta
        }

        if (this.direction.left) {
            newX = this.sprite.x - APP_SPEED * delta
        } else if (this.direction.right) {
            newX = this.sprite.x + APP_SPEED * delta
        }


// Calculate the new position
//         const speed = 2; // Adjust the speed as needed
//         const newX = this.sprite.x + speed * delta; // Delta is the elapsed time since the last frame
//         const newY = this.sprite.y + speed * delta;
//
//         // Update the position of the sprite
        this.sprite.x = newX;
        this.sprite.y = newY;
    }
}