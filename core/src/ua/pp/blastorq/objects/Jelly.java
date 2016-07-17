package ua.pp.blastorq.objects;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by serhij on 12.07.2016.
 */
public class Jelly  {
    private Vector2 position , velosity, acceleration;
    int width ,height;

    public Jelly(float x ,float y ,int width ,int height) {
        this.height = height;
        this.width = width;
        position = new Vector2(x ,y);
        velosity = new Vector2(0 ,0);
        acceleration = new Vector2(0 ,460);
    }
    public void onClick(){
        velosity.y = -140;
    }
    public void  update(float delta){
        velosity.add(acceleration.cpy().scl(delta));
        if(velosity.y >200){
            velosity.y = 200;
        }
        position.add(velosity.cpy().scl(delta));
    }
    public void stop(){
        velosity.y = 0;
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
