package ua.pp.blastorq.game;

import com.badlogic.gdx.Gdx;

import ua.pp.blastorq.objects.Jelly;

/**
 * Created by serhij on 12.07.2016.
 */
public class GameWorld {
    Jelly fly;
    int midpointX ,midpointY;

    public Jelly getFly() {
        return fly;
    }

    public GameWorld(int midpointX, int midpointY) {
        this.midpointX = midpointX;
        this.midpointY = midpointY;
        fly = new Jelly(33 ,midpointY - 5 ,64 ,64);
    }

    public void update(float delta){
        fly.update(delta);
    }
}
