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
        this.CARDVALUE = CARDVALUES.get(card);
    }

    public int getCardValue() {
        return this.CARDVALUE ;
    }
}
