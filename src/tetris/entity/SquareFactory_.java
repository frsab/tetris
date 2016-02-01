package tetris.entity;

import java.awt.Canvas;
import java.awt.Point;

import gameframework.game.GameEntity;

public class SquareFactory_ {

	public GameEntity getSquare(Canvas canvas, Point p, String type) {
		switch (type){
		case "NotEmpty": return new NotEmptySquare(canvas, p);
		case "Empty": return new EmptySquare(canvas, p);
		/*
		case "":;break;
		case "":;break;
		case "":;break;
		case "":;break;
		*/
		default : return null;
		}	
	}
}
