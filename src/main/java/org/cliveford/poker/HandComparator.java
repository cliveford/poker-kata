package org.cliveford.poker;

import org.apache.commons.lang3.StringUtils;

public class HandComparator {

    private String winningHand;
    private String inputHands;

    public HandComparator(String inputHands) {

        this.inputHands = inputHands;
        this.winningHand = calculateWinningHand(this.inputHands);

    }

    private String calculateWinningHand(String inputHands) {
        // get each hand
        String black = inputHands.substring(7, 21).trim();
        System.out.println("black hand - " + black);
        String white = inputHands.substring(30, 44).trim();
        System.out.println("white hand - " + white);
        int blackHandStrength = Integer.parseInt(calculateHandStrength(black));
        int whiteHandStrength = Integer.parseInt(calculateHandStrength(white));
        if (blackHandStrength > whiteHandStrength) {
            this.winningHand = String.valueOf(blackHandStrength);
        } else {
            this.winningHand = String.valueOf(whiteHandStrength);
        }



        return this.winningHand;
    }

    private String calculateHandStrength(String hand) {
        // check if we have 5 of any 1 suit
        int handValue = 0;
        if(checkForFlush(hand)) {
           handValue += getRankValue("flush");
            System.out.println("should be value for flush" + handValue);
        } else {
            handValue = 1;
        }
        int hearts = StringUtils.countMatches(hand, "H");
        int clubs = StringUtils.countMatches(hand, "C");
        int diamonds = StringUtils.countMatches(hand, "D");
        int spades = StringUtils.countMatches(hand, "S");
        int two = StringUtils.countMatches(hand, "2");
        int three = StringUtils.countMatches(hand, "3");
        int four = StringUtils.countMatches(hand, "4");
        int five = StringUtils.countMatches(hand, "5");
        int six = StringUtils.countMatches(hand, "6");
        int seven = StringUtils.countMatches(hand, "7");
        int eight = StringUtils.countMatches(hand, "8");
        int nine = StringUtils.countMatches(hand, "9");
        int ten = StringUtils.countMatches(hand, "T");
        int jack = StringUtils.countMatches(hand, "J");
        int queen = StringUtils.countMatches(hand, "Q");
        int king = StringUtils.countMatches(hand, "K");
        int ace = StringUtils.countMatches(hand, "A");

        System.out.println("hearts - " + hearts);
        return Integer.toString(handValue) ; //handStrength;
    }

    private int getRankValue(String rank) {
        HandRankValue handRankValue = new HandRankValue(rank);
        return handRankValue.getRankValue();
    }

    private boolean checkForFlush(String hand) {
        int hearts = StringUtils.countMatches(hand, "H");
        int clubs = StringUtils.countMatches(hand, "C");
        int diamonds = StringUtils.countMatches(hand, "D");
        int spades = StringUtils.countMatches(hand, "S");
        if (hearts == 5 || clubs == 5 || diamonds == 5|| spades == 5) {
            return true;
        }
        return false;
    }

    public String getWinningHand() {
        return this.winningHand;
    }
}
