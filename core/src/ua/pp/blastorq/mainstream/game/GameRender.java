package ua.pp.blastorq.mainstream.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ua.pp.blastorq.mainstream.objects.Fly;
import ua.pp.blastorq.mainstream.objects.Grass;
import ua.pp.blastorq.mainstream.objects.MovHandler;
import ua.pp.blastorq.mainstream.objects.Web;

/**
 * Created by serhij on 25.07.2016.
 */
public class GameRender {
    GameWorld mWorld;
    OrthographicCamera camera;
    public Sprite actor ,background;
    SpriteBatch batch;
    float gameWidth;
    Fly fly;
    MovHandler movHandler;
    Grass frontGrass ,backGrass;
    Web web1 ,web2 ,web3 ,web4 ,web5 ,web6;
    Sprite webup ,webdown, grass;

    public GameRender(GameWorld world ,float gameWidth){
        mWorld = world;
       initGameObjects();
        this.gameWidth = gameWidth;
         camera = new OrthographicCamera();
        camera.setToOrtho(true ,gameWidth ,136);
        batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);
        actor = new Sprite(new Texture("actor.png"));
        actor.flip(false ,true);
        initAssets();
        background = new Sprite(new Texture("logo.png"));


    }
    public void initGameObjects(){
        fly = mWorld.getFly();
        movHandler = mWorld.getMovHandler();
        frontGrass = movHandler.getFrontGrass();
        backGrass = movHandler.getBackGrass();
        web1 = movHandler.getWeb1();
        web2 = movHandler.getWeb2();
        web3 = movHandler.getWeb3();
        web4 = movHandler.getWeb4();
        web5 = movHandler.getWeb5();
        web6 = movHandler.getWeb6();
    }
    public void initAssets(){
        webup = new Sprite(new Texture("webup.png"));
        webdown = new Sprite(new Texture("webdown.png"));
        grass = new Sprite(new Texture("grass.png"));
        webup.flip(false ,true);
        webdown.flip(false , true);
        grass.flip(false ,true);

    }
    public void render(float delta){
        batch.begin();
        batch.disableBlending();
        batch.draw(background ,0 ,0 ,gameWidth ,136);
        batch.enableBlending();
        drawFly();
        drawWeb();
        drawGrass();
        batch.end();
    }
    public void drawFly(){
        batch.draw(actor ,fly.getX() ,fly.getY() ,fly.getWidth() , fly.getHeight());
    }
    public void drawWeb(){
        batch.draw(webup ,web1.getX() ,web1.getY() ,web1.getWidth() ,web1.getHeight());
        batch.draw(webdown ,web1.getX() ,web1.getY() + web1.getHeight() + 45 ,web1.getWidth() ,mWorld.midPointY + 66 - (web1.getHeight() + 45) + 15);
        batch.draw(webup ,web2.getX() ,web2.getY() ,web2.getWidth() ,web2.getHeight());
        batch.draw(webdown ,web2.getX() ,web2.getY() + web2.getHeight() + 45 ,web2.getWidth() ,mWorld.midPointY + 66 - (web2.getHeight() + 45) + 15);
        batch.draw(webup ,web3.getX() ,web3.getY() ,web3.getWidth() ,web3.getHeight());
        batch.draw(webdown ,web3.getX() ,web3.getY() + web3.getHeight() + 45 ,web3.getWidth() ,mWorld.midPointY + 66 - (web3.getHeight() + 45) + 15);
        batch.draw(webup ,web4.getX() ,web4.getY() ,web4.getWidth() ,web4.getHeight());
        batch.draw(webdown ,web4.getX() ,web4.getY() + web4.getHeight() + 45 ,web4.getWidth() ,mWorld.midPointY + 66 - (web4.getHeight() + 45) + 15);
        batch.draw(webup ,web5.getX() ,web5.getY() ,web5.getWidth() ,web5.getHeight());
        batch.draw(webdown ,web5.getX() ,web5.getY() + web5.getHeight() + 45 ,web5.getWidth() ,mWorld.midPointY + 66 - (web5.getHeight() + 45) + 15);
        batch.draw(webup ,web6.getX() ,web6.getY() ,web6.getWidth() ,web6.getHeight());
        batch.draw(webdown ,web6.getX() ,web6.getY() + web6.getHeight() + 45 ,web6.getWidth() ,mWorld.midPointY + 66 - (web6.getHeight() + 45) + 15);
    }
    public void drawGrass(){
        batch.draw(grass ,frontGrass.getX() , frontGrass.getY() ,frontGrass.getWidth() ,frontGrass.getHeight());
        batch.draw(grass ,backGrass.getX() ,backGrass.getY() ,backGrass.getWidth() ,backGrass.getHeight());
    }

}
