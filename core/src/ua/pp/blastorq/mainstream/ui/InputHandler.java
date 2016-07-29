package ua.pp.blastorq.mainstream.ui;

import com.badlogic.gdx.InputProcessor;

import ua.pp.blastorq.mainstream.game.GameWorld;
import ua.pp.blastorq.mainstream.objects.Fly;

/**
 * Created by serhij on 25.07.2016.
 */
public class InputHandler implements InputProcessor
{
    Fly fly;
    public InputHandler(GameWorld world) {
        fly = world.getFly();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        fly.onClick();
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
