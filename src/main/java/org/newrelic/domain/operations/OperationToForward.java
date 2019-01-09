package org.newrelic.domain.operations;

import org.newrelic.domain.Contants;
import org.newrelic.domain.Move;
import org.newrelic.domain.movements.IMoveRobotHandler;
import org.newrelic.domain.movements.MoveRobotRegister;

public class OperationToForward implements IOperationHandler {

    @Override
    public boolean validateOperation(Move move) throws Exception {

        int posX = move.getRobot().getPosition().getX();
        int posY = move.getRobot().getPosition().getY();
        String orientation = move.getOrientation();

        int posXTableu = move.getPlateau().getX();
        int posYTableu = move.getPlateau().getY();

        validatePositions(posX, posY, orientation, posXTableu, posYTableu);

        MoveRobotRegister moveRobotRegister = new MoveRobotRegister();
        IMoveRobotHandler iMoveRobotHandler = moveRobotRegister.handle().get(orientation);
        iMoveRobotHandler.move(move);

        return true;
    }

    private void validatePositions(int posX, int posY, String orientation, int posXTableu, int posYTableu) throws Exception {
        if (posY == posYTableu && orientation.equals(Contants.NORTH)) {
            throw new Exception("At the top, robot can not move to north");
        } else if (posY == 0 && orientation.equals(Contants.SOUTH)) {
            throw new Exception("At the bottom, robot can not move to south");
        } else if (posX == 0 && orientation.equals(Contants.WEST)) {
            throw new Exception("At the left, robot can not move to the west");
        } else if (posX == posXTableu && orientation.equals(Contants.EAST)) {
            throw new Exception("At the right, robot can not move to the east");
        }
    }


}
