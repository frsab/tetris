package tetris.entity;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import gameframework.game.SpriteManagerDefaultImpl;


public class CrossShapeTetris extends ShapeTetris {
	protected List<ShapeTetris> listFT=new ArrayList<ShapeTetris>();
	
	public CrossShapeTetris(Canvas defaultCanvas) {
		super();
		ShapeTetris ft1=new NotEmptySquare(defaultCanvas);
		listFT.add(ft1);
		ShapeTetris ft2=new NotEmptySquare(defaultCanvas);
		listFT.add(ft2);

	
	}

	@Override
	public void draw(Graphics g) {
		for(ShapeTetris ft:listFT){
			ft.draw(g);
			;
		}
		
	}

	@Override
	public Rectangle getBoundingBox() {
		Rectangle tempRec =new Rectangle(0,0,0,0);
		for(ShapeTetris ft:listFT){
			tempRec.add(ft.getBoundingBox());
		}
		//tempRec.add(r);
		//return (new Rectangle(0, 0, RENDERING_SIZE, RENDERING_SIZE));
		return tempRec;
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		for(ShapeTetris ft:listFT){
			ft.oneStepMoveAddedBehavior();
			;
		}
		
	}



	


}
