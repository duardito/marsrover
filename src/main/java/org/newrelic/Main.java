package org.newrelic;

import org.newrelic.domain.*;

import java.util.List;

public class Main {

    public static void main(String[] a) throws Exception {

        String input = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM 2 3 W LMLMLMLMM";


        final String[] snippetWithGrid = input.split("\\s+");
        PlateauBuilder plateauBuilder = new PlateauBuilder(snippetWithGrid);
        //final Plateau plateau = new Plateau(Integer.parseInt(snippetWithGrid[0]), Integer.parseInt(snippetWithGrid[1]));

        final String partial = input.substring(snippetWithGrid[0].length() + snippetWithGrid[1].length() + 2);

        String[] snippets = partial.split("\\s+");
        int m = 0;
        while (m < snippets.length) {

            final SnippetBuilder snippetBuilder = new SnippetBuilder(partial);
            final List<String> dataToBuildSnippets = snippetBuilder.getDataToBuildSnippets();

            final Snippet snippet = Snippet.buildSnippetFromValues(m, dataToBuildSnippets);

            final Move move = Move.buildMove(plateauBuilder.getPlateau(), snippet);

            move.moveRobotWithOperations(snippet.getOperations());

            System.out.println(new Response(move));

            if (m == snippets.length / 4) {
                break;
            }
            m = m + 4;
        }

    }


}
