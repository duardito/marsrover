package org.newrelic;

import org.newrelic.infraestructure.Server;

public class Main {


    public static void main(String[] a) throws Exception {

        Server.startServer();
/*
        String input = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM 2 3 W LMLMLMLMM";

        MoveRobotService moveRobotService = new MoveRobotService();
        List<Response> responses = moveRobotService.moveRobotsOverMars(input);
        responses.forEach(System.out::println);
  */
    }


}
