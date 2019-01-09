package org.newrelic.domain.movements;

import org.newrelic.domain.Move;

public class MoveToEast implements IMoveRobotHandler{

    @Override
    public void move(Move move) {
        move.incrementXPosition();
    }
}
