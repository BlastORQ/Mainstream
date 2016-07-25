package ua.pp.blastorq.objects;

import com.badlogic.gdx.math.Rectangle;

import ua.pp.blastorq.game.GameRender;
import ua.pp.blastorq.game.GameWorld;

/**
 * Created by serhij on 16.07.2016.
 */
public class MovHandler {
    private Grass frontGrass ,backGrass;
    Web web1 ,web2, web3;
    public static final int MOV_SPEED = -59;
    public static final int WEB_GAP = 60;
    private GameWorld gameWorld;
    public MovHandler(GameWorld gameWorld ,float yPos) {
        this.gameWorld = gameWorld;
        frontGrass = new Grass(0 ,yPos + 60,143 ,11 , MOV_SPEED);
        backGrass = new Grass(frontGrass.getTailX() ,yPos + 60,143 ,11, MOV_SPEED);

        web1 = new Web(0 ,0 + 60 ,22, 60, MOV_SPEED ,yPos);
        web2 = new Web(web1.getTailX() + WEB_GAP ,0 + 60 ,22, 70, MOV_SPEED ,yPos);
        web3 = new Web(web2.getTailX() + WEB_GAP ,0 + 60 ,22, 60, MOV_SPEED ,yPos);

    }


    public Grass getFrontGrass() {
        return frontGrass;
    }

    public Grass getBackGrass() {
        return backGrass;
    }

    public Web getWeb1() {
        return web1;
    }

    public Web getWeb2() {
        return web2;
    }
    public Web getWeb3() {
        return web3;
    }



    public void update(float delta){
        frontGrass.update(delta);
        backGrass.update(delta);
        web1.update(delta);
        web2.update(delta);
        web3.update(delta);

        if(web1.isScrolledLeft()){
            web1.reset(web3.getTailX() + WEB_GAP);
        }else if(web2.isScrolledLeft()){
            web2.reset(web1.getTailX() + WEB_GAP);
        }
        else if(web3.isScrolledLeft()){
            web3.reset(web2.getTailX() + WEB_GAP);
        }
        if(frontGrass.isScrolledLeft()){
            frontGrass.reset(backGrass.getTailX());

        }else if(backGrass.isScrolledLeft()){
            backGrass.reset(frontGrass.getTailX());
        }
    }
}