package com.train.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.train.Main;

public class AboutScreen implements Screen {
    private Main parent;

    private Stage stage;
    private Skin skin;

    private Label titleLabel;
    //private Label about;
    private Label contacts0;
    private Label contacts1;
    private Label contacts2;
    private Label contacts3;

    public AboutScreen(Main main){
        this.parent = main;
        stage = new Stage(new ScreenViewport());
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        stage.clear ();

        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(false);

        final TextButton backButton = new TextButton("Back", skin);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(Main.MENU);

            }
        });

        titleLabel = new Label( "-About-", skin );
        //about = new Label( "Train game", skin );
        contacts0 = new Label( "If I use your intellectual property", skin );
        contacts1 = new Label( "and you don’t like it", skin );
        contacts2 = new Label( " - please, contact me: walterdive@gmail.com", skin );
        contacts3 = new Label( "_20190216_", skin );

        table.add(titleLabel).colspan(2);
        table.row().pad(10,0,0,10);
        table.add(contacts0).center();
        table.row().pad(10,0,0,10);
        table.add(contacts1).center();
        table.row().pad(10,0,0,10);
        table.add(contacts2).center();
        table.row().pad(30,0,0,10);
        table.add(backButton).colspan(2);
        table.row().pad(300,0,0,0);
        table.add(contacts3).right();

        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}