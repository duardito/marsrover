package org.newrelic.domain.operations;

import org.newrelic.domain.Contants;
import org.newrelic.domain.Move;

public class OrientationToLeft implements IOperationHandler {

    @Override
    public boolean validateOperation(Move move) {
        String orientation = move.getOrientation();

        if (Contants.NORTH.equals(orientation)) {
            move.changeOrientationToWest();
        } else if (Contants.WEST.equals(orientation)) {
            move.changeOrientationToSouth();
        } else if (Contants.SOUTH.equals(orientation)) {
            move.changeOrientationToEast();
        }else if(Contants.EAST.equals(orientation)){
            move.changeOrientationToNorth();
        }

        return true;
    }
}
