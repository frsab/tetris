package tetris.entity;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.base.Drawable;
import gameframework.base.DrawableImage;
import gameframework.base.Overlappable;
import gameframework.game.GameEntity;


public class EmptySquare implements GameEntity, Drawable, Overlappable {
	protected static DrawableImage image = null;
	protected Point position;
	public static final int RENDERING_SIZE = 16;


	public Point getPosition() {
		return position;
	}


	public EmptySquare(Canvas defaultCanvas, Point point) {
		image = new DrawableImage("tetrisImages/empty.gif", defaultCanvas);
		position = point;
	}



	@Override
	public Rectangle getBoundingBox() {
		return (new Rectangle((int) position.getX(), (int) position.getY(),
				RENDERING_SIZE, RENDERING_SIZE));

	}



	@Override
	public void draw(Graphics g) {
		g.drawImage(image.getImage(), (int) getPosition().getX(),
				(int) getPosition().getY(), RENDERING_SIZE, RENDERING_SIZE,
				null);
		
	}

}
