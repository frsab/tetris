package tetris.entity;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.base.Drawable;
import gameframework.base.Overlappable;
import gameframework.base.SpeedVector;
import gameframework.game.GameEntity;
import gameframework.game.GameMovable;
import gameframework.game.SpriteManager;
import gameframework.game.SpriteManagerDefaultImpl;


public class NotEmptySquare
extends FragmentTetris
implements GameEntity, Drawable, Overlappable {
	protected final SpriteManager spriteManager;
	public static final int RENDERING_SIZE = 16;
	protected boolean movable = true;
	public NotEmptySquare(Canvas defaultCanvas) {
		super();
		spriteManager = new SpriteManagerDefaultImpl("tetrisImages/notEmpty.gif",
				defaultCanvas, RENDERING_SIZE, 6);
		spriteManager.setTypes(
				//
				"right", "left", "up","down",//
	//			"invulnerable-right", "invulnerable-left", "invulnerable-up","invulnerable-down", //
				"unused", "static", "unused"
				);
	}
	@Override
	 public void draw(Graphics g) {
        g.drawImage(image.getImage(), (int) getPosition().getX(),
                (int) getPosition().getY(), width, height, null);
    }
	/*
	public void draw(Graphics g) {
		System.out.println("draw NotEmptySquare");
		//SpeedVector sv=new SpeedVector()
		int sv=getSpeedVector().getSpeed();
		System.out.println("SpeedVector:"+sv);
		getSpeedVector().setSpeed(16);
		sv=getSpeedVector().getSpeed();
		System.out.println("SpeedVector:"+sv);
		//setSpeedVector(getSpeedVector());
		String spriteType = "";
		Point tmp = getSpeedVector().getDirection();
		//getSpeedVector().setSpeed(32);
		
		
		movable = true;
		
		if (tmp.getX() == 1) {
			spriteType += "right";
		} else if (tmp.getX() == -1) {
			spriteType += "left";
		} else if (tmp.getY() == 1) {
			spriteType += "left";
		} else if (tmp.getY() == -1) {
			spriteType += "right";
		} else {
			spriteType = "static";
			spriteManager.reset();
			movable = false;
		}
		System.out.println("tmp"+tmp.toString());
		System.out.println("spriteType"+spriteType);
		System.out.println(getPosition().toString());

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		spriteManager.setType(spriteType);
		spriteManager.draw(g, getPosition());

		
	}
*/
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


}
