package engine.actorsManager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import engine.actors.DefaultActor;
import environment.trees.ExampleTree;
import game.entities.player.NewPlayer;

import java.util.ArrayList;

public class ActorsManager {
    private ArrayList<DefaultActor> allActors = new ArrayList<>();
    public NewPlayer player = new NewPlayer();

    public ActorsManager() {
        ExampleTree exampleTree = new ExampleTree();

        allActors.add(player);
        allActors.add(exampleTree);
    }

    public void draw(SpriteBatch sb) {
        for (DefaultActor actor : allActors) {
            actor.draw(sb);
        }
    }
}
