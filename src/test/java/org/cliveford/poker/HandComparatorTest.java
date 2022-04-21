package org.cliveford.poker;

import org.junit.jupiter.api.Disabled;
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

    @Test
    public void checkThatStraightFlushDetectionDetectsStraightFlush()
    {
        String input = "Black: 2H 3D 2S 4C 4H  White: JH TH 9H 8H QH";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 9;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Disabled
    @Test
    public void checkThatHighCardDetectionDetectsHighCard()
    {
        String input = "Black: 2H 3D 6S 4C 8H  White: 3H TH 9C 8H QH";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 1;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Disabled
    @Test
    public void checkThatNoMadeHandReturnsTotalOfAllCardsInHand()
    {
        String input = "Black: 2H 3D 6S 4C 8H  White: 7H TH 9C 8H 2C";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 36;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkThatWhiteHandWinsWhenBothHaveStraights()
    {
        String input = "Black: 2H 3D 4S 5C 6H  White: 3H 4H 5D 6S 7C";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 12;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkThatBlackHandWinsWhenBothHaveStraights()
    {
        String input = "Black: 8H 9D TS JC QH  White: 3H 4H 5D 6S 7C";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 17;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkThatBlackHandWinsWhenBothHaveFlushes()
    {
        String input = "Black: 8H 6H TH JH QH  White: 3S 4S 5S 6S 8S";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 18;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkThatWhiteHandWinsWhenBothHaveFlushes()
    {
        String input = "Black: 8H 6H TH JH QH  White: 3S 4S 5S 6S AS";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 20;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkThatWhiteHandWinsWhenBothHaveTrips()
    {
        String input = "Black: 8H 8C 8S JD QH  White: TS TC TC 6S AS";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 14;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkThatBlackHandWinsWhenBothHaveTrips()
    {
        String input = "Black: KH KC KS JD QH  White: TS TC TC 6S AS";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 17;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkThatBlackHandWinsWhenBothHaveTwoPair()
    {
        String input = "Black: KH QC JS JD QH  White: TS TC 6C 6S AS";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 15;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkThatWhiteHandWinsWhenBothHaveTwoPair()
    {
        String input = "Black: KH QC JS JD QH  White: AC TC 6C 6S AS";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 17;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkThatWhiteHandWinsWhenBothHaveOnePair()
    {
        String input = "Black: KH QC 8S JD QH  White: AC TC 7C 6S AS";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 16;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkThatBlackHandWinsWhenBothHaveOnePair()
    {
        String input = "Black: 4H QC 8S JD 4S  White: 3C TC 7C 3S AS";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 6;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkThatHighestKickerWinsWhenBothPlayersHaveSameTwoPair()
    {
        String input = "Black: QH QC JS JD 4S  White: QS QD JC JH AS";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "white";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkThatHighestKickerWinsWhenBothPlayersHaveSamePair()
    {
        String input = "Black: QH QC JS TD AC  White: QS QD 2C 5H AS";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "black";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkThatCorrectHandWinsWhenNeitherPlayerHasMadeHand()
    {
        String input = "Black: 8H 2C 9S KD AC  White: 8S 3D 9C KH AS";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "white";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkThatCorrectHandWinsBothPlayersHaveAnAceHighFlush()
    {
        String input = "Black: AH QH TH 5H 3H  White: AS QS TS 6S 2S";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "white";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkThatTieIsReturnedWhenHandsAreEqual()
    {
        String input = "Black: AH QS TH 6H 3H  White: AS QH TS 6S 3S";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "Tie.";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }



}
