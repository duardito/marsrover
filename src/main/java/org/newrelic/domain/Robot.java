package org.newrelic.domain;

public class Robot {

    private final Position position;
    private final Cardinal cardinal;

    public Robot(Position position, Cardinal cardinal) {
        this.position = position;
        this.cardinal = cardinal;
    }

    public Position getPosition() {
        return position;
    }

    public Cardinal getCardinal() {
        return cardinal;
    }

}
