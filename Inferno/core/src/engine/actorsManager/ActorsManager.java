package engine.actorsManager;

import engine.actors.DefaultActor;
import game.entities.player.NewPlayer;

import java.util.HashMap;

public class ActorsManager {
    private HashMap<String, DefaultActor> allActors = new HashMap<>();
    private NewPlayer player = new NewPlayer();

    public ActorsManager() {
        allActors.put("PLAYER", player);
    }
}
