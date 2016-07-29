package ua.pp.blastorq.mainstream.objects;

import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

/**
 * Created by serhij on 27.07.2016.
 */
public class Web extends Moving {
    Random r;
    public static final int GAP = 45;
    float groundY;
    Rectangle webup ,webdown;
    public Web(float x, float y, float width, float height, float movSpeed ,float groundY) {
        super(x, y, width, height, movSpeed);
        r = new Random();
        this.groundY = groundY;
        webdown = new Rectangle();
        webup = new Rectangle();
    }

    @Override
    public void reset(float newX) {
        super.reset(newX);
        height = r.nextInt(90) + 15;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        webup.set(position.x ,position.y ,width,height);
        webdown.set(position.x ,position.y + height + GAP ,width ,groundY - (position.y + height + GAP));

    }
    public boolean collides(Fly fly){
        if(position.x < fly.getX() + fly.getWidth()){
            return fly.getRectangle().overlaps(webup) || fly.getRectangle().overlaps(webdown);
        }
        return false;
    }
}
