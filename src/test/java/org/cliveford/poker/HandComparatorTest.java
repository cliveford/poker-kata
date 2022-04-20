package org.cliveford.poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandComparatorTest {

    @Test
    public void checkThatFlushDetectionDetectsFlush()
    {
        String input = "Black: 2H 3D 5S 9C KD  White: 2H 3H 4H 8H AH";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 6;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }



    @Test
    public void checkThatQuadDetectionDetectsQuads()
    {
        String input = "Black: 2H 2D 2S 2C KD  White: 2H 3H 4H 8H AH";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 8;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkThatTripsDetectionDetectsTrips()
    {
        String input = "Black: 2H 4D 2S 2C KD  White: 2H 3C 4H 8H AH";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 4;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkThatPairDetectionDetectsPair()
    {
        String input = "Black: 2H 4D 2S 5C KD  White: 2H 3C 4H 8H AH";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 2;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkThatTwoPairDetectionDetectsTwoPair()
    {
        String input = "Black: 2H 4D 2S 4C KD  White: 2H 3C 4H 8H AH";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 3;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkThatFullHouseDetectionDetectsFullHouse()
    {
        String input = "Black: 2H 4D 2S 4C 4H  White: 2H 3C 7H 8H AH";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 7;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkThatStraightDetectionDetectsStraight()
    {
        String input = "Black: 2H 3D 2S 4C 4H  White: JH TC 9S 8H QH";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 5;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

}
