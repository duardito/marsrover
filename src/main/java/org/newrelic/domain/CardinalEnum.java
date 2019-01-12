package org.newrelic.domain;

import java.util.Arrays;

public enum CardinalEnum {

    N(Contants.NORTH),W(Contants.WEST),S(Contants.SOUTH),E(Contants.EAST);

    private String cardinal;

    CardinalEnum(String cardinal) {
        this.cardinal = cardinal;
    }

    public static boolean find(String value){
        return Arrays.stream(values()).anyMatch(val->val.cardinal.equals(value));
    }
}
