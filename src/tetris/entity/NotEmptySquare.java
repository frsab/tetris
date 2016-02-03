package tetris.entity;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.base.Drawable;
import gameframework.base.DrawableImage;
import gameframework.base.Overlappable;
import gameframework.base.SpeedVector;
import gameframework.game.GameEntity;
import gameframework.game.GameMovable;
import gameframework.game.MoveBlocker;
import gameframework.game.SpriteManager;
import gameframework.game.SpriteManagerDefaultImpl;


public class NotEmptySquare
extends ShapeTetris
implements GameEntity, Drawable, Overlappable,MoveBlocker {
	private Point position;
	protected final SpriteManager spriteManager;
	public static final int RENDERING_SIZE = 16;
	protected boolean movable = true;
    protected static DrawableImage image;
	private boolean ALive;
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}

	public boolean isALive() {
		return ALive;
	}
	public void setALive(boolean aLive) {
		ALive = aLive;
	}
	public NotEmptySquare(Canvas defaultCanvas) {
		super();
		 ALive=true;
		image = new DrawableImage("tetrisImages/notEmpty.gif", defaultCanvas);
		spriteManager = new SpriteManagerDefaultImpl("tetrisImages/notEmpty.gif",
				defaultCanvas, RENDERING_SIZE, 6);
		spriteManager.setTypes(
				//
				"right", "left", "up","down",//
	//			"invulnerable-right", "invulnerable-left", "invulnerable-up","invulnerable-down", //
				"unused", "static", "unused"
				);
	
	}
	public NotEmptySquare(Canvas defaultCanvas, Point position) {
		super();
		 ALive=true;
		image = new DrawableImage("tetrisImages/notEmpty.gif", defaultCanvas);
		spriteManager = new SpriteManagerDefaultImpl("tetrisImages/notEmpty.gif",
				defaultCanvas, RENDERING_SIZE, 6);
		spriteManager.setTypes(
				//
				"right", "left", "up","down",//
	//			"invulnerable-right", "invulnerable-left", "invulnerable-up","invulnerable-down", //
				"unused", "static", "unused"
				);
		this.position=position;
	}
	@Override
	 public void draw(Graphics g) {
		System.out.println("draw NotEmptySquare");
        g.drawImage(image.getImage(), (int) getPosition().getX(),
                (int) getPosition().getY(), 16, 16, null);
    }

	@Override
	public void oneStepMoveAddedBehavior() {
		if (movable) {
			spriteManager.increment();

		}
	}



	@Override
	public Rectangle getBoundingBox() {
		return (new Rectangle(0, 0, RENDERING_SIZE, RENDERING_SIZE));
	}
	public void setAlive(boolean b) {
		ALive=b;
		
	}

}
