package org.cliveford.poker;

import java.util.HashMap;

public class HandRankValue {

    private final int RANKVALUE;

    public HandRankValue(String rank) {
        HashMap<String, Integer> RANKVALUES = new HashMap<>();
        RANKVALUES.put("high card", 1);
        RANKVALUES.put("pair", 20);
        RANKVALUES.put("two pairs", 40);
        RANKVALUES.put("three of a kind", 60);
        RANKVALUES.put("straight", 80);
        RANKVALUES.put("flush", 100);
        RANKVALUES.put("full house", 120);
        RANKVALUES.put("four of a kind", 140);
        RANKVALUES.put("straight flush", 160);
        this.RANKVALUE = RANKVALUES.get(rank);
    }

    public int getRankValue() {
        return this.RANKVALUE ;
    }
}
