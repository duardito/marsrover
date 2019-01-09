package org.newrelic.domain.operations;

import org.newrelic.domain.Move;

public interface IOperationHandler {

    boolean validateOperation(Move move) throws Exception;

}
