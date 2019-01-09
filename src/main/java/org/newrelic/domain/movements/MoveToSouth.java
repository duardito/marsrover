package org.newrelic.domain.movements;

import org.newrelic.domain.Move;

public class MoveToSouth  implements IMoveRobotHandler{

    @Override
    public void move(Move move) {
        move.decrementYPosition();
    }
}
