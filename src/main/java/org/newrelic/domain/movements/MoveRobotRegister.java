package org.newrelic.domain.movements;

import org.newrelic.domain.Contants;

import java.util.HashMap;
import java.util.Map;

public class MoveRobotRegister {

    public Map<String, IMoveRobotHandler> handle(){
        Map<String, IMoveRobotHandler> map = new HashMap<>();
        map.put(Contants.SOUTH, new MoveToSouth());
        map.put(Contants.NORTH, new MoveToNorth());
        map.put(Contants.WEST, new MoveToWest());
        map.put(Contants.EAST, new MoveToEast());
        return map;
    }
}
