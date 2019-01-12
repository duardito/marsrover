package org.newrelic.domain.operations;

import org.newrelic.domain.Contants;
import org.newrelic.domain.Move;
import org.newrelic.domain.movements.ICardinalHandler;
import org.newrelic.domain.movements.CardinalRegister;

public class OperationToForward implements IOperationHandler {

    @Override
    public boolean executeOperation(Move move) {

        int posX = move.getRobot().getPosition().getX();
        int posY = move.getRobot().getPosition().getY();
        String orientation = move.getOrientation();

        int posXTableau = move.getPlateau().getX();
        int posYTableau = move.getPlateau().getY();

        boolean canMove = robotCanMoveTo(posX, posY, orientation, posXTableau, posYTableau);
        if (!canMove) {
            return false;
        }

        CardinalRegister cardinalRegister = new CardinalRegister();
        ICardinalHandler iCardinalHandler = cardinalRegister.handle().get(orientation);
        iCardinalHandler.move(move);

        return true;
    }

    private boolean robotCanMoveTo(int posX, int posY, String orientation, int posXTableau, int posYTableau) {
        int deny = 0;
        if (posY == posYTableau && Contants.NORTH.equals(orientation)) {
            deny++;
        } else if (posY == 0 && Contants.SOUTH.equals(orientation)) {
            deny++;
        } else if (posX == 0 && Contants.WEST.equals(orientation)) {
            deny++;
        } else if (posX == posXTableau && Contants.EAST.equals(orientation)) {
            deny++;
        }
        return deny <= 0;
    }


}
