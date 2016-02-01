package tetris.entity;

import java.awt.Canvas;
import java.awt.Point;

import gameframework.base.Drawable;
import gameframework.base.DrawableImage;
import gameframework.base.Overlappable;
import gameframework.game.GameEntity;

public abstract class Square implements GameEntity, Drawable, Overlappable {
	protected static DrawableImage image = null;
	protected Point position;
	public static final int RENDERING_SIZE = 16;


	public Point getPosition() {
		return position;
	}

}
