package tetris.entity;

import java.awt.Canvas;
import java.awt.Graphics;

import gameframework.base.DrawableImage;

public class Shape1 extends AbstractShape {

	public Shape1(Canvas canvas, int size) {
		super(canvas, size);
		image = new DrawableImage("tetrisImages/notEmpty.gif", canvas);
        this.size = size;
	}

	@Override
	public void draw(Graphics g) {
		 g.drawImage(image.getImage(), (int) getPosition().getX(),
	                (int) getPosition().getY(), size, size, null);
		
	}

}
