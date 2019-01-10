package org.newrelic.infraestructure;

import com.google.gson.Gson;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.newrelic.domain.IMoveRobot;
import org.newrelic.domain.MoveRobotService;
import org.newrelic.domain.Response;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarsHandler implements HttpHandler {

    private static IMoveRobot iMoveRobot;

    public MarsHandler() {
        if (iMoveRobot == null) {
            iMoveRobot = new MoveRobotService();
        }
    }

    private Map<String, String> getParamsMap(HttpExchange httpExchange) throws IOException {
        final InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
        final BufferedReader br = new BufferedReader(isr);
        final String query = br.readLine();

        return queryToMap(query);
    }

    private static Map<String, String> queryToMap(final String query) {

        Map<String, String> result = new HashMap<String, String>();
        for (String param : query.split("&")) {
            String pair[] = param.split("=");
            if (pair.length > 1) {
                result.put(pair[0], pair[1]);
            } else {
                result.put(pair[0], "");
            }
        }
        return result;
    }

    public void BaseMessageWrapper(final OutputStream out, List<Response> data) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (Response response : data) {
            sb.append(response);
        }
        final Gson gson = new Gson();
        final Writer w = new OutputStreamWriter(out);
        w.write(gson.toJson(sb));
        w.flush();
        w.close();
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        Headers headers = httpExchange.getResponseHeaders();
        headers.add("Access-Control-Allow-Headers", "x-uw-act-as, Origin, X-Requested-With, Content-Type, Accept, Authorization");
        headers.add("Access-Control-Allow-Methods", "GET,POST,PUT,OPTIONS");
        headers.add("Access-Control-Allow-Origin", "*");

        final Map<String, String> queryMap = getParamsMap(httpExchange);
        String input = queryMap.get("moves");
        input = input.replace("+", " ");
        List<Response> data = iMoveRobot.moveRobotsOverMars(input);
        httpExchange.sendResponseHeaders(200, 0);
        BaseMessageWrapper(httpExchange.getResponseBody(), data);
    }
}
