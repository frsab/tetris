package tetris.rule;


import java.awt.Point;


import gameframework.base.MoveStrategy;
import gameframework.base.SpeedVector;
import gameframework.game.GameMovableDriverDefaultImpl;
import gameframework.game.IllegalMoveException;
import gameframework.game.MoveBlockerRulesApplierDefaultImpl;
import pacman.entity.Ghost;
import pacman.entity.Wall;
import tetris.entity.EmptySquare;
import tetris.entity.NotEmptySquare;
import tetris.entity.WallSquare;

public class TetrisMoveBlockers extends MoveBlockerRulesApplierDefaultImpl {
	public void moveBlockerRule(NotEmptySquare g, Wall w) throws IllegalMoveException {
		// The default case is when a ghost is active and not able to cross a
		// wall
		if (true){//g.isActive()) {
			System.out.println("class TetrisMoveBlockers ");
			throw new IllegalMoveException();
			// When a ghost is not active, it is able to cross a wall
		}
	}
}
