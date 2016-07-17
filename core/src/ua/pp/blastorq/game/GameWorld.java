package ua.pp.blastorq.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

import ua.pp.blastorq.objects.Jelly;
import ua.pp.blastorq.objects.MovHandler;

/**
 * Created by serhij on 12.07.2016.
 */
public class GameWorld {
    Jelly fly;
    int midpointX ,midpointY;
    MovHandler movHandler;
   public  Rectangle flyrectangle;



    public GameWorld(int midpointX, int midpointY) {
        this.midpointX = midpointX;
        this.midpointY = midpointY;
        fly = new Jelly(33 ,midpointY - 5 ,20 ,20);
        movHandler = new MovHandler(this ,midpointY + 66);
        flyrectangle = new Rectangle(fly.getX() ,fly.getY() ,fly.getWidth() ,fly.getHeight());



}

    public void update(float delta){
        fly.update(delta);
        movHandler.update(delta);

    }

    public Jelly getFly() {
        return fly;
    }

    public MovHandler getMovHandler() {
        return movHandler;
    }
}
