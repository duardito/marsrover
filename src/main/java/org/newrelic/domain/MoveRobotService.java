package org.newrelic.domain;

import java.util.ArrayList;
import java.util.List;

public class MoveRobotService implements IMoveRobot{

    @Override
    public List<Response> moveRobotsOverMars(String inputData){

        final String[] snippetWithGrid = snippetsFrom(inputData);
        final PlateauBuilder plateauBuilder = plateauBuilderFrom(snippetWithGrid);

        final String onlySnippets = snippetsFrom(inputData, snippetWithGrid);
        final SnippetBuilder snippetBuilder = new SnippetBuilder(onlySnippets);
        final List<String> snippets = snippetBuilder.getDataToBuildSnippets();

        final List<Response> responses = new ArrayList<>(0);
        int snippetCounter = 0;
        while (snippetCounter < snippets.size()) {

            final Snippet snippet = Snippet.buildSnippetFromValues(snippetCounter, snippets);

            final Move move = Move.buildMove(plateauBuilder.getPlateau(), snippet);

            move.moveRobotWithOperations(snippet.getOperations());
            responses.add(new Response(move));

            snippetCounter = snippetCounter + 4;
        }
        return responses;
    }


    private String[] snippetsFrom(String partial) {
        return partial.split("\\s+");
    }

    private String snippetsFrom(String input, String[] snippetWithGrid) {
        return input.substring(snippetWithGrid[0].length() + snippetWithGrid[1].length() + 2);
    }

    private PlateauBuilder plateauBuilderFrom(String[] snippetWithGrid) {
        return new PlateauBuilder(snippetWithGrid);
    }
}
