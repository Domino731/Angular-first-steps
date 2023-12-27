package game.actorSets;

import constants.actors.EnvironmentActor.EnvironmentActor;
import engine.fonts.actionCollision.actorsManager.ActorsManager;
import utils.vectors.Vector;

public class AllTrees {
    public AllTrees(ActorsManager actorsManager) {
        actorsManager.addActor(new EnvironmentActor("maple", new Vector<>(0, 0), actorsManager, (byte) 0));
        actorsManager.addActor(new EnvironmentActor("maple", new Vector<>(2, 0), actorsManager, (byte) 1));
        actorsManager.addActor(new EnvironmentActor("maple", new Vector<>(4, 0), actorsManager, (byte) 2));
        actorsManager.addActor(new EnvironmentActor("maple", new Vector<>(6, 0), actorsManager, (byte) 3));
        actorsManager.addActor(new EnvironmentActor("maple", new Vector<>(8, 0), actorsManager));

        actorsManager.addActor(new EnvironmentActor("mahogany", new Vector<>(10, 0), actorsManager, (byte) 0));
        actorsManager.addActor(new EnvironmentActor("mahogany", new Vector<>(12, 0), actorsManager, (byte) 1));
        actorsManager.addActor(new EnvironmentActor("mahogany", new Vector<>(14, 0), actorsManager, (byte) 2));
        actorsManager.addActor(new EnvironmentActor("mahogany", new Vector<>(16, 0), actorsManager, (byte) 3));
        actorsManager.addActor(new EnvironmentActor("mahogany", new Vector<>(18, 0), actorsManager));


        actorsManager.addActor(new EnvironmentActor("mushroom", new Vector<>(20, 0), actorsManager, (byte) 0));
        actorsManager.addActor(new EnvironmentActor("mushroom", new Vector<>(22, 0), actorsManager, (byte) 1));
        actorsManager.addActor(new EnvironmentActor("mushroom", new Vector<>(24, 0), actorsManager, (byte) 2));
        actorsManager.addActor(new EnvironmentActor("mushroom", new Vector<>(26, 0), actorsManager, (byte) 3));
        actorsManager.addActor(new EnvironmentActor("mushroom", new Vector<>(28, 0), actorsManager));
//
        actorsManager.addActor(new EnvironmentActor("oak", new Vector<>(30, 0), actorsManager, (byte) 0));
        actorsManager.addActor(new EnvironmentActor("oak", new Vector<>(32, 0), actorsManager, (byte) 1));
        actorsManager.addActor(new EnvironmentActor("oak", new Vector<>(34, 0), actorsManager, (byte) 2));
        actorsManager.addActor(new EnvironmentActor("oak", new Vector<>(36, 0), actorsManager, (byte) 3));
        actorsManager.addActor(new EnvironmentActor("oak", new Vector<>(38, 0), actorsManager));
//
        actorsManager.addActor(new EnvironmentActor("pine", new Vector<>(40, 0), actorsManager, (byte) 0));
        actorsManager.addActor(new EnvironmentActor("pine", new Vector<>(42, 0), actorsManager, (byte) 1));
        actorsManager.addActor(new EnvironmentActor("pine", new Vector<>(44, 0), actorsManager, (byte) 2));
        actorsManager.addActor(new EnvironmentActor("pine", new Vector<>(46, 0), actorsManager, (byte) 3));
        actorsManager.addActor(new EnvironmentActor("pine", new Vector<>(48, 0), actorsManager));
    }
}
