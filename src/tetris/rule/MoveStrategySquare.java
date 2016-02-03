package tetris.rule;

import gameframework.base.MoveStrategy;
import gameframework.base.SpeedVector;
import gameframework.base.SpeedVectorDefaultImpl;

import java.awt.*;


public class MoveStrategySquare implements MoveStrategy {
    protected SpeedVector speedVector;


    public MoveStrategySquare(int dx, int dy) {
        speedVector = new SpeedVectorDefaultImpl(new Point(dx, dy));
    }

    @Override
    public SpeedVector getSpeedVector() {
        return speedVector;
    }
}
