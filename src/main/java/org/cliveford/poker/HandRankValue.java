package org.cliveford.poker;

import java.util.HashMap;

public class HandRankValue {

    private final int RANKVALUE;

    public HandRankValue(String rank) {
        HashMap<String, Integer> RANKVALUES = new HashMap<>();
        RANKVALUES.put("high card", 1);
        RANKVALUES.put("pair", 2);
        RANKVALUES.put("two pairs", 3);
        RANKVALUES.put("three of a kind", 4);
        RANKVALUES.put("straight", 5);
        RANKVALUES.put("flush", 6);
        RANKVALUES.put("full house", 7);
        RANKVALUES.put("four of a kind", 8);
        RANKVALUES.put("straight flush", 9);
        this.RANKVALUE = RANKVALUES.get(rank);
    }

    public int getRankValue() {
        return this.RANKVALUE ;
    }
}
