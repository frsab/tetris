package tetris;

import java.awt.Canvas;

import gameframework.game.Game;
import gameframework.game.GameLevel;
import gameframework.game.GameLevelDefaultImpl;

public abstract class TitrisLevel extends GameLevelDefaultImpl implements GameLevel  {
	protected static final int SQUARE_SIZE = 16;
	protected boolean endOfLevel;

	protected static Canvas canvas;

	public static Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public TitrisLevel(Game g) {
		super(g);
		endOfLevel=false;
		canvas = g.getCanvas();
	}

}
