package ua.pp.blastorq.mainstream.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

import ua.pp.blastorq.mainstream.objects.Fly;
import ua.pp.blastorq.mainstream.objects.MovHandler;
import ua.pp.blastorq.mainstream.screens.GameScreen;

/**
 * Created by serhij on 25.07.2016.
 */
public class GameWorld {
    int midPointX;
    int midPointY;
    Fly fly;
    MovHandler movHandler;
  //  private Rectangle ground;
    public GameWorld(int midPointX, int midPointY) {
        this.midPointX = midPointX;
        this.midPointY = midPointY;
        fly = new Fly(40 ,midPointY + 5 ,17 ,17);
        movHandler = new MovHandler(this ,midPointY + 66);
//        ground  = new Rectangle(0 ,0 , new GameScreen().getGameWidth() ,11);
    }

    public void update(float delta){
        if(movHandler.collides(fly) && fly.isAlive()){
           // fly.die();
           // fly.clie();
           //movHandler.stop();
        }
       /* if(fly.getRectangle().overlaps(ground)){
            if(fly.isAlive){
                fly.die();
            }
            movHandler.stop();
            fly.clie();
        }*/
        fly.update(delta);
        movHandler.update(delta);
    }

    public Fly getFly() {
        return fly;
    }

    public MovHandler getMovHandler() {
        return movHandler;
    }
}
