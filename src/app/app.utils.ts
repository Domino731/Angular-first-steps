import {Sprite} from "pixi.js";
import {APP_SCALE} from "./app.const";

export const scaleSprite = (sprite: Sprite) => sprite.scale.set(APP_SCALE, APP_SCALE)