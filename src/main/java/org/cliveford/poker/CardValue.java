package org.cliveford.poker;

import java.util.HashMap;

public class CardValue {

    private final String CARDVALUE;

    public CardValue(int card) {
        HashMap<Integer, String> CARDVALUES = new HashMap<>();
        CARDVALUES.put(14, "Ace");
        CARDVALUES.put(13, "King");
        CARDVALUES.put(12, "Queen");
        CARDVALUES.put(11, "Jack");
        CARDVALUES.put(10, "Ten");
        CARDVALUES.put(9, "Nine");
        CARDVALUES.put(8, "Eight");
        CARDVALUES.put(7, "Seven");
        CARDVALUES.put(6, "Six");
        CARDVALUES.put(5, "Five");
        CARDVALUES.put(4, "Four");
        CARDVALUES.put(3, "Three");
        CARDVALUES.put(2, "Two");
        this.CARDVALUE = CARDVALUES.get(card);
    }

    public String getCardValue() {
        return this.CARDVALUE ;
    }
}
