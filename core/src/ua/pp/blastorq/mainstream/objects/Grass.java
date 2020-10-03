package ua.pp.blastorq.mainstream.objects;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by serhij on 27.07.2016.
 */
public class Grass extends Moving {

    private Vector2 bodyVector;

    public Grass(float x, float y, float width, float height, float movSpeed, Vector2 bodyVector) {
        super(x, y, width, height, movSpeed);
        this.bodyVector = bodyVector;
    }

    @Override
    public void update(float delta) {

        super.update(delta);
    }
}
