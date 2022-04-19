package org.cliveford.poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardValueTest {

    @Test
    public void CheckForCardValue()
    {
        CardValue cardValue = new CardValue("K");
        int expectedValue = 13;
        int actualValue = cardValue.getCardValue();
        assertEquals(expectedValue, actualValue);
    }
}
