package ua.pp.blastorq;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by serhij on 11.07.2016.
 */
public class JellyFish {
SpriteBatch batch;
    float x ,y ,width ,height;
Texture img;
    public JellyFish(Texture img ,float x , float y , float width , float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img  = img;

       batch = new SpriteBatch();

    }
public void flydraw(float delta){
        batch.begin();
    batch.draw(img , x, y, width ,height);
    batch.end();
    }
    public void onClick(){
        Gdx.app.log("Fish"  ,"Jump");
    }
}

