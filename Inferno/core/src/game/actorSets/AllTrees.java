package game.actorSets;

import engine.fonts.actionCollision.actorsManager.ActorsManager;
import game.actors.TreeActor.TreeActor;
import utils.vectors.Vector;

public class AllTrees {
    public AllTrees(ActorsManager actorsManager) {
        actorsManager.addActor(new TreeActor("maple", new Vector<>(0, 0), actorsManager, (byte) 0));
        actorsManager.addActor(new TreeActor("maple", new Vector<>(2, 0), actorsManager, (byte) 1));
        actorsManager.addActor(new TreeActor("maple", new Vector<>(4, 0), actorsManager, (byte) 2));
        actorsManager.addActor(new TreeActor("maple", new Vector<>(6, 0), actorsManager, (byte) 3));
        actorsManager.addActor(new TreeActor("maple", new Vector<>(8, 0), actorsManager));

        actorsManager.addActor(new TreeActor("mahogany", new Vector<>(10, 0), actorsManager, (byte) 0));
        actorsManager.addActor(new TreeActor("mahogany", new Vector<>(12, 0), actorsManager, (byte) 1));
        actorsManager.addActor(new TreeActor("mahogany", new Vector<>(14, 0), actorsManager, (byte) 2));
        actorsManager.addActor(new TreeActor("mahogany", new Vector<>(16, 0), actorsManager, (byte) 3));
        actorsManager.addActor(new TreeActor("mahogany", new Vector<>(18, 0), actorsManager));


        actorsManager.addActor(new TreeActor("mushroom", new Vector<>(20, 0), actorsManager, (byte) 0));
        actorsManager.addActor(new TreeActor("mushroom", new Vector<>(22, 0), actorsManager, (byte) 1));
        actorsManager.addActor(new TreeActor("mushroom", new Vector<>(24, 0), actorsManager, (byte) 2));
        actorsManager.addActor(new TreeActor("mushroom", new Vector<>(26, 0), actorsManager, (byte) 3));
        actorsManager.addActor(new TreeActor("mushroom", new Vector<>(28, 0), actorsManager));
//
        actorsManager.addActor(new TreeActor("oak", new Vector<>(30, 0), actorsManager, (byte) 0));
        actorsManager.addActor(new TreeActor("oak", new Vector<>(32, 0), actorsManager, (byte) 1));
        actorsManager.addActor(new TreeActor("oak", new Vector<>(34, 0), actorsManager, (byte) 2));
        actorsManager.addActor(new TreeActor("oak", new Vector<>(36, 0), actorsManager, (byte) 3));
        actorsManager.addActor(new TreeActor("oak", new Vector<>(38, 0), actorsManager));
//
        actorsManager.addActor(new TreeActor("pine", new Vector<>(40, 0), actorsManager, (byte) 0));
        actorsManager.addActor(new TreeActor("pine", new Vector<>(42, 0), actorsManager, (byte) 1));
        actorsManager.addActor(new TreeActor("pine", new Vector<>(44, 0), actorsManager, (byte) 2));
        actorsManager.addActor(new TreeActor("pine", new Vector<>(46, 0), actorsManager, (byte) 3));
        actorsManager.addActor(new TreeActor("pine", new Vector<>(48, 0), actorsManager));

        actorsManager.addActor(new TreeActor("blue_jazz", new Vector<>(0, 5), actorsManager, (byte) 0));
        actorsManager.addActor(new TreeActor("blue_jazz", new Vector<>(2, 5), actorsManager, (byte) 1));
        actorsManager.addActor(new TreeActor("blue_jazz", new Vector<>(4, 5), actorsManager, (byte) 2));
        actorsManager.addActor(new TreeActor("blue_jazz", new Vector<>(6, 5), actorsManager, (byte) 3));
        actorsManager.addActor(new TreeActor("blue_jazz", new Vector<>(8, 5), actorsManager, (byte) 4));
        actorsManager.addActor(new TreeActor("blue_jazz", new Vector<>(10, 5), actorsManager, (byte) 5));

        actorsManager.addActor(new TreeActor("coffee_bean", new Vector<>(0, 7), actorsManager, (byte) 0));
        actorsManager.addActor(new TreeActor("coffee_bean", new Vector<>(2, 7), actorsManager, (byte) 1));
        actorsManager.addActor(new TreeActor("coffee_bean", new Vector<>(4, 7), actorsManager, (byte) 2));
        actorsManager.addActor(new TreeActor("coffee_bean", new Vector<>(6, 7), actorsManager, (byte) 3));
        actorsManager.addActor(new TreeActor("coffee_bean", new Vector<>(8, 7), actorsManager, (byte) 4));
        actorsManager.addActor(new TreeActor("coffee_bean", new Vector<>(10, 7), actorsManager, (byte) 5));
        actorsManager.addActor(new TreeActor("coffee_bean", new Vector<>(12, 7), actorsManager, (byte) 6));

        actorsManager.addActor(new TreeActor("garlic", new Vector<>(0, 9), actorsManager, (byte) 0));
        actorsManager.addActor(new TreeActor("garlic", new Vector<>(2, 9), actorsManager, (byte) 1));
        actorsManager.addActor(new TreeActor("garlic", new Vector<>(4, 9), actorsManager, (byte) 2));
        actorsManager.addActor(new TreeActor("garlic", new Vector<>(6, 9), actorsManager, (byte) 3));
        actorsManager.addActor(new TreeActor("garlic", new Vector<>(8, 9), actorsManager, (byte) 4));
    }
}
