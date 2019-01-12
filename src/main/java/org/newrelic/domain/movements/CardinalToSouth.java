package org.newrelic.domain.movements;

import org.newrelic.domain.Move;

public class CardinalToSouth implements ICardinalHandler {

    @Override
    public void move(Move move) {
        move.decrementYPosition();
    }
}
