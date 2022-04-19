package org.cliveford.poker;

import java.util.HashMap;

public class CardValue {
    String card;
    HashMap<String, Integer> cardValue = new HashMap<>();

    public CardValue(String card) {
        this.card = card;
    }

    public static int getCardValue(String card) {
        return 0;
    }
}
