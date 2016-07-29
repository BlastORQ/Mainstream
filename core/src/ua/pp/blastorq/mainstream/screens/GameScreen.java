package ua.pp.blastorq.mainstream.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import ua.pp.blastorq.mainstream.game.GameRender;
import ua.pp.blastorq.mainstream.game.GameWorld;
import ua.pp.blastorq.mainstream.ui.InputHandler;

/**
 * Created by serhij on 25.07.2016.
 */
public class GameScreen implements Screen {
    GameWorld world;
    GameRender renderer;
    float screenWidth = Gdx.graphics.getWidth();
    float screenHeight = Gdx.graphics.getHeight();
    float gameHeight = 136;

    public float getGameWidth() {
        return gameWidth;
    }

    public float gameWidth = screenWidth / (screenHeight / gameHeight);
    int midPointX = (int)gameWidth /2;
    int midPointY = (int) gameHeight /2;
    public GameScreen() {

        world = new GameWorld(midPointX ,midPointY);
        renderer = new GameRender(world ,gameWidth);
        Gdx.input.setInputProcessor(new InputHandler(world));

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
    world.update(delta);
        renderer.render(delta);

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

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
