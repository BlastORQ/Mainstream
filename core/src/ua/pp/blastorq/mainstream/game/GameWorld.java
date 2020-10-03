package ua.pp.blastorq.mainstream.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import ua.pp.blastorq.mainstream.objects.Fly;
import ua.pp.blastorq.mainstream.objects.MovHandler;
import ua.pp.blastorq.mainstream.screens.GameScreen;
import ua.pp.blastorq.mainstream.utils.BodyEditorLoader;

/**
 * Created by serhij on 25.07.2016.
 */
public class GameWorld {
    public final boolean DEMO = false;//Це міняй якщо не треба реагувати на зіткнення
    private int midPointX;
    int midPointY;
    Fly fly;
    private MovHandler movHandler;
    World _world;
    Body grassModel;

    public GameWorld(int midPointX, int midPointY) {
        this.midPointX = midPointX;
        this.midPointY = midPointY;
        fly = new Fly(40 ,midPointY + 5 ,17 ,17);


        _world = new World(new Vector2(0, -10), true);
        BodyEditorLoader loader = new BodyEditorLoader(Gdx.files.internal("grass.json"));
        BodyDef bd = new BodyDef();
        bd.type = BodyDef.BodyType.DynamicBody;

        FixtureDef fd = new FixtureDef();
        fd.density = 1;
        fd.friction = 0.5f;
        fd.restitution = 0.3f;

        grassModel = _world.createBody(bd);
        loader.attachFixture(grassModel, "Name", fd, 1);
        movHandler = new MovHandler(this ,midPointY + 66, grassModel);
    }

    public void update(float delta){
        if(movHandler.collides(fly) && fly.isAlive() && !DEMO){
            fly.die();
            fly.clie();
            movHandler.stop();
        }
        //fly.setGROUND_LIMIT(grassModel.getPosition().y);
        fly.update(delta);
        movHandler.update(delta);
    }

    public Fly getFly() {
        return fly;
    }

    public MovHandler getMovHandler() {
        return movHandler;
    }
}
