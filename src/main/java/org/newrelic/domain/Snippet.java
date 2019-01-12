package org.newrelic.domain;

import org.newrelic.domain.movements.CardinalValidator;

import java.util.List;

public class Snippet {

    private int x;
    private int y;
    private String cardinal;
    private String operations;

    public static Snippet build(int m, List<String> value) {
        Integer x = Integer.parseInt(value.get(m));
        Integer y = Integer.parseInt(value.get(m + 1));
        String cardinal = value.get(m + 2);
        boolean isValidCardinal = CardinalValidator.validate(cardinal);
        if (!isValidCardinal) {
            return null;
        }
        String operations = null;
        try {
            operations = value.get(m + 3);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }

        return new Snippet(x, y, cardinal, operations);
    }

    private Snippet(int x, int y, String cardinal, String operations) {
        this.x = x;
        this.y = y;
        this.cardinal = cardinal;
        this.operations = operations;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getCardinal() {
        return cardinal;
    }

    public String getOperations() {
        return operations;
    }


}

