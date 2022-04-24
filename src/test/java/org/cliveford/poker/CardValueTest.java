package org.cliveford.poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardValueTest {

    @Test
    public void checkForCardValue()
    {
        CardValue cardValue = new CardValue(13);
        String expectedValue = "King";
        String actualValue = cardValue.getCardValue();
        assertEquals(expectedValue, actualValue);
    }

}
