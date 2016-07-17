package ua.pp.blastorq.objects;

import java.util.Random;

public class Web extends Moving {
    Random r;
    private float groundY;
    public Web(float x, float y, float width, float height, float movSpeed ,float groundY) {
        super(x, y, width, height, movSpeed);
        r = new Random();
        this.groundY = groundY;
    }

    @Override
    public void reset(float newX) {
        height = r.nextInt(90) + 15;
        super.reset(newX);
    }
}
