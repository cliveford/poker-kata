package org.cliveford.poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandSeparatorTest {

    @Test
    public void checkThatCorrectPlayersHandIsExtractedFromInput()
    {
        HandSeparator handSeparator = new HandSeparator("Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH", "White");
        String expectedHand = "2C 3H 4S 8C AH";
        String actualHand = handSeparator.getPlayerHand();
        assertEquals(expectedHand, actualHand);
    }

}
