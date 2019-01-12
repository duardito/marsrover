package org.newrelic.domain.operations;

import org.newrelic.domain.Contants;
import org.newrelic.domain.Move;

public class OperationToRight implements IOperationHandler {

    @Override
    public boolean executeOperation(Move move) {

        final String orientation = move.getOrientation();

        if (Contants.NORTH.equals(orientation)) {
            move.changeOrientationToEast();
        } else if (Contants.WEST.equals(orientation)) {
            move.changeOrientationToNorth();
        } else if (Contants.SOUTH.equals(orientation)) {
            move.changeOrientationToWest();
        } else if (Contants.EAST.equals(orientation)) {
            move.changeOrientationToSouth();
        }
        return true;
    }
}
