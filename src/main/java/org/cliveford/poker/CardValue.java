package org.cliveford.poker;

import java.util.HashMap;

public class CardValue {

    private final int CARDVALUE;

    public CardValue(String card) {
        HashMap<String, Integer> CARDVALUES = new HashMap<>();
        CARDVALUES.put("A", 14);
        CARDVALUES.put("K", 13);
        CARDVALUES.put("Q", 12);
        CARDVALUES.put("J", 11);
        CARDVALUES.put("T", 10);
        CARDVALUES.put("9", 9);
        CARDVALUES.put("8", 8);
        CARDVALUES.put("7", 7);
        CARDVALUES.put("6", 6);
        CARDVALUES.put("5", 5);
        CARDVALUES.put("4", 4);
        CARDVALUES.put("3", 3);
        CARDVALUES.put("2", 2);
        this.CARDVALUE = CARDVALUES.get(card);
    }

    public int getCardValue() {
        return this.CARDVALUE ;
    }
}
