package org.newrelic.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class SnippetBuilder {

    List<String> dataToBuildSnippets = new ArrayList<>();

    public SnippetBuilder(String dataToBuild) {
        this.dataToBuildSnippets = Arrays.asList(Pattern.compile("\\s+").split(dataToBuild));
    }

    public List<String> getDataToBuildSnippets() {
        return dataToBuildSnippets;
    }
}
