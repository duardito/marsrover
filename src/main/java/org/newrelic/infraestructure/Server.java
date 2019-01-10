package org.newrelic.infraestructure;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    private static HttpServer server;

    public static void startServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress(15000), 0);
        server.createContext("/", new BaseHandler());
        server.start();
    }

    public static void stopServer() throws IOException {
        server.stop(1);
    }
}
