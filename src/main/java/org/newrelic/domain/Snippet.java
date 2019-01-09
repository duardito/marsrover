package org.newrelic.domain;

import java.util.List;

public class Snippet {

    private int x;
    private int y;
    private String cardinal;
    private String operations;

    public Snippet(int x, int y, String cardinal, String operations) {
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

    public static Snippet buildSnippetFromValues(int m, List<String> value) {
        Integer x = Integer.parseInt(value.get(m));
        Integer y = Integer.parseInt(value.get(m + 1));
        String cardinal1 = value.get(m + 2);
        String operations1 = value.get(m + 3);

        return new Snippet(x, y, cardinal1, operations1);
    }
}
