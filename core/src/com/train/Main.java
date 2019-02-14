package com.train;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.audio.*;


import java.util.Iterator;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Main extends ApplicationAdapter {


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
		camera = new OrthographicCamera();
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

		music_kino.setLooping(true);
		music_kino.play();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
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
		if(playerRec.y < 0) playerRec.y = 0;
	}
	
	@Override
	public void dispose () {
		playerTex.dispose();
		batch.dispose();
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

}
