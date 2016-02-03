package tetris.entity;


import gameframework.base.Drawable;
import gameframework.base.DrawableImage;
import gameframework.base.Overlappable;
import gameframework.game.GameEntity;
import gameframework.game.MoveBlocker;
import gameframework.game.SpriteManagerDefaultImpl;

import java.awt.*;


public class Ground implements Overlappable, GameEntity,Drawable{
	
	protected static DrawableImage image = null;
	protected Point position;
	public static final int RENDERING_L = 16;	
	public static final int RENDERING_H = 16;


	public Point getPosition() {
		return position;
	}



	@Override
	public Rectangle getBoundingBox() {
		return (new Rectangle((int) position.getX(), (int) position.getY(),
				RENDERING_L, RENDERING_H));

	}



	@Override
	public void draw(Graphics g) {
		g.drawImage(image.getImage(), (int) getPosition().getX(),
				(int) getPosition().getY(), RENDERING_L, RENDERING_H,
				null);
		
	}

	//private Point position;// = point;

    int H;
    int L;


    public Ground() {
    	position.setLocation(120, 120);

    }

    public Ground(Canvas defaultCanvas, Point p_base) {

    	image = new DrawableImage("tetrisImages/base.gif", defaultCanvas);
    	position = p_base;
	//spriteManager = new SpriteManagerDefaultImpl("tetrisImages/notEmpty.gif",defaultCanvas, RENDERING_SIZE, 6);
	}



 

	public void setPosition(Point position) {
		this.position = position;
	}
}
