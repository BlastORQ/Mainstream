package ua.pp.blastorq.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;

import ua.pp.blastorq.game.GameRender;
import ua.pp.blastorq.game.GameWorld;
import ua.pp.blastorq.ui.InputHandler;

/**
 * Created by serhij on 12.07.2016.
 */
public class GameScreen implements Screen{
private GameWorld world;
    private GameRender renderer;
    public GameScreen() {
            float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth =  136;
        float gameHeight =  screenHeight / (screenWidth/gameWidth);
        int midpointY = (int) (gameHeight /2);
        int midpointX = (int) (gameWidth /2);

                world = new GameWorld(midpointX ,midpointY);
        renderer = new GameRender(world ,(int)gameHeight ,midpointX ,midpointY);
        Gdx.input.setInputProcessor(new InputHandler(world.getFly()));
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
