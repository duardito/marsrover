package org.newrelic.domain.operations;

import org.newrelic.domain.MovementsEnum;

public class OperationValidator {

    public static boolean validate(String orientation){
        return MovementsEnum.find(orientation);
    }
}
