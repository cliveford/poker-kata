package org.cliveford.poker;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.TreeMap;

public class HandComparator {

    private String winningHand;
    private String inputHands;
    private int highCard;
    private int kicker;
    private int whiteHighCard;
    private int blackHighCard;
    private int whiteFirstKicker;
    private int blackFirstKicker;
    private int whiteSecondKicker;
    private int blackSecondKicker;
    private int whiteThirdKicker;
    private int blackThirdKicker;
    private int whiteFourthKicker;
    private int blackFourthKicker;


    public HandComparator(String inputHands) {

        this.inputHands = inputHands;
        this.winningHand = calculateWinningHand(this.inputHands);

    }

    private String calculateWinningHand(String inputHands) {
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
        } else if (whiteHandStrength > blackHandStrength){
            this.winningHand = String.valueOf(whiteHandStrength);
        } else {
            // tie
            String winner = compareKickers(black, white);
            System.out.println("The winner is : " + winner);
        }


        return this.winningHand;
    }

    private String compareKickers(String black, String white) {
        int whiteKicker = 0;
        int blackKicker = 0;
        TreeMap<Integer, Integer> blackMap = countOccurences(black);
        System.out.println("mappety mapface black = " + blackMap);
        TreeMap<Integer, Integer> whiteMap = countOccurences(white);
        System.out.println("mappety mapface white = " + whiteMap);
        for (Map.Entry<Integer, Integer> card : blackMap.entrySet()){
            if (card.getValue() == 1) {
                blackKicker = card.getKey();
            }
        }
        for (Map.Entry<Integer, Integer> card : whiteMap.entrySet()){
            if (card.getValue() == 1) {
                whiteKicker = card.getKey();
            }
        }
        if (blackKicker > whiteKicker) {
            return "black";
        }

        return "white";

//        private boolean checkForPair(String hand) {
//            TreeMap<Integer, Integer> map = countOccurences(hand);
//            for (Map.Entry<Integer, Integer> card : map.entrySet()) {
//                if (card.getValue() == 2) {
//                    highCard = card.getKey();
//                    return true;
//                }
//            }
//            return false;
//        }



    }

    private String calculateHandStrength(String hand) {
        // check if we have 5 of any 1 suit
        int handValue = 0;
        if (checkForStraightFlush(hand)) {
            handValue += getRankValue("straight flush");
            System.out.println("we have straight flush");
        } else if (checkForQuads(hand)) {
            handValue += getRankValue("four of a kind");
            System.out.println("we have quads");
        } else if (checkForFullHouse(hand)) {
            handValue += getRankValue("full house");
            System.out.println("we have full house");
        } else if (checkForFlush(hand)) {
            handValue += getRankValue("flush") + highCard;
            System.out.println("we have flush");
        } else if (checkForTrips(hand)) {
            handValue += getRankValue("three of a kind") + highCard;
            System.out.println("we have trips");
        } else if (checkForTwoPair(hand)) {
            handValue += getRankValue("two pairs") + highCard;
            System.out.println("we have two pair");
        } else if (checkForPair(hand)) {
            handValue += getRankValue("pair") + highCard;
            System.out.println("we have pair");
        } else if (checkForStraight(hand)) {
            handValue += getRankValue("straight") + highCard;
            System.out.println("we have straight");
        } else {
            //handValue = 1;
            handValue += totalOfAllCardsInHand(hand);
            System.out.println("total of all cards");
        }


        return Integer.toString(handValue); //handStrength;
    }


    private TreeMap<Integer, Integer> countOccurences(String hand) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int two = StringUtils.countMatches(hand, "2");
        if (two > 0) {
            map.put(2, two);
        }
        int three = StringUtils.countMatches(hand, "3");
        if (three > 0) {
            map.put(3, three);
        }
        int four = StringUtils.countMatches(hand, "4");
        if (four > 0) {
            map.put(4, four);
        }
        int five = StringUtils.countMatches(hand, "5");
        if (five > 0) {
            map.put(5, five);
        }
        int six = StringUtils.countMatches(hand, "6");
        if (six > 0) {
            map.put(6, six);
        }
        int seven = StringUtils.countMatches(hand, "7");
        if (seven > 0) {
            map.put(7, seven);
        }
        int eight = StringUtils.countMatches(hand, "8");
        if (eight > 0) {
            map.put(8, eight);
        }
        int nine = StringUtils.countMatches(hand, "9");
        if (nine > 0) {
            map.put(9, nine);
        }
        int ten = StringUtils.countMatches(hand, "T");
        if (ten > 0) {
            map.put(10, ten);
        }
        int jack = StringUtils.countMatches(hand, "J");
        if (jack > 0) {
            map.put(11, jack);
        }
        int queen = StringUtils.countMatches(hand, "Q");
        if (queen > 0) {
            map.put(12, queen);
        }
        int king = StringUtils.countMatches(hand, "K");
        if (king > 0) {
            map.put(13, king);
        }
        int ace = StringUtils.countMatches(hand, "A");
        if (ace > 0) {
            map.put(14, ace);
        }
        return map;
    }


    private boolean checkForStraight(String hand) {
        TreeMap<Integer, Integer> map = countOccurences(hand);
        if (map.lastKey() - map.firstKey() == 4) {
            highCard = map.lastKey();
            return true;
        }
        return false;
    }

    private boolean checkForStraightFlush(String hand) {
        if (checkForFlush(hand) && checkForStraight(hand)) {
            return true;
        }
        return false;
    }

    private boolean checkForFullHouse(String hand) {
        if (checkForTrips(hand) && checkForPair(hand)) {
            return true;
        }
        return false;
    }


    private int totalOfAllCardsInHand(String hand) {
        int total = 0;
        TreeMap<Integer, Integer> map = countOccurences(hand);
        for (Integer cardValue : map.keySet()) {
            total += cardValue;
        }
        return total;
    }

    private boolean checkForPair2(String hand) {
        TreeMap<Integer, Integer> map = countOccurences(hand);
        for (Integer cardValue : map.values()) {
            if (cardValue == 2) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForPair(String hand) {
        TreeMap<Integer, Integer> map = countOccurences(hand);
        for (Map.Entry<Integer, Integer> card : map.entrySet()) {
            if (card.getValue() == 2) {
                highCard = card.getKey();
                return true;
            }
        }
        return false;
    }

    private boolean checkForTrips(String hand) {
        TreeMap<Integer, Integer> map = countOccurences(hand);
        for (Map.Entry<Integer, Integer> card : map.entrySet()) {
            if (card.getValue() == 3) {
                highCard = card.getKey();
                return true;
            }
        }
        return false;
    }

    private boolean checkForTwoPair(String hand) {
        TreeMap<Integer, Integer> map = countOccurences(hand);
        int pairCounter = 0;
        for (Map.Entry<Integer, Integer> card : map.entrySet()) {
            if (card.getValue() == 2) {
                pairCounter += 1;
                if (pairCounter == 2) {
                    highCard = card.getKey();
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkForQuads(String hand) {
        TreeMap<Integer, Integer> map = countOccurences(hand);
        for (Integer cardValue : map.values()) {
            if (cardValue == 4) {
                return true;
            }
        }
        return false;
    }

    private int getRankValue(String rank) {
        HandRankValue handRankValue = new HandRankValue(rank);
        return handRankValue.getRankValue();
    }

    private int getCardValue(String card) {
        CardValue cardValue = new CardValue(card);
        return cardValue.getCardValue();
    }

    private boolean checkForFlush(String hand) {
        TreeMap<Integer, Integer> map = countOccurences(hand);
        int hearts = StringUtils.countMatches(hand, "H");
        int clubs = StringUtils.countMatches(hand, "C");
        int diamonds = StringUtils.countMatches(hand, "D");
        int spades = StringUtils.countMatches(hand, "S");
        if (hearts == 5 || clubs == 5 || diamonds == 5 || spades == 5) {
            highCard = map.lastKey();
            return true;
        }
        return false;
    }

    public String getWinningHand() {
        return this.winningHand;
    }
}
