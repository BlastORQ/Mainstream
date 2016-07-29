package ua.pp.blastorq.mainstream;

import com.badlogic.gdx.Game;

import ua.pp.blastorq.mainstream.screens.GameScreen;
import ua.pp.blastorq.mainstream.screens.SplashScreen;

public class Mainstream extends Game {

	
	@Override
	public void create () {
		setScreen(new SplashScreen(this ,new GameScreen()));
	}

	@Override
	public void render () {
		super.render();
	}
}
