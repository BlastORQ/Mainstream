package ua.pp.blastorq.objects;

import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

import ua.pp.blastorq.game.GameRender;

public class Web extends Moving {
    Random r;
    private float groundY;
    public static final int GAP = 45;
    Rectangle webUp ,webDown;
    public Web(float x, float y, float width, float height, float movSpeed ,float groundY) {
        super(x, y, width, height, movSpeed);
        r = new Random();
        this.groundY = groundY;
        webDown = new Rectangle();
        webUp = new Rectangle();
    }

    @Override
    public void reset(float newX) {
        height = r.nextInt(90) + 15;
        super.reset(newX);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        webUp.set(position.x  ,position.y ,width ,height);

        webDown.set(position.x  ,position.y  + height + GAP ,width ,height);
    }
    public boolean collides(Jelly fly){
        if(position.x < fly.getX() + fly.getWidth()){
            return fly.getFlyr().overlaps(webUp) || fly.getFlyr().overlaps(webDown);
        }
        return false;
    }
}
