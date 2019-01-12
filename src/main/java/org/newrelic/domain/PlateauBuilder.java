package org.newrelic.domain;

public class PlateauBuilder {

    private Plateau plateau;

    public PlateauBuilder(String[] snippetWithGrid) {
        try {
            this.plateau = new Plateau(Integer.parseInt(snippetWithGrid[0]), Integer.parseInt(snippetWithGrid[1]));
        } catch (Exception e) {
            this.plateau = null;
        }
    }

    public Plateau getPlateau() {
        return plateau;
    }
}
