package tetris.entity;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import gameframework.base.Drawable;
import gameframework.base.Overlappable;
import gameframework.game.GameEntity;
import gameframework.game.MoveBlocker;
import gameframework.game.SpriteManagerDefaultImpl;

public class TShapeTetris extends ShapeTetris implements GameEntity, Drawable, Overlappable{//, MoveBlocker {
	private static final int RENDERING_SIZE = 16;
	protected List<ShapeTetris> listComponents = new ArrayList<ShapeTetris>();
	protected int matrix4x4[][] = { { 0, 0, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 } };

	public TShapeTetris(Canvas defaultCanvas) {
		super();
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				if (matrix4x4[i][j] == 1) {
					listComponents.add(
							new NotEmptySquare(defaultCanvas, new Point(i * RENDERING_SIZE, j * RENDERING_SIZE)));

				}
			}
	}

	@Override
	public void draw(Graphics g) {
		for (ShapeTetris ft : listComponents) {
			// ft.setPosition(add(ft.getPosition(),this.getPosition()));
			System.out.println(ft.getPosition() + "  " + listComponents.indexOf(ft));
			ft.draw(g);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	private Point add(Point position, Point position2) {
		position.x += position2.x;
		position.y += position2.y;
		return position;
	}

	@Override
	public Rectangle getBoundingBox() {
		Rectangle tempRec = new Rectangle(0, 0, 0, 0);
		for (ShapeTetris ft : listComponents) {
			tempRec.add(ft.getBoundingBox());
		}
		return tempRec;
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		for (ShapeTetris ft : listComponents) {
			ft.oneStepMoveAddedBehavior();
			;
		}

	}

}
