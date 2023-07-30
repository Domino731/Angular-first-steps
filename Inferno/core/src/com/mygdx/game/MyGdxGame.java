package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import levelManager.LevelManager;
import screens.PlayScreen;
import spritesManager.SpritesManager;

public class MyGdxGame extends Game {
    public SpriteBatch batch;
    public ShapeRenderer sr;
    public boolean showCheckboxes;
    Texture img;
    TmxMapLoader mapLoader;
    LevelManager levelManager;
    TextureRegion customTexture;


    @Override
    public void create() {
        batch = new SpriteBatch();
        sr = new ShapeRenderer();
        img = new Texture("badlogic.jpg");
        mapLoader = new TmxMapLoader();
        levelManager = new LevelManager();
        customTexture = SpritesManager.test();
        showCheckboxes = true;
        setScreen(new PlayScreen(this));

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        sr.dispose();
    }
}
