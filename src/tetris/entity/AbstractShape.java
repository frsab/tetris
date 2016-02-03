package tetris.entity;

import gameframework.base.Drawable;
import gameframework.base.DrawableImage;
import gameframework.base.Overlappable;
import gameframework.game.GameEntity;
import gameframework.game.GameMovable;

import java.awt.*;


abstract public class AbstractShape extends GameMovable implements Drawable, GameEntity, Overlappable {
    protected DrawableImage image;
    protected int size;

    public AbstractShape(Canvas canvas, int size) {
        image = null;//new DrawableImage(getImage(), canvas);
        this.size = size;
    }

    @Override
    public abstract void draw(Graphics g); /*{
        g.drawImage(image.getImage(), (int) getPosition().getX(),
                (int) getPosition().getY(), size, size, null);
    }*/

    @Override
    public void oneStepMoveAddedBehavior() { }

    @Override
    public Rectangle getBoundingBox() {
        return new Rectangle(0, 0, size, size);
    }
}
