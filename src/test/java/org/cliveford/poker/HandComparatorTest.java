package org.cliveford.poker;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandComparatorTest {

    @Test
    @DisplayName("Royal flush should tie with Royal flush")
    public void checkThatRoyalFlushTiesWithRoyalFlush()
    {
        String input = "Black: TS JS QS KS AS  White: TH JH QH KH AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "Tie.";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Higher straight flush should beat lower straight flush")
    public void checkThatHigherStraightFlushBeatLowerStraightFlush()
    {
        String input = "Black: 5S 6S 7S 8S 9S  White: TH JH QH KH AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "White wins. - with straight flush: Ace high";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Straight flush should beat four of a kind")
    public void checkThatStraightFlushBeatQuads()
    {
        String input = "Black: 5S 6S 7S 8S 9S  White: 4H 4C 4H 8H 4D";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "Black wins. - with straight flush: Nine high";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Four of a kind should beat full house")
    public void checkThatQuadsBeatFullHouse()
    {
        String input = "Black: 5H 5D 5S 4C 4D  White: 4H 4C 4H 8H 4D";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "White wins. - with four of a kind: Fours";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Higher four of a kind should beat lower four of a kind")
    public void checkThatHigherQuadsBeatLowerQuads()
    {
        String input = "Black: 5H 5D 5S 4C 4D  White: 9H 9C 9S 9D QD";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "White wins. - with four of a kind: Nines";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Full House should beat flush")
    public void checkThatFullHouseBeatsFlush()
    {
        String input = "Black: 5H 5D 5S 4C 4D  White: 2H 3H 4H 8H AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "Black wins. - with full house: Fives/Fours";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Higher Full House should beat lower Full House")
    public void checkThatHigherFullHouseBeatsLowerFullHouse()
    {
        String input = "Black: 5H 5D 5S 4C 4D  White: 7H 7S 7C 3H 3S";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "White wins. - with full house: Sevens/Threes";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Flush should beat King high")
    public void checkThatFlushBeatsKingHigh()
    {
        String input = "Black: 5H 2D 3S 8C KD  White: 2H 3H 4H 8H AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "White wins. - with flush: Ace high";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Flush should beat pair")
    public void checkThatFlushBeatsPair()
    {
        String input = "Black: 2C 2D 5S 7C KD  White: 2H 3H 4H 8H QH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "White wins. - with flush: Queen high";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Flush should beat two pair")
    public void checkThatFlushBeatsTwoPair()
    {
        String input = "Black: 2C 2D 5S 5C KD  White: 2H 3H 4H 8H JH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "White wins. - with flush: Jack high";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Flush should beat three of a kind")
    public void checkThatFlushBeatsTrips()
    {
        String input = "Black: 2C 2D 2S 5C KD  White: 2H 3H 4H 8H TH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "White wins. - with flush: Ten high";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Flush should beat straight")
    public void checkThatFlushBeatsStraight()
    {
        String input = "Black: 5H 6D 7S 8C 9D  White: 2H 3H 4H 8H KH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "White wins. - with flush: King high";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Higher flush should beat lower flush")
    public void checkThatHigherFlushBeatsLowerFlush()
    {
        String input = "Black: 5S 6S 7S 8S TS  White: 2H 3H 4H 8H 5H";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "Black wins. - with flush: Ten high";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Higher kicker should beat lower kicker when flushes have same high card")
    public void checkThatBestKickerPlaysWhenFlushesHaveSameHighCard()
    {
        String input = "Black: 5S 6S 7S 8S TS  White: 2H 3H 4H TH 5H";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "Black wins. - with flush: Ten high & Eight kicker";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Higher straight should beat lower straight")
    public void checkThatHigherStraightBeatsLowerStraight()
    {
        String input = "Black: 5C 6S 7D 8S 9S  White: TH JC QS KH AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "White wins. - with straight: Ace high";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Straight should beat three of a kind")
    public void checkThatStraightBeatsTrips()
    {
        String input = "Black: 5C 6S 7D 8S 9S  White: 3H 3C 3S 8H 5H";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "Black wins. - with straight: Nine high";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Straight should beat two pair")
    public void checkThatStraightBeatsTwoPair()
    {
        String input = "Black: 5C 6S 7D 8S 9S  White: 3H 3C 8C 8H AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "Black wins. - with straight: Nine high";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Straight should beat pair")
    public void checkThatStraightBeatsPair()
    {
        String input = "Black: 5C 6S 7D 8S 9S  White: 3H 3C 8C 9C AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "Black wins. - with straight: Nine high";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Straight should beat high card")
    public void checkThatStraightBeatsHighCard()
    {
        String input = "Black: 5C 6S 7D 8S 9S  White: 3H 2C 8C 9C AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "Black wins. - with straight: Nine high";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Higher trips should beat lower trips")
    public void checkThatHigherTripsBeatLowerTrips()
    {
        String input = "Black: 5C 5S 5D 8S 9S  White: 3H 3C 3H 9C AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "Black wins. - with three of a kind: Fives";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Trips should beat two pair")
    public void checkThatTripsBeatTwoPair()
    {
        String input = "Black: 5C 5S 5D 8S 9S  White: 3H 3C 9H 9C AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "Black wins. - with three of a kind: Fives";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Trips should beat pair")
    public void checkThatTripsBeatPair()
    {
        String input = "Black: 5C 5S 5D 8S 9S  White: 3H 2C 9H 9C AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "Black wins. - with three of a kind: Fives";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Trips should beat high card")
    public void checkThatTripsBeatHighCard()
    {
        String input = "Black: 5C 5S 5D 8S 9S  White: 3H 2C 8H 9C AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "Black wins. - with three of a kind: Fives";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Higher two pair should beat lower two pair")
    public void checkThatHigherTwoPairBeatLowerTwoPair()
    {
        String input = "Black: 5C 5S 8D 8S 9S  White: 3H 3C 9H 9C AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "White wins. - with two pair: Nines/Threes";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Higher kicker should beat lower kicker when players have same two pair")
    public void checkThatHigherKickerBeatLowerKickerWhenPlayersHaveSameTwoPair()
    {
        String input = "Black: 5C 5S 8D 8S 9S  White: 5H 5C 8H 8C AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "White wins. - with two pair: Eights/Fives & Ace kicker";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Two pair should beat one pair")
    public void checkThatTwoPairBeatOnePair()
    {
        String input = "Black: 5C 5S 8D 8S 9S  White: 3H 3C 7H 9C AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "Black wins. - with two pair: Eights/Fives";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Two pair should beat high card")
    public void checkThatTwoPairBeatHighCard()
    {
        String input = "Black: 5C 5S 8D 8S 9S  White: 3H KC 7H 9C AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "Black wins. - with two pair: Eights/Fives";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Higher pair should beat lower pair")
    public void checkThatHigherPairBeatLowerPair()
    {
        String input = "Black: 3C 4S 8D 8S 9S  White: KH KC 7H 9C AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "White wins. - with pair: Kings";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Higher kicker should beat lower kicker when players have same pair")
    public void checkThatHigherKickerBeatLowerKickerWhenPlayersHaveSamePair()
    {
        String input = "Black: 3C 4S KD KS 9S  White: KH KC 7H 9C 2H";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "White wins. - with pair: Kings & Seven kicker";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Pair should beat high card")
    public void checkThatPairBeatHighCard()
    {
        String input = "Black: 3C 4S 8D 8S 9S  White: QH KC 7H 9C AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "Black wins. - with pair: Eights";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Higher first kicker should beat lower first kicker when neither player had made hand")
    public void checkThatHigherFirstKickerBeatLowerFirstKicker()
    {
        String input = "Black: 3C 6S 8D TS KS  White: 4H 7C 9H JC AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "White wins. - with high card: Ace";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Higher last kicker should beat lower last kicker when neither player had made hand")
    public void checkThatHigherLastKickerBeatLowerLastKicker()
    {
        String input = "Black: 3C 7S 9D JS AS  White: 4H 7C 9H JC AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "White wins. - with high card: Four";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Higher middle kicker should beat lower middle kicker when neither player had made hand")
    public void checkThatHigherMiddleKickerBeatLowerMiddleKicker()
    {
        String input = "Black: 4C 7S 9D JS AS  White: 4H 7C TH JC AH";
        HandComparator handComparator = new HandComparator(input);
        String expectedValue = "White wins. - with high card: Ten";
        String actualValue = handComparator.getWinningHand();
        assertEquals(expectedValue, actualValue);
    }

    @Disabled
    @Test
    public void checkThatPairDetectionDetectsPair()
    {
        String input = "Black: 2H 4D 2S 5C KD  White: 2H 3C 4H 8H AH";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 2;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Disabled
    @Test
    public void checkThatTwoPairDetectionDetectsTwoPair()
    {
        String input = "Black: 2H 4D 2S 4C KD  White: 2H 3C 4H 8H AH";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 3;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Disabled
    @Test
    public void checkThatFullHouseDetectionDetectsFullHouse()
    {
        String input = "Black: 2H 4D 2S 4C 4H  White: 2H 3C 7H 8H AH";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 7;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Disabled
    @Test
    public void checkThatStraightDetectionDetectsStraight()
    {
        String input = "Black: 2H 3D 2S 4C 4H  White: JH TC 9S 8H QH";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 5;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Disabled
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

    @Disabled
    @Test
    public void checkThatWhiteHandWinsWhenBothHaveStraights()
    {
        String input = "Black: 2H 3D 4S 5C 6H  White: 3H 4H 5D 6S 7C";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 12;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Disabled
    @Test
    public void checkThatBlackHandWinsWhenBothHaveStraights()
    {
        String input = "Black: 8H 9D TS JC QH  White: 3H 4H 5D 6S 7C";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 17;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Disabled
    @Test
    public void checkThatBlackHandWinsWhenBothHaveFlushes()
    {
        String input = "Black: 8H 6H TH JH QH  White: 3S 4S 5S 6S 8S";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 18;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Disabled
    @Test
    public void checkThatWhiteHandWinsWhenBothHaveFlushes()
    {
        String input = "Black: 8H 6H TH JH QH  White: 3S 4S 5S 6S AS";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 20;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Disabled
    @Test
    public void checkThatWhiteHandWinsWhenBothHaveTrips()
    {
        String input = "Black: 8H 8C 8S JD QH  White: TS TC TC 6S AS";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 14;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Disabled
    @Test
    public void checkThatBlackHandWinsWhenBothHaveTrips()
    {
        String input = "Black: KH KC KS JD QH  White: TS TC TC 6S AS";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 17;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Disabled
    @Test
    public void checkThatBlackHandWinsWhenBothHaveTwoPair()
    {
        String input = "Black: KH QC JS JD QH  White: TS TC 6C 6S AS";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 15;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Disabled
    @Test
    public void checkThatWhiteHandWinsWhenBothHaveTwoPair()
    {
        String input = "Black: KH QC JS JD QH  White: AC TC 6C 6S AS";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 17;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Disabled
    @Test
    public void checkThatWhiteHandWinsWhenBothHaveOnePair()
    {
        String input = "Black: KH QC 8S JD QH  White: AC TC 7C 6S AS";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 16;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

    @Disabled
    @Test
    public void checkThatBlackHandWinsWhenBothHaveOnePair()
    {
        String input = "Black: 4H QC 8S JD 4S  White: 3C TC 7C 3S AS";
        HandComparator handComparator = new HandComparator(input);
        int expectedValue = 6;
        int actualValue = Integer.parseInt(handComparator.getWinningHand());
        assertEquals(expectedValue, actualValue);
    }

}
