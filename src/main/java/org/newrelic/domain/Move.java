package org.newrelic.domain;

import org.newrelic.domain.operations.IOperationHandler;
import org.newrelic.domain.operations.OperationsRegister;

public class Move {

    private Robot robot;
    private Plateau plateau;
    private String orientation;

    public Move(Robot robot, Plateau plateau) {
        this.robot = robot;
        this.plateau = plateau;
        orientation = robot.getCardinal().getOrientation();
    }

    public void incrementXPosition() {
        this.getRobot().getPosition().setX(this.getRobot().getPosition().getX() + 1);
    }

    public void decrementXPosition() {
        this.getRobot().getPosition().setX(this.getRobot().getPosition().getX() - 1);
    }

    public void incrementYPosition() {
        this.getRobot().getPosition().setY(this.getRobot().getPosition().getY() + 1);
    }

    public void decrementYPosition() {
        this.getRobot().getPosition().setY(this.getRobot().getPosition().getY() - 1);
    }

    public void moveRobotWithOperations(String operations) {
        OperationsRegister operationsRegister = new OperationsRegister();
        for (int k = 0; k < operations.length(); k++) {
            final String operation = String.valueOf(operations.charAt(k));
            IOperationHandler operationHandler = operationsRegister.handle().get(operation);
            operationHandler.validateOperation(this);
        }
    }

    public static Move buildMove(Plateau plateau, Snippet snippet) {
        Position position = new Position(snippet.getX(), snippet.getY());
        Cardinal cardinal = new Cardinal(snippet.getCardinal());
        Robot robot = new Robot(position, cardinal);
        return new Move(robot, plateau);
    }

    public void changeOrientationToWest() {
        this.orientation = Contants.WEST;
    }

    public void changeOrientationToEast() {
        this.orientation = Contants.EAST;
    }

    public void changeOrientationToSouth() {
        this.orientation = Contants.SOUTH;
    }

    public void changeOrientationToNorth() {
        this.orientation = Contants.NORTH;
    }

    public Robot getRobot() {
        return robot;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public String getOrientation() {
        return orientation;
    }
}
