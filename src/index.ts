import * as PIXI from 'pixi.js';
import { HelloWorld } from './scenes/helloWorld';
import {loadTextures} from "./engine/textures";

const main = async () => {
    // Main app
    let app = new PIXI.Application();

    // Display application properly
    document.body.style.margin = '0';
    app.renderer.view.style.position = 'absolute';
    app.renderer.view.style.display = 'block';

    // View size = windows
    app.renderer.resize(window.innerWidth, window.innerHeight);
    window.addEventListener('resize', (e) => {
        app.renderer.resize(window.innerWidth, window.innerHeight);
    });

    // Load assets
    await loadTextures(app);
    document.body.appendChild(app.view);

    // Set scene
    const scene = new HelloWorld(app);
    app.stage.addChild(scene);
};

main();
