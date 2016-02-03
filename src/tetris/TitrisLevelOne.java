package tetris;

import java.awt.Point;

import gameframework.base.MoveStrategyKeyboard;

import gameframework.game.CanvasDefaultImpl;
import gameframework.game.Game;
import gameframework.game.GameMovableDriverDefaultImpl;
import gameframework.game.GameUniverseDefaultImpl;
import gameframework.game.GameUniverseViewPortDefaultImpl;
import gameframework.game.MoveBlockerChecker;
import gameframework.game.MoveBlockerCheckerDefaultImpl;
import gameframework.game.MoveBlockerRulesApplierDefaultImpl;
import gameframework.game.OverlapProcessor;
import gameframework.game.OverlapProcessorDefaultImpl;

import tetris.entity.EmptySquare;
import tetris.entity.Ground;
import tetris.entity.NotEmptySquare;
import tetris.entity.ShapeTetris;
import tetris.entity.TShapeTetris;
import tetris.entity.WallSquare;
import tetris.rule.MyMoveStrategyKeyboard;
import tetris.rule.TetrisMoveBlockers;
import tetris.rule.TetrisOverlapRules;

public class TitrisLevelOne extends TitrisLevel {

	public TitrisLevelOne(Game g) {
		super(g);
	}

	@Override
	protected void init() {
		OverlapProcessor overlapProcessor = new OverlapProcessorDefaultImpl();
		//BallMoveBlockerApplier extends MoveBlockerRulesApplierDefaultImpl
		MoveBlockerChecker moveBlockerChecker = new MoveBlockerCheckerDefaultImpl();
		moveBlockerChecker.setMoveBlockerRules(new TetrisMoveBlockers());

		TetrisOverlapRules overlapRules = new TetrisOverlapRules(new Point(10 * SQUARE_SIZE, 0), score[0], life[0],	endOfGame);
		overlapProcessor.setOverlapRules(overlapRules);
		universe = new GameUniverseDefaultImpl(moveBlockerChecker, overlapProcessor);
		overlapRules.setUniverse(universe);
		gameBoard = new GameUniverseViewPortDefaultImpl(canvas, universe);
		((CanvasDefaultImpl) canvas).setDrawingGameBoard(gameBoard);
		for (int i = 0; i < 31; ++i) {//Hauteur
			for (int j = 0; j < 29; ++j) {//Largeur
				Point p=new Point(j * SQUARE_SIZE, i * SQUARE_SIZE);
				if((j==0)||(j==27)|| (i==30)){
					universe.addGameEntity(new WallSquare(canvas, p));
				}
				else
				{
					universe.addGameEntity(new EmptySquare(canvas, p));	
				}
				if(i==30){
					Point p_base=new Point(j * SQUARE_SIZE, i * SQUARE_SIZE-32);
					Ground ground;
					universe.addGameEntity(new Ground(canvas,p_base));
					
				}

			}
		}
		

		MyMoveStrategyKeyboard keyStr1 = new MyMoveStrategyKeyboard();
		GameMovableDriverDefaultImpl notEmptySquareDriver = new GameMovableDriverDefaultImpl();
		notEmptySquareDriver.setStrategy(keyStr1);
		notEmptySquareDriver.setmoveBlockerChecker(moveBlockerChecker);
		canvas.addKeyListener(keyStr1);
		
		ShapeTetris  myNotEmptySquare = new TShapeTetris (canvas);
		myNotEmptySquare.setDriver(notEmptySquareDriver);
		myNotEmptySquare.setPosition(new Point(14 * SQUARE_SIZE, 2 * SQUARE_SIZE));
		universe.addGameEntity(myNotEmptySquare);
		//while(myNotEmptySquare.getPosition().toString().equals("java.awt.Point[x=1,y=1]"))
		System.out.println(myNotEmptySquare.getPosition().toString());
		}

}
