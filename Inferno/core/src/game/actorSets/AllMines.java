package game.actorSets;

import engine.fonts.actionCollision.actorsManager.ActorsManager;
import game.actors.MineActor.MineActor;

public class AllMines {
    public AllMines(ActorsManager actorsManager) {
        actorsManager.addActor(new MineActor("volcano_rock_large", 0, 0, actorsManager));
        actorsManager.addActor(new MineActor("stone_large", 2, 0, actorsManager));
        actorsManager.addActor(new MineActor("log_large", 4, 0, actorsManager));
        actorsManager.addActor(new MineActor("coal_rock_large", 6, 0, actorsManager));
        actorsManager.addActor(new MineActor("blue_gem_large", 8, 0, actorsManager));
        actorsManager.addActor(new MineActor("blue_gem_active_large", 0, 2, actorsManager));
        actorsManager.addActor(new MineActor("alien_stone_large", 2, 2, actorsManager));

        actorsManager.addActor(new MineActor("amethyst_ore", 10, 0, actorsManager));
        actorsManager.addActor(new MineActor("aquamarine_ore", 12, 0, actorsManager));
        actorsManager.addActor(new MineActor("bone_node", 10, 2, actorsManager));
        actorsManager.addActor(new MineActor("cinder_shard_node", 12, 2, actorsManager));

        actorsManager.addActor(new MineActor("clay_node", 14, 0, actorsManager));
        actorsManager.addActor(new MineActor("copper_node", 16, 0, actorsManager));
        actorsManager.addActor(new MineActor("diamond_ore", 14, 2, actorsManager));
        actorsManager.addActor(new MineActor("emerald_ore", 16, 2, actorsManager));

        actorsManager.addActor(new MineActor("frozen_geode_node", 18, 0, actorsManager));
        actorsManager.addActor(new MineActor("gem_ore", 20, 0, actorsManager));
        actorsManager.addActor(new MineActor("geode_node", 18, 2, actorsManager));
        actorsManager.addActor(new MineActor("gold_node", 20, 2, actorsManager));

        actorsManager.addActor(new MineActor("iridium_node", 22, 0, actorsManager));
        actorsManager.addActor(new MineActor("iron_node", 24, 0, actorsManager));
        actorsManager.addActor(new MineActor("jade_node", 22, 2, actorsManager));
        actorsManager.addActor(new MineActor("magma_geode_node", 24, 2, actorsManager));

        actorsManager.addActor(new MineActor("mussel_node", 26, 0, actorsManager));
        actorsManager.addActor(new MineActor("mystic_stone", 28, 0, actorsManager));
        actorsManager.addActor(new MineActor("omni_geode_node", 26, 2, actorsManager));
        actorsManager.addActor(new MineActor("radioactive_node", 28, 2, actorsManager));

        actorsManager.addActor(new MineActor("ruby_ore", 30, 0, actorsManager));
        actorsManager.addActor(new MineActor("topaz_ore", 32, 0, actorsManager));
    }
}
