package ua.pp.blastorq.objects;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by serhij on 16.07.2016.
 */
public class Moving {
    protected float width ,height;
    protected Vector2 position;
    protected Vector2 velosity;
    boolean isMovingLeft;
    public Moving(float x ,float y ,float width, float height , float movSpeed) {
        position = new Vector2(x ,y);
        velosity = new Vector2(movSpeed, 0);
        this.width = width;
        this.height = height;
        isMovingLeft = false;
    }
    public void update(float delta){
        position.add(velosity.cpy().scl(delta));
        if(position.x + width < 0){
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
        return  isMovingLeft;
    }
    public float getTailX(){
        return position.x + width;
    }

    public float getX() {
        return position.x;

    }
    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }
        public float getHeight(){
            return  height;
        }
    public float getTailY(){
        return position.y + height;
    }
}
