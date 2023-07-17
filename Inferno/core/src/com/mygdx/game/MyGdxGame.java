package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.ScreenUtils;
import levelManager.LevelManager;
import screen.PlayScreen;
import spritesManager.SpritesManager;

public class MyGdxGame extends Game {
	public SpriteBatch batch;
	Texture img;
	TmxMapLoader mapLoader;
    LevelManager levelManager;
	TextureRegion customTexture;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		mapLoader = new TmxMapLoader();
		levelManager  = new LevelManager();
		customTexture = SpritesManager.test();
		setScreen(new PlayScreen(this));

	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
