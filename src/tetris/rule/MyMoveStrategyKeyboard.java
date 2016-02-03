package tetris.rule;

import java.awt.Point;
import java.awt.event.KeyEvent;

import gameframework.base.MoveStrategyKeyboard;

public class MyMoveStrategyKeyboard extends MoveStrategyKeyboard {
	@Override
	public void keyPressed(KeyEvent event) {
		int keycode = event.getKeyCode();
		switch (keycode) {
		case KeyEvent.VK_RIGHT:
			speedVector.setDirection(new Point(1, 1));
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			speedVector.setDirection(new Point(0, 1));
			break;
		case KeyEvent.VK_LEFT:
			speedVector.setDirection(new Point(-1, 1));
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			speedVector.setDirection(new Point(0, 1));
			break;
		case KeyEvent.VK_UP:
			event.setKeyCode(KeyEvent.VK_DOWN);
			keyPressed( event);
//			speedVector.setDirection(new Point(0, -1));
			break;
		case KeyEvent.VK_DOWN:
			speedVector.setDirection(new Point(0, 1));
			break;
		}
	}

	private Point add(Point sv, Point addedSv) {
		sv.x+=addedSv.x;
		sv.y+=addedSv.y;
		
		return sv;
	}

}
