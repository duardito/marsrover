package org.newrelic.domain.movements;

import org.newrelic.domain.Contants;

import java.util.HashMap;
import java.util.Map;

public class CardinalRegister {

    public Map<String, ICardinalHandler> handle(){
        Map<String, ICardinalHandler> map = new HashMap<>();
        map.put(Contants.SOUTH, new CardinalToSouth());
        map.put(Contants.NORTH, new CardinalToNorth());
        map.put(Contants.WEST, new CardinalToWest());
        map.put(Contants.EAST, new CardinalToEast());
        return map;
    }
}
