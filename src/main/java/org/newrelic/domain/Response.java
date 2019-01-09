package org.newrelic.domain;

public class Response {

    private Move move;

    public Response(Move move) {
        this.move = move;
    }

    @Override
    public String toString() {
        return move.getRobot().getPosition().getX() + " "
                + move.getRobot().getPosition().getY() + " "
                + move.getRobot().getCardinal().getOrientation() + " ";
    }
}
