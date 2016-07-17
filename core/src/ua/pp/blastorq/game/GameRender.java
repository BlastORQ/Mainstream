package ua.pp.blastorq.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.sun.javafx.font.directwrite.RECT;

import ua.pp.blastorq.objects.Grass;
import ua.pp.blastorq.objects.Jelly;
import ua.pp.blastorq.objects.MovHandler;
import ua.pp.blastorq.objects.Web;

/**
 * Created by serhij on 12.07.2016.
 */
    public class GameRender {
    private GameWorld mWorld;
int midpointY ,midpointX;
    Grass frontGrass ,backGrass;
    Rectangle webupr1 ,webupr2, webupr3 , webdownr1, webdownr2 ,webdown3;
    Web web1 ,web2 ,web3;
    SpriteBatch batch;
    Texture logo ,grass;

    MovHandler movHandler;
    Texture flyimage ,webup ,webdown;
Sprite logos ,logosd;
    Jelly fly;
    int gameHeight;

    public int getGameHeight() {
        return gameHeight;
    }

    OrthographicCamera camera;

    public GameRender() {
    }

    public GameRender(GameWorld world, int gameHeight, int midpointX, int midpointY) {
        mWorld = world;

        webup = new Texture("webup.png");
        webdown = new Texture("webdown.png");
        initGameobjects();
        this.midpointX = midpointX;
        logo = new Texture("background.png");
        flyimage = new Texture("badlogic.jpg");
        grass = new Texture("grass.png");
        logos = new Sprite(logo);

        logos.flip(false  , true);
        this.gameHeight = gameHeight;

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
        batch.draw(logos , 0 ,0,136 ,gameHeight);
        batch.enableBlending();
        batch.draw(logosd ,fly.getX() ,fly.getY() ,fly.getWidth() ,fly.getHeight());
        drawGrass();
        drawWeb();
        batch.end();

    }
    public void drawGrass(){
        batch.draw(grass,frontGrass.getX() ,frontGrass.getY() ,frontGrass.getWidth() ,frontGrass.getHeight());
        batch.draw(grass ,backGrass.getX() ,backGrass.getY() ,backGrass.getWidth() ,backGrass.getHeight());
    }
    public void drawWeb(){
        batch.draw(webup ,web1.getX() ,web1.getY() ,web1.getWidth() ,web1.getHeight());
        batch.draw(webdown ,web1.getX() ,web1.getY() + web1.getHeight() + 45,web1.getWidth()  ,midpointY + 66 -(web1.getHeight() + 45) );
        batch.draw(webup ,web2.getX() ,web2.getY() ,web2.getWidth() ,web2.getHeight());
        batch.draw(webdown ,web2.getX() ,web2.getY() + web2.getHeight() + 45,web2.getWidth()  ,midpointY + 66 -(web2.getHeight() + 45) );
        batch.draw(webup ,web3.getX() ,web3.getY() ,web3.getWidth() ,web3.getHeight());
        batch.draw(webdown ,web3.getX() ,web3.getY() + web3.getHeight() + 45,web3.getWidth()  ,midpointY + 66 -(web1.getHeight() + 45) );
    }
    public void initGameobjects(){
        fly = mWorld.getFly();
        movHandler = mWorld.getMovHandler();
        frontGrass = movHandler.getFrontGrass();
        backGrass = movHandler.getBackGrass();
        web1 = movHandler.getWeb1();
        web2 = movHandler.getWeb2();
        web3 = movHandler.getWeb3();

    }

}
