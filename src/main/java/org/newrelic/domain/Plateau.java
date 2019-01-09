package org.newrelic.domain;

public class Plateau {

    private final int x;
    private final int y;

    public Plateau(int x, int y) throws Exception {
        this.x = x;
        this.y = y;
        validateRange();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void validateRange() throws Exception {
        if(x < 0 || y < 0){
            throw new Exception("Planet grid can not be negative");
        }
    }
}
