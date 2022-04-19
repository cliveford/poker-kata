package org.cliveford.poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardValueTest {

    @Test
    public void CheckForCardValue()
    {
        int expectedValue = 13;
        int actualValue = CardValue.getCardValue("K");
        assertEquals(expectedValue, actualValue);
    }
}
