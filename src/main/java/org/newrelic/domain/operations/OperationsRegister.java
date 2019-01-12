package org.newrelic.domain.operations;

import org.newrelic.domain.Contants;

import java.util.HashMap;
import java.util.Map;

public class OperationsRegister {

    public Map<String, IOperationHandler> handle(){
        Map<String, IOperationHandler> map = new HashMap<>();
        map.put(Contants.LEFT, new OperationToLeft());
        map.put(Contants.RIGHT, new OperationToRight());
        map.put(Contants.MOVE, new OperationToForward());
        return map;
    }
}
