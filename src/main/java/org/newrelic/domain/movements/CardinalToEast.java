package org.newrelic.domain.movements;

import org.newrelic.domain.Move;

public class CardinalToEast implements ICardinalHandler {

    @Override
    public void move(Move move) {
        move.incrementXPosition();
    }
}
