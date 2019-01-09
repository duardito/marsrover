package org.newrelic.domain.movements;

import org.newrelic.domain.Move;

public class MoveToNorth  implements IMoveRobotHandler{

    @Override
    public void move(Move move) {
        move.incrementYPosition();
    }
}
