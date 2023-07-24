package game.entities.player;

import engine.actors.movableDefaultActor.MovableDefaultActor;

public class NewPlayer extends MovableDefaultActor {
    public NewPlayer() {
        super(NewPlayerConstants.position, NewPlayerConstants.checkboxArray, NewPlayerConstants.textureSrc, NewPlayerConstants.textureData, NewPlayerConstants.dim);
    }
}
