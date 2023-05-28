import * as PIXI from 'pixi.js';
import {HelloWorld} from './scenes/helloWorld';
import {loadTextures} from "./engine/textures";
import {TilesRenderer} from "./engine/TilesRenderer/TilesRenderer.class";
import {Tile} from "./engine/TilesRenderer/Tile";

const TEST_1_SCENE = require('./scenes/TEST_1.json');

// Main app

export const app = new PIXI.Application();

// Display application properly
document.body.style.margin = '0';
app.renderer.view.style.position = 'absolute';
app.renderer.view.style.display = 'block';

// View size = windows
app.renderer.resize(window.innerWidth, window.innerHeight);
window.addEventListener('resize', () => {
    app.renderer.resize(window.innerWidth, window.innerHeight);
});

// Load assets
loadTextures(app, TEST_1_SCENE).then(() => {
    document.body.appendChild(app.view);

    // Set scene
    // const scene = new HelloWorld(app);
    new TilesRenderer();
    // app.stage.addChild(scene);
});

// Game logic here:
new TilesRenderer().render();
