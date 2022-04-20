package org.cliveford.poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandComparatorTest {

    @Test
    public void checkThatFlushDetectionDetectsFlush()
    {
        String input = "Black: 2H 3D 5S 9C KD  White: 2H 3H 4H 8H AH";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 5;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

}
