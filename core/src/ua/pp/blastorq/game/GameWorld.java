package ua.pp.blastorq.game;

import ua.pp.blastorq.objects.Jelly;
import ua.pp.blastorq.objects.MovHandler;

/**
 * Created by serhij on 20.07.2016.
 */
public class GameWorld {
    Jelly fly;
    MovHandler movhandler;
    boolean is = false;
    public GameWorld(int midpointX, int midpointY) {
        fly = new Jelly(30 , midpointY  ,25 ,25);
        movhandler = new MovHandler(this ,0);
        is = fly.isNotAlive;
    }

    public MovHandler getMovhandler() {
        return movhandler;
    }

    public void  update(float delta){
        fly.update(delta);
        if(!is) {
            movhandler.update(delta);
        }
    }
    public Jelly getFly() {
        return fly;
    }
}
