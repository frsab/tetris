package tetris;

import java.awt.Point;

import gameframework.base.ObservableValue;
import gameframework.game.GameUniverse;
import gameframework.game.OverlapRulesApplierDefaultImpl;


public class TetrisOverlapRules extends OverlapRulesApplierDefaultImpl{
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

}
