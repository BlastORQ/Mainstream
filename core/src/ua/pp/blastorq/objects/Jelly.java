package ua.pp.blastorq.objects;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ua.pp.blastorq.game.GameRender;

/**
 * Created by serhij on 12.07.2016.
 */
public class Jelly  {
    public static  Vector2 position , velosity, acceleration;
    public boolean isNotAlive = false;
    int width ,height;
    Rectangle flyr;
    public void setY(int newy) {
       position.y = newy;
    }


    public Rectangle getFlyr() {

        return flyr;
    }

    public Jelly(float x , float y , int width , int height) {
        this.height = height;
        this.width = width;
        position = new Vector2(x ,y);

        velosity = new Vector2(0 ,0);
        acceleration = new Vector2(0 ,460);

        flyr = new Rectangle();
    }
    public void onClick(){
        velosity.y = -140;
    }
    public void  update(float delta){
        if(!isNotAlive){


            velosity.add(acceleration.cpy().scl(delta));
            if (velosity.y > 200) {
                velosity.y = 200;
            }
            position.add(velosity.cpy().scl(delta));
            flyr.x = position.x;
            flyr.y = position.y;
            flyr.width = width;
            flyr.height = height;
        }else{
            stop();
        }
    }
    public static void stop(){
        Jelly.velosity.y = 0;
        Jelly.acceleration.y = 0;
        GameRender.web2.stop();
        GameRender.web1.stop();
        GameRender.web3.stop();

    }
    public int getWidth() {
        return width;
    }
    public float getX(){
        return position.x;
    }
    public float getY(){
        return position.y;
    }
    public int getHeight() {
        return height;
    }
}
