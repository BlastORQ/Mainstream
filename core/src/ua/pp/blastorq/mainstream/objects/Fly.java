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
    private float GROUND_LIMIT = 50;

    public Fly(float x, float y, float width, float height) {
        this.width = width;
        this.height = height;
        position = new Vector2(x ,y);
        velosity = new Vector2(0 ,0);
        acceleration = new Vector2(0 ,230);
        rectangle = new Rectangle();
        isAlive = true;
    }
    public void die(){
        isAlive = false;
        velosity.y = 0;
    }
    public void onClick(){
        if(isAlive) {
            velosity.y = -55;
        }
    }
    public void clie(){
        acceleration.y = 0;
    }
    public void update(float delta){
        velosity.add(acceleration.cpy().scl(delta/2));
        if(velosity.y >GROUND_LIMIT){
            velosity.y = GROUND_LIMIT;
        }
        if(position.y > gameHeight-24){
            position.y = gameHeight-24;
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

    public void setGROUND_LIMIT(float GROUND_LIMIT) {
        this.GROUND_LIMIT = GROUND_LIMIT;
    }
}
