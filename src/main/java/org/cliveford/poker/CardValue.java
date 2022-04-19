package org.cliveford.poker;

import java.util.HashMap;

public class CardValue {

    private String card;
    private int cardValue;
    private HashMap<String, Integer> cardValues = new HashMap<>();

    public CardValue(String card) {
        this.card = card;
        this.cardValues.put("K", 13);
        this.cardValue = this.cardValues.get(this.card);
    }

    public int getCardValue() {
        return this.cardValue ;
    }
}
