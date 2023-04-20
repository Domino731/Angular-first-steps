# Pixi.JS TypeScript boilerplate

I had a hard time setting up a development environment, so I decided to share it.
It can be useful to start from there if you want to start developping a game for browsers quickly.
This setup is supposed to be used with VS Code, as configuration is provided so that you hava all tools set up.

# Project stucture
- src/ contains all of the source code for your game.
- assets/ contains all of the game's assets, such as images, sounds, and other resources.
- scenes/ contains all of the game's scenes, which are typically different screens or states of the game (e.g. menu, gameplay, game over).
- sprites/ contains all of the game's sprites, which are the visual elements that make up the game's graphics (e.g. characters, enemies, obstacles).
- utils/ contains any utility functions or constants that are used throughout the game.
- app.js is the entry point for the game, where you initialize the Pixi.js application and set up the game's initial state.

## Demo

![pixijsstarterdemo](https://user-images.githubusercontent.com/1882000/117959954-cde93100-b31c-11eb-889b-4879bd596c6b.gif)

## Requirements

-   Node JS and NPM
-   VS Code
-   Chrome

## Setup

```bash
npm install
```

## Development

Launch the `Complete development` launch configuration.

Putting/removing breakpoints in the `.ts` files with VS Code in `/src` should work.
If it does not, please open an issue.

Edit the TypeScript files, the browser should refresh on save.
