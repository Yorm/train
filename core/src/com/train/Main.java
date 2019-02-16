package com.train;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.train.view.*;

public class Main extends Game {
	private LoadingScreen loadingScreen;
	private SettingsScreen settingsScreen;
	private MenuScreen menuScreen;
	private MainScreen mainScreen;
	private EndScreen endScreen;
	private AboutScreen aboutScreen;

	public final static int MENU = 0;
	public final static int SETTINGS = 1;
	public final static int APPLICATION = 2;
	public final static int ENDGAME = 3;
	public final static int ABOUT = 4;
	private AppSettings settings;
	Texture playerTex;
	Texture background;
	Music music_kino;

	Rectangle playerRec;


	OrthographicCamera camera;

	SpriteBatch batch;

	int width,height;
	int speed;
	public Main(int width,int height){
		this.width = width;
		this.height = height;
		this.speed = 400;

	}
	@Override
	public void create () {
		settings = new AppSettings();
		loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);

		/*camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		playerRec = new Rectangle();
		playerRec.x = this.width / 2 - 64 / 2;
		playerRec.y = 20;
		playerRec.width = 64;
		playerRec.height = 64;

		batch = new SpriteBatch();

		playerTex = new Texture(Gdx.files.internal("gg.png"));
		background = new Texture(Gdx.files.internal("bg.png"));

		music_kino = Gdx.audio.newMusic(Gdx.files.internal("train_mn.mp3"));

		music_kino.setLooping(true);*/
		//music_kino.play();
	}

	@Override
	public void render () {
		super.render(); // important! way render method calls

		/*Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(background, 0, 0);
		batch.draw(playerTex, playerRec.x, playerRec.y);
		batch.end();

		if(Gdx.input.isKeyPressed(Keys.LEFT)) playerRec.x -= this.speed * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) playerRec.x += this.speed * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Keys.DOWN)) playerRec.y -= this.speed * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Keys.UP)) playerRec.y += this.speed * Gdx.graphics.getDeltaTime();

		if(playerRec.x < 0) playerRec.x = 0;
		if(playerRec.x > this.width - 64) playerRec.x = this.width - 64;
		if(playerRec.y > this.height - 64) playerRec.y = this.height - 64;
		if(playerRec.y < 0) playerRec.y = 0;*/
	}
	
	@Override
	public void dispose () {
		/*playerTex.dispose();
		batch.dispose();*/
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}


	@Override
	public void resume() {
	}

	public void changeScreen(int screen){
		switch(screen){
			case MENU:
				if(menuScreen == null) menuScreen = new MenuScreen(this);
				this.setScreen(menuScreen);
				break;
			case SETTINGS:
				if(settingsScreen == null) settingsScreen = new SettingsScreen(this);
				this.setScreen(settingsScreen);
				break;
			case APPLICATION:
				if(mainScreen == null) mainScreen = new MainScreen(this);
				this.setScreen(mainScreen);
				break;
			case ENDGAME:
				if(endScreen == null) endScreen = new EndScreen(this);
				this.setScreen(endScreen);
				break;
			case ABOUT:
				if(aboutScreen == null) aboutScreen = new AboutScreen(this);
				this.setScreen(aboutScreen);
				break;
		}
	}

	public AppSettings getSettings() {
		return this.settings;
	}
}
