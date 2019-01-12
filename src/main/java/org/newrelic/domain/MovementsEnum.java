package org.newrelic.domain;

import java.util.Arrays;

public enum MovementsEnum {

    L(Contants.LEFT),R(Contants.RIGHT),M(Contants.MOVE);

    private String movement;
    MovementsEnum(String movement) {
        this.movement = movement;
    }

    public static boolean find(String value){
        return Arrays.stream(values()).anyMatch(val->val.movement.equals(value));
    }
}
