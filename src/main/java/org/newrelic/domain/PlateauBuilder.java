package org.newrelic.domain;

public class PlateauBuilder {

    private Plateau plateau;

    public PlateauBuilder(String[] snippetWithGrid) throws Exception {
        this.plateau = new Plateau(Integer.parseInt(snippetWithGrid[0]), Integer.parseInt(snippetWithGrid[1]));
    }

    public Plateau getPlateau() {
        return plateau;
    }
}
