package ua.pp.blastorq.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by serhij on 12.07.2016.
 */
    public class GameRender {
    private GameWorld mWorld;
int midpointY ,midpointX;
    SpriteBatch batch;
    Texture logo;
    Texture flyimage;
Sprite logos ,logosd;
    OrthographicCamera camera;
    public GameRender(GameWorld world, int gameHeight, int midpointX, int midpointY) {
        mWorld = world;
        this.midpointX = midpointX;
        logo = new Texture("logo.png");
        flyimage = new Texture("badlogic.jpg");

        logos = new Sprite(logo);


        logosd = new Sprite(flyimage);

        logosd.flip(false ,true);
        this.midpointY = midpointY;
        camera = new OrthographicCamera();
        camera.setToOrtho(true ,136 ,gameHeight);
        batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);

    }
    public void render(float delta){
            batch.begin();
        batch.disableBlending();
        batch.draw(logo , 0 ,0,Gdx.graphics.getWidth() ,Gdx.graphics.getHeight());
        batch.draw(logosd ,mWorld.getFly().getX() ,mWorld.getFly().getY() ,mWorld.getFly().getWidth() ,mWorld.getFly().getHeight());
        batch.end();
    }

}
