package tetris;

import java.awt.Point;

import gameframework.base.MoveStrategyKeyboard;
import gameframework.base.MoveStrategyRandom;
import gameframework.base.ObservableValue;
import gameframework.game.CanvasDefaultImpl;
import gameframework.game.Game;
import gameframework.game.GameEntity;
import gameframework.game.GameLevel;
import gameframework.game.GameMovableDriverDefaultImpl;
import gameframework.game.GameUniverseDefaultImpl;
import gameframework.game.GameUniverseViewPortDefaultImpl;
import gameframework.game.MoveBlockerChecker;
import gameframework.game.MoveBlockerCheckerDefaultImpl;
import gameframework.game.OverlapProcessor;
import gameframework.game.OverlapProcessorDefaultImpl;
import pacman.entity.Ghost;
import pacman.entity.Jail;
import pacman.entity.Pacgum;
import pacman.entity.Pacman;
import pacman.entity.SuperPacgum;
import pacman.entity.TeleportPairOfPoints;
import pacman.entity.Wall;
import pacman.rule.GhostMovableDriver;
import pacman.rule.PacmanMoveBlockers;
import pacman.rule.PacmanOverlapRules;
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
				int nombreAleatoire = 10 + (int)(Math.random() * ((20 - 10) + 1));
				if (nombreAleatoire>15){
					universe.addGameEntity(new EmptySquare(canvas, p));
	//				s=(Square) squareFactory.getSquare(canvas,p,"Empty");
			//		universe.addGameEntity(s);
				}
				if (nombreAleatoire<16){
					universe.addGameEntity(new NotEmptySquare(canvas, p));
	//				s=(Square) squareFactory.getSquare(canvas,p,"NotEmpty");
		//			universe.addGameEntity(s);
			
				}


			}
		}
		GameMovableDriverDefaultImpl pacDriver = new GameMovableDriverDefaultImpl();
		MoveStrategyKeyboard keyStr = new MoveStrategyKeyboard();
		pacDriver.setStrategy(keyStr);
		pacDriver.setmoveBlockerChecker(moveBlockerChecker);
		canvas.addKeyListener(keyStr);


	}

}
