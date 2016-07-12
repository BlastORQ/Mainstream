package ua.pp.blastorq;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import ua.pp.blastorq.screen.SplashScreen;

public class Mainstream extends Game {
	public SpriteBatch batch;


	@Override
	public void create() {
		batch = new SpriteBatch();
		this.setScreen(new SplashScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}
}
