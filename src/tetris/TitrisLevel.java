package tetris;

import java.awt.Canvas;

import gameframework.game.Game;
import gameframework.game.GameLevel;
import gameframework.game.GameLevelDefaultImpl;

public abstract class TitrisLevel extends GameLevelDefaultImpl implements GameLevel  {
	protected static final int SQUARE_SIZE = 16;

	protected Canvas canvas;

	public TitrisLevel(Game g) {
		super(g);
		canvas = g.getCanvas();
	}

}
