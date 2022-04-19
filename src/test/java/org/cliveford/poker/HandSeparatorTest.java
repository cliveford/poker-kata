package org.cliveford.poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandComparatorTest {

    @Test
    public void checkThatCorrectPlayersHandIsExtractedFromInput()
    {
        HandSeparator handSeparator = new HandSeparator("white");
        String expectedHand = "2C 3H 4S 8C AH";
        int actualHand = handSeparator.getHand();
        assertEquals(expectedHand, actualHand);
    }

}
