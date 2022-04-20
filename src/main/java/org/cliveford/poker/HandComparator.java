package org.cliveford.poker;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

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
        System.out.println("black hand strength = " + blackHandStrength);
        System.out.println("white hand strength = " + whiteHandStrength);
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
        if (checkForQuads(hand)) {
            handValue += getRankValue("four of a kind");
            System.out.println("we have quads");
        } else if (checkForFullHouse(hand)) {
            handValue += getRankValue("full house");
            System.out.println("we have full house");
        } else if (checkForFlush(hand)) {
            handValue += getRankValue("flush");
            System.out.println("we have flush");
        } else if (checkForTrips(hand)) {
            handValue += getRankValue("three of a kind");
            System.out.println("we have trips");
        } else if (checkForTwoPair(hand)) {
            handValue += getRankValue("two pairs");
            System.out.println("we have two pair");
        } else if (checkForPair(hand)) {
            handValue += getRankValue("pair");
            System.out.println("we have pair");
        } else {
            handValue = 1;
        }


        return Integer.toString(handValue); //handStrength;
    }

    private HashMap<String, Integer> countOccurences(String hand) {
        HashMap<String, Integer> map = new HashMap<>();
        int two = StringUtils.countMatches(hand, "2");
        if (two >= 2) {
            map.put("two", two);
        }
        int three = StringUtils.countMatches(hand, "3");
        if (three >= 2) {
            map.put("three", three);
        }
        int four = StringUtils.countMatches(hand, "4");
        if (four >= 2) {
            map.put("four", four);
        }
        int five = StringUtils.countMatches(hand, "5");
        if (five >= 2) {
            map.put("five", five);
        }
        int six = StringUtils.countMatches(hand, "6");
        if (six >= 2) {
            map.put("six", six);
        }
        int seven = StringUtils.countMatches(hand, "7");
        if (seven >= 2) {
            map.put("seven", seven);
        }
        int eight = StringUtils.countMatches(hand, "8");
        if (eight >= 2) {
            map.put("eight", eight);
        }
        int nine = StringUtils.countMatches(hand, "9");
        if (nine >= 2) {
            map.put("nine", nine);
        }
        int ten = StringUtils.countMatches(hand, "T");
        if (ten >= 2) {
            map.put("ten", ten);
        }
        int jack = StringUtils.countMatches(hand, "J");
        if (jack >= 2) {
            map.put("jack", jack);
        }
        int queen = StringUtils.countMatches(hand, "Q");
        if (queen >= 2) {
            map.put("queen", queen);
        }
        int king = StringUtils.countMatches(hand, "K");
        if (king >= 2) {
            map.put("king", king);
        }
        int ace = StringUtils.countMatches(hand, "A");
        if (ace >= 2) {
            map.put("ace", ace);
        }
        return map;
    }


    private boolean checkForFullHouse(String hand) {
        if (checkForTrips(hand) && checkForPair(hand)) {
            return true;
        }
        return false;
    }

    private boolean checkForTwoPair(String hand) {
        HashMap<String, Integer> map = countOccurences(hand);
        int pairCounter = 0;
        for (Integer cardValue : map.values()) {
            if (cardValue == 2) {
                pairCounter += 1;
                if (pairCounter == 2) {
                    System.out.println("yay we have two pair");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkForPair(String hand) {
        HashMap<String, Integer> map = countOccurences(hand);
        for (Integer cardValue : map.values()) {
            if (cardValue == 2) {
                System.out.println("yay we have pair");
                return true;
            }
        }
        return false;
    }

    private boolean checkForTrips(String hand) {
        HashMap<String, Integer> map = countOccurences(hand);
        for (Integer cardValue : map.values()) {
            if (cardValue == 3) {
                System.out.println("yay we have trips");
                return true;
            }
        }
        return false;
    }

    private boolean checkForQuads(String hand) {
        HashMap<String, Integer> map = countOccurences(hand);
        for (Integer cardValue : map.values()) {
            if (cardValue == 4) {
                System.out.println("yay we have quads");
                return true;
            }
        }
        return false;
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
        if (hearts == 5 || clubs == 5 || diamonds == 5 || spades == 5) {
            return true;
        }
        return false;
    }

    public String getWinningHand() {
        return this.winningHand;
    }
}
