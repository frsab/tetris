package tetris;

import java.util.ArrayList;

import gameframework.game.GameDefaultImpl;
import gameframework.game.GameLevel;


public class Main {

	public static void main(String[] args) {
		System.out.println("fonction main");
		System.out.println("construct a game  g");
		GameDefaultImpl g = new GameDefaultImpl();
		System.out.println("constract a empty array list of GamaLevel object");
		ArrayList<GameLevel> levels = new ArrayList<GameLevel>();
		System.out.println("add a new Gamelevel into level array");
		levels.add(new TitrisLevelOne(g)); //add level
		System.out.println("set  level array to levels of game");

		g.setLevels(levels);
		g.start();
		System.out.println("start de jeux");
		
		
		// TODO Auto-generated method stub

	}

}
