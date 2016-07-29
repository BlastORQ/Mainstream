package ua.pp.blastorq.mainstream.objects;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by serhij on 26.07.2016.
 */
public class Moving {
    protected Vector2 position;
    protected Vector2 velosity;
    protected float width;
    protected float height;
    protected boolean isMovingLeft;

    public Moving(float x, float y, float width, float height ,float movSpeed) {
        this.width = width;
        this.height = height;
        position = new Vector2(x ,y);
        velosity = new Vector2(movSpeed ,0);
        isMovingLeft = false;
    }
    public void update(float delta){
        position.add(velosity.cpy().scl(delta));
        if(position.x + width <  0){
            isMovingLeft = true;
        }

    }
    public void reset(float newX){
        position.x = newX;
        isMovingLeft = false;
    }
    public void stop(){
        velosity.x = 0;
    }

    public boolean isScrolledLeft(){
        return isMovingLeft;
    }
    public float getX(){
        return position.x;
    }
    public float getY(){
        return position.y;
    }
    public float getTailX(){
        return position.x + width;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}

