package org.cliveford.poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandRankValueTest {

    @Test
    public void checkForHandRankValue()
    {
        HandRankValue handRankValue = new HandRankValue("high card");
        int expectedValue = 1;
        int actualValue = handRankValue.getRankValue();
        assertEquals(expectedValue, actualValue);
    }

}
