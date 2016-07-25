package ua.pp.blastorq.ui;

import com.badlogic.gdx.InputProcessor;

import ua.pp.blastorq.objects.Jelly;

/**
 * Created by serhij on 12.07.2016.
 */
public class InputHandler implements InputProcessor {
   Jelly fly;
    public static boolean isonclick = false;

    public InputHandler(Jelly myfly) {
       fly = myfly;
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
        if(!isonclick) {
            fly.onClick();
        }
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
