package tetris.entity;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import gameframework.game.SpriteManagerDefaultImpl;
import tetris.entity.FragmentTetris;

public class CrossFragmentTetris extends FragmentTetris {
	protected List<FragmentTetris> listFT=new ArrayList<FragmentTetris>();
	
	public CrossFragmentTetris(Canvas defaultCanvas) {
		super();
		FragmentTetris ft1=new NotEmptySquare(defaultCanvas);
		listFT.add(ft1);
		FragmentTetris ft2=new NotEmptySquare(defaultCanvas);
		listFT.add(ft2);

	
	}

	@Override
	public void draw(Graphics g) {
		for(FragmentTetris ft:listFT){
			ft.draw(g);
			;
		}
		
	}

	@Override
	public Rectangle getBoundingBox() {
		Rectangle tempRec =new Rectangle(0,0,0,0);
		for(FragmentTetris ft:listFT){
			tempRec.add(ft.getBoundingBox());
		}
		//tempRec.add(r);
		//return (new Rectangle(0, 0, RENDERING_SIZE, RENDERING_SIZE));
		return tempRec;
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		for(FragmentTetris ft:listFT){
			ft.oneStepMoveAddedBehavior();
			;
		}
		
	}



	


}
