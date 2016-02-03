package tetris.entity;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Rectangle;

import gameframework.base.Drawable;
import gameframework.base.DrawableImage;
import gameframework.base.Overlappable;
import gameframework.game.GameEntity;
import gameframework.game.GameMovable;

 public class Shape extends GameMovable implements Drawable, GameEntity, Overlappable {
    protected DrawableImage image;
    private int size;

    public Shape(Canvas canvas, int size) {
        image = new DrawableImage(getImage(), canvas);
        this.size = size;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image.getImage(), (int) getPosition().getX(),
                (int) getPosition().getY(), size, size, null);
    }

    @Override
    public void oneStepMoveAddedBehavior() { }

    @Override
    public Rectangle getBoundingBox() {
        return new Rectangle(0, 0, size, size);
    }

    public  String getImage(){
		return "tetrisImages/notEmpty.gif";
    	
    }
}