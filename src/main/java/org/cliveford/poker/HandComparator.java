package org.cliveford.poker;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class HandComparator {

    private String winningHand;
    private int highCard;
    private final ArrayList<String> MESSAGEBLACK = new ArrayList<>();
    private final ArrayList<String> MESSAGEWHITE = new ArrayList<>();


    public HandComparator(String inputHands) {

        this.winningHand = calculateWinningHand(inputHands);

    }

    private String calculateWinningHand(String inputHands) {
        String black = inputHands.substring(7, 21).trim();
        String white = inputHands.substring(30, 44).trim();
        int blackHandStrength = Integer.parseInt(calculateHandStrength(black, "black"));
        int whiteHandStrength = Integer.parseInt(calculateHandStrength(white, "white"));

        if (blackHandStrength > whiteHandStrength) {
            this.winningHand = "Black wins. - with " + MESSAGEBLACK.get(0) + ": " + MESSAGEBLACK.get(1) + MESSAGEBLACK.get(2);
        } else if (whiteHandStrength > blackHandStrength) {
            this.winningHand = "White wins. - with " + MESSAGEWHITE.get(0) + ": " + MESSAGEWHITE.get(1) + MESSAGEWHITE.get(2);
        } else {
            this.winningHand = compareKickers(black, white);
        }

        return this.winningHand;
    }

    private int getRankValue(String rank) {
        HandRankValue handRankValue = new HandRankValue(rank);
        return handRankValue.getRankValue();
    }

    private String getCardValue(int card) {
        CardValue cardValue = new CardValue(card);
        return cardValue.getCardValue();
    }

    public String getWinningHand() {
        return this.winningHand;
    }

    private String compareKickers(String black, String white) {
        int whiteKicker;
        int blackKicker;
        TreeMap<Integer, Integer> blackMap = countOccurences(black);
        TreeMap<Integer, Integer> whiteMap = countOccurences(white);

        while (blackMap.size() > 0) {

            blackKicker = blackMap.lastKey();
            whiteKicker = whiteMap.lastKey();
            blackMap.remove(blackKicker);
            whiteMap.remove(whiteKicker);

            if (blackKicker > whiteKicker) {
                if (highCard == 0) {
                    return "Black wins. - with " + MESSAGEBLACK.get(0) + ": " + getCardValue(blackKicker);
                }
                return "Black wins. - with " + MESSAGEBLACK.get(0) + ": " + MESSAGEBLACK.get(1) +
                        MESSAGEBLACK.get(2) + " & " + getCardValue(blackKicker) + " kicker";
            } else if (whiteKicker > blackKicker) {
                if (highCard == 0) {
                    return "White wins. - with " + MESSAGEWHITE.get(0) + ": " + getCardValue(whiteKicker);
                }
                return "White wins. - with " + MESSAGEWHITE.get(0) + ": " + MESSAGEWHITE.get(1) +
                        MESSAGEWHITE.get(2) + " & " + getCardValue(whiteKicker) + " kicker";
            }
        }
        return "Tie.";
    }

    private String calculateHandStrength(String hand, String player) {
        MESSAGEBLACK.add("hand");
        MESSAGEBLACK.add("cards");
        MESSAGEBLACK.add("");
        MESSAGEWHITE.add("hand");
        MESSAGEWHITE.add("cards");
        MESSAGEWHITE.add("");
        int handValue = 0;
        while (handValue == 0) {
            if (checkForStraightFlush(hand, player)) {
                handValue += getRankValue("straight flush") + highCard;
                break;
            } else if (checkForQuads(hand, player)) {
                handValue += getRankValue("four of a kind");
                break;
            } else if (checkForFullHouse(hand, player)) {
                handValue += getRankValue("full house") + highCard;
                break;
            } else if (checkForFlush(hand, player)) {
                handValue += getRankValue("flush") + highCard;
                break;
            } else if (checkForTrips(hand, player)) {
                handValue += getRankValue("three of a kind") + highCard;
                break;
            } else if (checkForTwoPair(hand, player)) {
                handValue += getRankValue("two pairs") + highCard;
                break;
            } else if (checkForPair(hand, player, false)) {
                handValue += getRankValue("pair") + highCard;
                break;
            } else if (checkForStraight(hand, player)) {
                handValue += getRankValue("straight") + highCard;
                break;
            } else {
                handValue += getRankValue("high card") + highCard;
                if (player.equals("black")) {
                    MESSAGEBLACK.set(0, "high card");
                    MESSAGEBLACK.set(1, getCardValue(highCard));
                } else {
                    MESSAGEWHITE.set(0, "high card");
                    MESSAGEWHITE.set(1, getCardValue(highCard));
                }
            }
        }
        return Integer.toString(handValue);
    }

    private TreeMap<Integer, Integer> countOccurences(String hand) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int two = StringUtils.countMatches(hand, "2");
        if (two > 0) map.put(2, two);
        int three = StringUtils.countMatches(hand, "3");
        if (three > 0) map.put(3, three);
        int four = StringUtils.countMatches(hand, "4");
        if (four > 0) map.put(4, four);
        int five = StringUtils.countMatches(hand, "5");
        if (five > 0) map.put(5, five);
        int six = StringUtils.countMatches(hand, "6");
        if (six > 0) map.put(6, six);
        int seven = StringUtils.countMatches(hand, "7");
        if (seven > 0) map.put(7, seven);
        int eight = StringUtils.countMatches(hand, "8");
        if (eight > 0) map.put(8, eight);
        int nine = StringUtils.countMatches(hand, "9");
        if (nine > 0) map.put(9, nine);
        int ten = StringUtils.countMatches(hand, "T");
        if (ten > 0) map.put(10, ten);
        int jack = StringUtils.countMatches(hand, "J");
        if (jack > 0) map.put(11, jack);
        int queen = StringUtils.countMatches(hand, "Q");
        if (queen > 0) map.put(12, queen);
        int king = StringUtils.countMatches(hand, "K");
        if (king > 0) map.put(13, king);
        int ace = StringUtils.countMatches(hand, "A");
        if (ace > 0) map.put(14, ace);
        return map;
    }


    private boolean checkForStraight(String hand, String player) {
        TreeMap<Integer, Integer> map = countOccurences(hand);
        if (map.lastKey() - map.firstKey() == 4) {
            highCard = map.lastKey();
            if (player.equals("black")) {
                MESSAGEBLACK.set(0, "straight");
                MESSAGEBLACK.set(1, getCardValue(highCard) + " high");
            } else {
                MESSAGEWHITE.set(0, "straight");
                MESSAGEWHITE.set(1, getCardValue(highCard) + " high");
            }
            return true;
        }
        return false;
    }

    private boolean checkForStraightFlush(String hand, String player) {
        if (checkForFlush(hand, player) && checkForStraight(hand, player)) {
            if (player.equals("black")) {
                MESSAGEBLACK.set(0, "straight flush");
                MESSAGEBLACK.set(1, getCardValue(highCard) + " high");
            } else {
                MESSAGEWHITE.set(0, "straight flush");
                MESSAGEWHITE.set(1, getCardValue(highCard) + " high");
            }
            return true;
        }
        return false;
    }

    private boolean checkForFullHouse(String hand, String player) {
        boolean fullHouseFlag = true;
        if (checkForPair(hand, player, fullHouseFlag) && checkForTrips(hand, player)) {
            if (player.equals("black")) {
                MESSAGEBLACK.set(0, "full house");
            } else {
                MESSAGEWHITE.set(0, "full house");
            }
            return true;
        }
        return false;
    }

    private boolean checkForPair(String hand, String player, boolean fullHouseFlag) {
        TreeMap<Integer, Integer> map = countOccurences(hand);
        for (Map.Entry<Integer, Integer> card : map.entrySet()) {
            if (card.getValue() == 2) {
                highCard = card.getKey();
                if (fullHouseFlag) {
                    if (player.equals("black")) {
                        MESSAGEBLACK.set(2, "/" + getCardValue(highCard) + "s");
                    } else {
                        MESSAGEWHITE.set(2, "/" + getCardValue(highCard) + "s");
                    }
                } else {
                    if (player.equals("black")) {
                        MESSAGEBLACK.set(0, "pair");
                        MESSAGEBLACK.set(1, getCardValue(highCard) + "s");
                        MESSAGEBLACK.set(2, "");
                    } else {
                        MESSAGEWHITE.set(0, "pair");
                        MESSAGEWHITE.set(1, getCardValue(highCard) + "s");
                        MESSAGEWHITE.set(2, "");
                    }
                }
                return true;
            }
        }
        return false;
    }

    private boolean checkForTrips(String hand, String player) {
        TreeMap<Integer, Integer> map = countOccurences(hand);
        for (Map.Entry<Integer, Integer> card : map.entrySet()) {
            if (card.getValue() == 3) {
                highCard = card.getKey();
                if (player.equals("black")) {
                    MESSAGEBLACK.set(0, "three of a kind");
                    MESSAGEBLACK.set(1, getCardValue(highCard) + "s");
                } else {
                    MESSAGEWHITE.set(0, "three of a kind");
                    MESSAGEWHITE.set(1, getCardValue(highCard) + "s");
                }
                return true;
            }
        }
        return false;
    }

    private boolean checkForTwoPair(String hand, String player) {
        TreeMap<Integer, Integer> map = countOccurences(hand);
        int pairCounter = 0;
        for (Map.Entry<Integer, Integer> card : map.entrySet()) {
            if (card.getValue() == 2) {
                if (pairCounter == 0) {
                    if (player.equals("black")) {
                        MESSAGEBLACK.set(2, "/" + getCardValue(card.getKey()) + "s");
                    } else {
                        MESSAGEWHITE.set(2, "/" + getCardValue(card.getKey()) + "s");
                    }
                }
                pairCounter += 1;
                if (pairCounter == 2) {
                    highCard = card.getKey();
                    if (player.equals("black")) {
                        MESSAGEBLACK.set(0, "two pair");
                        MESSAGEBLACK.set(1, getCardValue(card.getKey()) + "s");
                    } else {
                        MESSAGEWHITE.set(0, "two pair");
                        MESSAGEWHITE.set(1, getCardValue(card.getKey()) + "s");
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkForQuads(String hand, String player) {
        TreeMap<Integer, Integer> map = countOccurences(hand);
        for (Map.Entry<Integer, Integer> card : map.entrySet()) {
            if (card.getValue() == 4) {
                if (player.equals("black")) {
                    MESSAGEBLACK.set(0, "four of a kind");
                    MESSAGEBLACK.set(1, getCardValue(card.getKey()) + "s");
                } else {
                    MESSAGEWHITE.set(0, "four of a kind");
                    MESSAGEWHITE.set(1, getCardValue(card.getKey()) + "s");
                }
                return true;
            }
        }
        return false;
    }

    private boolean checkForFlush(String hand, String player) {
        TreeMap<Integer, Integer> map = countOccurences(hand);
        int hearts = StringUtils.countMatches(hand, "H");
        int clubs = StringUtils.countMatches(hand, "C");
        int diamonds = StringUtils.countMatches(hand, "D");
        int spades = StringUtils.countMatches(hand, "S");
        if (hearts == 5 || clubs == 5 || diamonds == 5 || spades == 5) {
            highCard = map.lastKey();
            if (player.equals("black")) {
                MESSAGEBLACK.set(0, "flush");
                MESSAGEBLACK.set(1, getCardValue(highCard) + " high");
            } else {
                MESSAGEWHITE.set(0, "flush");
                MESSAGEWHITE.set(1, getCardValue(highCard) + " high");
            }
            return true;
        }
        return false;
    }

}
