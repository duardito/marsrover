package org.newrelic.infraestructure;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class BaseHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        new MarsHandler().handle(httpExchange);
    }
}
