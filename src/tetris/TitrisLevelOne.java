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
import gameframework.game.OverlapProcessor;
import gameframework.game.OverlapProcessorDefaultImpl;
import pacman.entity.Pacman;
import tetris.entity.EmptySquare;
import tetris.entity.NotEmptySquare;
import tetris.rule.TetrisMoveBlockers;

public class TitrisLevelOne extends TitrisLevel {

	public TitrisLevelOne(Game g) {
		super(g);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void init() {
		OverlapProcessor overlapProcessor = new OverlapProcessorDefaultImpl();

		MoveBlockerChecker moveBlockerChecker = new MoveBlockerCheckerDefaultImpl();
		moveBlockerChecker.setMoveBlockerRules(new TetrisMoveBlockers());
		TetrisOverlapRules overlapRules = new TetrisOverlapRules(new Point(10 * SQUARE_SIZE, 0), score[0], life[0],	endOfGame);
		overlapProcessor.setOverlapRules(overlapRules);
		universe = new GameUniverseDefaultImpl(moveBlockerChecker, overlapProcessor);
		overlapRules.setUniverse(universe);
		gameBoard = new GameUniverseViewPortDefaultImpl(canvas, universe);
		((CanvasDefaultImpl) canvas).setDrawingGameBoard(gameBoard);
		// remplir la grille avec des carrés vides .
		for (int i = 0; i < 31; ++i) {//Hauteur
			for (int j = 0; j < 29; ++j) {//Largeur
				Point p=new Point(j * SQUARE_SIZE, i * SQUARE_SIZE);
					universe.addGameEntity(new EmptySquare(canvas, p));
			}
		}
	
		//int fragmentTetriceTypeNb =0;// (Math.random() * ((2 - 0) + 1));
		//FragmentTetrisFactory ftf=new FragmentTetrisFactory(); 
		//FragmentTetris ft= ftf.getFragment(fragmentTetriceTypeNb);
		
		
		
	/*	
		NotEmptySquare ft= new NotEmptySquare(canvas);
		GameMovableDriverDefaultImpl ftDriver=new GameMovableDriverDefaultImpl();
		MoveStrategyKeyboard keyStrFt = new MoveStrategyKeyboard();
		ftDriver.setmoveBlockerChecker(moveBlockerChecker);
		canvas.addKeyListener(keyStrFt);
		ft.setDriver(ftDriver);
		ft.setPosition(new Point(10 * SQUARE_SIZE, 10 * SQUARE_SIZE));
		universe.addGameEntity(ft);
		*/
				
		Pacman myPac = new Pacman(canvas);
		GameMovableDriverDefaultImpl pacDriver = new GameMovableDriverDefaultImpl();
		MoveStrategyKeyboard keyStr = new MoveStrategyKeyboard();
		pacDriver.setStrategy(keyStr);
		pacDriver.setmoveBlockerChecker(moveBlockerChecker);
		canvas.addKeyListener(keyStr);
		myPac.setDriver(pacDriver);
		myPac.setPosition(new Point(10 * SQUARE_SIZE, 10 * SQUARE_SIZE));
		universe.addGameEntity(myPac);
		
		NotEmptySquare myNotEmptySquare = new NotEmptySquare(canvas);
		GameMovableDriverDefaultImpl NotEmptySquareDriver = new GameMovableDriverDefaultImpl();
		MoveStrategyKeyboard keyStr1 = new MoveStrategyKeyboard();
		NotEmptySquareDriver.setStrategy(keyStr1);
		NotEmptySquareDriver.setmoveBlockerChecker(moveBlockerChecker);
		canvas.addKeyListener(keyStr1);
		myNotEmptySquare.setDriver(NotEmptySquareDriver);
		myNotEmptySquare.setPosition(new Point(14 * SQUARE_SIZE, 17 * SQUARE_SIZE));
		universe.addGameEntity(myNotEmptySquare);
		}

}
