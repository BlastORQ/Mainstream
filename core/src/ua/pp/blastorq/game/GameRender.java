package ua.pp.blastorq.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import ua.pp.blastorq.Mainstream;
import ua.pp.blastorq.objects.Grass;
import ua.pp.blastorq.objects.Jelly;
import ua.pp.blastorq.objects.MovHandler;
import ua.pp.blastorq.objects.Web;
import ua.pp.blastorq.screen.GameScreen;
import ua.pp.blastorq.ui.InputHandler;

/**
 * Created by serhij on 20.07.2016.
 */
public class GameRender {
    GameWorld mWorld;
    SpriteBatch batch;
    float gameHeight;
    Sprite webups;
    OrthographicCamera camera;
    Jelly fly;
    MovHandler mov;
    Grass frontGrass ,backGrass;
   public static Web web1 ,web2 ,web3;
    Texture  flyimage ,background ,webup ,webdown;
    Sprite flyimages ,b;
    Rectangle web1r ,web2r , web3r ,flyr;
    public GameRender(GameWorld world, int gameHeight, int midpointX, int midpointY) {
        mWorld = world;
        batch = new SpriteBatch();
        webup = new Texture("webup.png");
        webdown = new Texture("webdown.png");
        camera = new OrthographicCamera();
        camera.setToOrtho(true ,136 ,gameHeight);
        batch.setProjectionMatrix(camera.combined);
        this.gameHeight = gameHeight;
        background = new Texture("background.png");
        flyimage = new Texture("actor.png");
        fly = mWorld.getFly();
        mov = mWorld.getMovhandler();
        flyimages = new Sprite(flyimage);
        flyimages.flip(false ,true);
        b = new Sprite(background);
        b.flip(false ,true);
        webups = new Sprite(webup);
        frontGrass = mov.getFrontGrass();
        webups.flip(false ,true);
        backGrass = mov.getBackGrass();
        web1 = mov.getWeb1();
        web2 = mov.getWeb2();
        web3 = mov.getWeb3();
        web1r = new Rectangle();
        web1r.x = web1.getX();
        web1r.y = web1.getY();
        web1r.width = webup.getWidth();
        web1r.height = webup.getHeight();
        flyr = new Rectangle();
        flyr.x = fly.getX();
        flyr.y = fly.getY();
        flyr.width = fly.getWidth();
        flyr.height = fly.getHeight();




    }

    public void render(float delta) {
        batch.begin();
        batch.disableBlending();
    if(web1.collides(fly) || web2.collides(fly) || web3.collides(fly)){
            Jelly.stop();
            InputHandler.isonclick = true;
        if(Gdx.input.isTouched()){
            new Mainstream().setScreen(new GameScreen());
            InputHandler.isonclick = false;

        }
    }
       // if(fly.getY() >= gameHeight)fly.isNotAlive = true;

        batch.draw(b ,0 ,0 ,Gdx.graphics.getWidth() ,Gdx.graphics.getHeight());
        batch.enableBlending();
        batch.draw(flyimages ,fly.getX() ,fly.getY() ,fly.getWidth() ,fly.getHeight());
        drawWeb();
        batch.end();
    }
    public void drawWeb(){
        batch.draw(webups, web1.getX() ,web1.getY() -60 ,web1.getWidth() ,web1.getHeight());
        batch.draw(webdown ,web1.getX() ,web1.getHeight() + MovHandler.WEB_GAP ,web1.getWidth() ,web1.getHeight());
        batch.draw(webups  ,web2.getX() ,web2.getY() -60 ,web2.getWidth() ,web2.getHeight());

        batch.draw(webdown ,web2.getX() ,web2.getHeight() + MovHandler.WEB_GAP ,web2.getWidth() ,web2.getHeight());
        batch.draw(webups  ,web3.getX() ,web3.getY() -60 ,web3.getWidth() ,web3.getHeight());

        batch.draw(webdown ,web3.getX() ,web3.getHeight() + MovHandler.WEB_GAP ,web3.getWidth() ,web3.getHeight());
}
}
