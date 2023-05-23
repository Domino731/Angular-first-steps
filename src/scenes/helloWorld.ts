import {Application, Container, Sprite} from 'pixi.js';
import {DirectionInitialState} from "./const";

export class HelloWorld extends Container {
    app: Application;
    sprite: Sprite;
    state: { velocity: { x: number; y: number } };
    direction: {
        top: boolean;
        right: boolean;
        bottom: boolean;
        left: boolean;
    }

    constructor(app: Application) {
        super();
        // set class keys
        this.app = app;
        this.state = {velocity: {x: 1, y: 1}};
        this.direction = {...DirectionInitialState}

        this.update = this.update.bind(this);


        // create sprite
        this.sprite = new Sprite(
            app.loader.resources['assets/trees-md.png'].texture
        );

        this.sprite.x = window.innerWidth / 2 - this.sprite.width / 2;
        this.sprite.y = window.innerHeight / 2 - this.sprite.height / 2;
        this.addChild(this.sprite);

        this.initEvents();
        // Handle update
        app.ticker.add(this.update);
    }

    changeDirection(): void {
        document.addEventListener('keypress', ({key}) => {
            switch (key) {
                case 'w':
                    console.log(1);
                    this.direction = {
                        ...DirectionInitialState,
                        top: true
                    }
                    break;
                case 'd':
                    this.direction = {
                        ...DirectionInitialState,
                        right: true
                    }
                    break;
                case 's':
                    this.direction = {
                        ...DirectionInitialState,
                        bottom: true
                    }
                    break;
                case 'a':
                    this.direction = {
                        ...DirectionInitialState,
                        left: true
                    }
                    break;
            }
        });

        document.addEventListener('keyup', ({key}) => {
            if (key === 'w' || key === 'd' || key === 's' || key === 'a') {
                this.direction = {...DirectionInitialState};
            }
        });
    }

    initEvents(): void {
        this.changeDirection();
        console.log(1);
    }

    update(_: any) {
        if (
            this.sprite.x <= 0 ||
            this.sprite.x >= window.innerWidth - this.sprite.width
        ) {
            this.state.velocity.x = -this.state.velocity.x;
        }
        if (
            this.sprite.y <= 0 ||
            this.sprite.y >= window.innerHeight - this.sprite.height
        ) {
            this.state.velocity.y = -this.state.velocity.y;
        }
        this.sprite.x += this.state.velocity.x;
        this.sprite.y += this.state.velocity.y;
    }
}
