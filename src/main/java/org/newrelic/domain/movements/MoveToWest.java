package org.newrelic.domain.movements;

import org.newrelic.domain.Move;

public class MoveToWest  implements IMoveRobotHandler{

    @Override
    public void move(Move move) {
        move.decrementXPosition();
    }
}
