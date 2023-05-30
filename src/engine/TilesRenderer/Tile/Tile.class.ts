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

        this.sprite = new Sprite(frame);
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
        if (this.direction.left && !this.direction.right) {
            this.sprite.x -= APP_SPEED * delta;
        }
        if (this.direction.right && !this.direction.left) {
            this.sprite.x += APP_SPEED * delta;
        }

        if (this.direction.top && !this.direction.bottom) {
            this.sprite.y -= APP_SPEED * delta;
        }
        if (this.direction.bottom && !this.direction.top) {
            this.sprite.y += APP_SPEED * delta;
        }
    }
}