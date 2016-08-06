package ua.pp.blastorq.mainstream.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by serhij on 25.07.2016.
 */
public class Fly {
    public Vector2 position;
    public Vector2 velosity;
    public Vector2 acceleration;
    float  width ,height;
    Rectangle rectangle;
    public boolean isAlive;
    float screenWidth = Gdx.graphics.getWidth();
    float screenHeight = Gdx.graphics.getHeight();
    float gameHeight = 136;
    public Fly(float x, float y, float width, float height) {

        this.width = width;
        this.height = height;
        position = new Vector2(x ,y);
        velosity = new Vector2(0 ,0);
        acceleration = new Vector2(0 ,460);
        rectangle = new Rectangle();
        isAlive = true;
    }
    public void die(){
        isAlive = false;
        velosity.y = 0;
    }
    public void onClick(){
        if(isAlive) {
<<<<<<< HEAD
            velosity.y = -55;
=======
            velosity.y = -140;
        }
>>>>>>> parent of 1ab4bde... шось зролбив
        }
    }
    public void clie(){
        acceleration.y = 0;
    }
    public void update(float delta){
        velosity.add(acceleration.cpy().scl(delta/2));
        if(velosity.y >50){
            velosity.y = 50;
        }
        if(position.y > gameHeight-20){
            position.y = gameHeight-20;
        }
        if(position.y < 0){
            position.y = 0;
        }
        position.add(velosity.cpy().scl(delta));
        rectangle.set(position.x ,position.y ,width ,height);
    }
    public float getX(){
        return position.x;
    }
    public float getY(){
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
