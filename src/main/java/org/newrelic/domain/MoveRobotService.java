package org.newrelic.domain;

import java.util.ArrayList;
import java.util.List;

public class MoveRobotService implements IMoveRobot {

    @Override
    public List<Response> moveRobotsOverMars(String inputData) {

        final List<Response> response = new ArrayList<>(0);
        final String[] snippetWithAllInFormation = snippetsFrom(inputData);
        final PlateauBuilder plateauBuilder = new PlateauBuilder(snippetWithAllInFormation);
        if(plateauBuilder.getPlateau() == null){
            return response;
        }
        final String snippetsWithoutGrid = snippetsFrom(inputData, snippetWithAllInFormation);

        final SnippetBuilder snippetBuilder = new SnippetBuilder(snippetsWithoutGrid);
        final List<String> snippets = snippetBuilder.getDataToBuildSnippets();


        int snippetCounter = 0;
        while (snippetCounter < snippets.size()) {

            final Snippet snippet = Snippet.build(snippetCounter, snippets);
            if (snippet == null) {
                break;
            }

            final Move move = Move.build(plateauBuilder.getPlateau(), snippet);
            if (move == null) {
                break;
            }
            if (!move.moveRobotWith(snippet.getOperations())) {
                break;
            }
            response.add(new Response(move));
            snippetCounter = snippetCounter + 4;
        }
        return response;
    }

    private String[] snippetsFrom(String partial) {
        return partial.split("\\s+");
    }

    private String snippetsFrom(String input, String[] snippetWithGrid) {
        return input.substring(snippetWithGrid[0].length() + snippetWithGrid[1].length() + 2);
    }

}
