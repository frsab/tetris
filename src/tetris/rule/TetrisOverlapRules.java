package tetris.rule;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;


import gameframework.base.MoveStrategyStraightLine;
import gameframework.base.ObservableValue;
import gameframework.game.GameMovableDriverDefaultImpl;
import gameframework.game.GameUniverse;
import gameframework.game.MoveBlockerChecker;
import gameframework.game.MoveBlockerCheckerDefaultImpl;
import gameframework.game.OverlapRulesApplierDefaultImpl;
import tetris.TitrisLevel;
import tetris.entity.*;


public class TetrisOverlapRules extends OverlapRulesApplierDefaultImpl{
	
	private static final int SPRITE_SIZE = 16;
	private static final int SQUARE_SIZE = 16;
	protected GameUniverse universe;
	protected Point tetrisPieceSourcePsition;
	protected boolean manageTetrisCompleted;
	private final ObservableValue<Integer> score;
	private final ObservableValue<Integer> life;
	private final ObservableValue<Boolean> endOfGame;

	public TetrisOverlapRules( Point tetrisPieceSourcePsition,ObservableValue<Integer> score, ObservableValue<Integer> life, ObservableValue<Boolean> endOfGame) {
		super();

		this.tetrisPieceSourcePsition = tetrisPieceSourcePsition;
		this.score = score;
		this.life = life;
		this.endOfGame = endOfGame;
	}

	@Override
	public void setUniverse(GameUniverse universe) {
		this.universe = universe;	
	}
	public void overlapRule(NotEmptySquare p, WallSquare g) {
	}
	public void overlapRule(NotEmptySquare p, Ground g) {
		System.out.println("croisement NotEmptySquare p, Ground g ");
		this.score.setValue(this.score.getValue()+1);
		MoveBlockerChecker moveBlockerChecker = new MoveBlockerCheckerDefaultImpl();
		MyMoveStrategyKeyboard keyStr1 = new MyMoveStrategyKeyboard();
		GameMovableDriverDefaultImpl notEmptySquareDriver = new GameMovableDriverDefaultImpl();
		notEmptySquareDriver.setStrategy(keyStr1);
		notEmptySquareDriver.setmoveBlockerChecker(moveBlockerChecker);

		Canvas canvas = null;
		canvas=TitrisLevel.getCanvas();
		NotEmptySquare myNotEmptySquare = new NotEmptySquare(canvas);		
		//NotEmptySquare myNotEmptySquare = new NotEmptySquare(canvas);
		myNotEmptySquare.setDriver(notEmptySquareDriver);
		myNotEmptySquare.setPosition(p.getPosition());//(new Point(10 * 16, 4 * 16));
		universe.addGameEntity(myNotEmptySquare);
		p.setPosition(new Point(14 * SQUARE_SIZE, 2 * SQUARE_SIZE));
		g.setPosition(new Point(400, 300));
	}
	public void overlapRule(NotEmptySquare p, NotEmptySquare g) {
		System.out.println("croisement deux NotEmptySquare");
		/*
		
		this.score.setValue(this.score.getValue()+1);
		MoveBlockerChecker moveBlockerChecker = new MoveBlockerCheckerDefaultImpl();
		MyMoveStrategyKeyboard keyStr1 = new MyMoveStrategyKeyboard();
		GameMovableDriverDefaultImpl notEmptySquareDriver = new GameMovableDriverDefaultImpl();
		notEmptySquareDriver.setStrategy(keyStr1);
		notEmptySquareDriver.setmoveBlockerChecker(moveBlockerChecker);
		Canvas canvas=TitrisLevel.getCanvas();
		
		NotEmptySquare myNotEmptySquare = new NotEmptySquare(canvas);		
		//NotEmptySquare myNotEmptySquare = new NotEmptySquare(canvas);
		myNotEmptySquare.setDriver(notEmptySquareDriver);
		myNotEmptySquare.setPosition(p.getPosition());//(new Point(10 * 16, 4 * 16));
		universe.addGameEntity(myNotEmptySquare);
		//p.setPosition(new Point(20 * SQUARE_SIZE, 2 * SQUARE_SIZE));
		g.setPosition(new Point(0, 0));*/
	}

	public ObservableValue<Integer> getLife() {
		return life;
	}

	public ObservableValue<Integer> getScore() {
		return score;
	}

	public ObservableValue<Boolean> getEndOfGame() {
		return endOfGame;
	}
}
