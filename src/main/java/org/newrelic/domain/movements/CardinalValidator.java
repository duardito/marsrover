package org.newrelic.domain.movements;

import org.newrelic.domain.CardinalEnum;

public class CardinalValidator {

    public static boolean validate(String orientation){
        return CardinalEnum.find(orientation);
    }
}
