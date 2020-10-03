package ua.pp.blastorq.mainstream.objects;


import com.badlogic.gdx.physics.box2d.Body;

import ua.pp.blastorq.mainstream.game.GameWorld;

/**
 * Created by serhij on 27.07.2016.
 */
public class MovHandler {
    public Web web1 ,web2  ,web3  ,web4 ,web5 ,web6;
    Grass frontGrass ,backGrass;
    GameWorld world;
    public static final int MOV_SPEED = -20;
    public static final int WEB_GAP  = 60;


    public MovHandler(GameWorld world , float yPos, Body grassBody) {
        this.world = world;
        frontGrass = new Grass(0, yPos-28, 462 , 30 ,MOV_SPEED, grassBody.getPosition());
        backGrass = new Grass(462+frontGrass.getX(), yPos-28, 462, 30, MOV_SPEED, grassBody.getPosition());
        web1 = new Web(105,0 ,22, 60 ,MOV_SPEED ,yPos);
        web2 = new Web(web1.getTailX() + WEB_GAP, 0, 22, 70, MOV_SPEED, yPos);
        web3 = new Web(web2.getTailX() + WEB_GAP, 0, 22, 60, MOV_SPEED, yPos);
        web4 = new Web(web3.getTailX() + WEB_GAP, 0, 22, 70, MOV_SPEED, yPos);
        web5 = new Web(web4.getTailX() + WEB_GAP, 0, 22, 60, MOV_SPEED, yPos);
        web6 = new Web(web5.getTailX() + WEB_GAP, 0, 22, 70, MOV_SPEED, yPos);
    }
    public void update(float delta){
        frontGrass.update(delta);
        backGrass.update(delta);

        web1.update(delta);
        web2.update(delta);
        web3.update(delta);
        web4.update(delta);
        web5.update(delta);
        web6.update(delta);

        if(web1.isScrolledLeft()){
            web1.reset(web6.getTailX() + WEB_GAP);
        }else if(web2.isScrolledLeft()){
            web2.reset(web1.getTailX() + WEB_GAP);
        }else if(web3.isScrolledLeft()) {
            web3.reset(web2.getTailX() + WEB_GAP);
        }else if(web4.isScrolledLeft()){
            web4.reset(web3.getTailX() + WEB_GAP);
        }else if(web5.isScrolledLeft()){
            web5.reset(web4.getTailX() + WEB_GAP);
        }else if(web6.isScrolledLeft()) {
            web6.reset(web5.getTailX() + WEB_GAP);
        }
        if(frontGrass.isScrolledLeft()){
            frontGrass.reset(backGrass.getTailX());
        }else if(backGrass.isScrolledLeft()){
            backGrass.reset(frontGrass.getTailX());
        }
        }
    public void stop(){
        web1.stop();
        web2.stop();
        web3.stop();
        web4.stop();
        web5.stop();
        web6.stop();
        frontGrass.stop();
        backGrass.stop();
    }

    public Grass getBackGrass() {
        return backGrass;
    }

    public Grass getFrontGrass() {
        return frontGrass;
    }

    public Web getWeb3() {
        return web3;
    }

    public Web getWeb2() {
        return web2;
    }

    public Web getWeb1() {
        return web1;
    }

    public Web getWeb4() {
        return web4;
    }

    public Web getWeb5() {
        return web5;
    }

    public Web getWeb6() {
        return web6;
    }

    public boolean collides(Fly fly){
        return web1.collides(fly) || web2.collides(fly) || web3.collides(fly) || web4.collides(fly) || web5.collides(fly) || web6.collides(fly) ;
    }
}

