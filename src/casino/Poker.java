package casino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Poker extends CardGame {

    public static void play() {
        if (deck.isEmpty()) {
            createDeck();
            System.out.println("Creating a deck.");
        }

        //Make your bets
        bet();

        //Deals the cards to the player and to the dealer
        draw();
        dealerDraw();
        draw();
        dealerDraw();
        draw();
        dealerDraw();
        draw();
        dealerDraw();
        draw();
        dealerDraw();

        hand = sort(hand);
        dealer = sort(dealer);

        ArrayList<Card> test = new ArrayList<Card>();

        //Display your hand
        System.out.println();
        System.out.println("You have ");
        displayHand();
        System.out.println("Dealer has ");
        System.out.println("-------------");
        displayDealer();

        compareHands();

        reshuffleCards();

    }

    /*
     compareHands() compares the dealer's hand
     to the player's hand.
     */
    public static void compareHands() {
        long hand1 = MatchHand(hand);
        long hand2 = MatchHand(dealer);
        if (hand1 > hand2) {
            System.out.println("You win.");
            bet = bet * 2;
            money = bet + money;
        } else if (hand1 < hand2) {
            System.out.println("You lose");
        } else {
            System.out.println("Push!");
            money = bet + money;
            System.out.println("Your money is returned.");
        }
    }

    /*
        MatchHand() returns a value based on what the given
        hand has as the high card is and whether the given
        hand has a royal flush, a straight flush, a four of
        a kind, a full house, a flush, a straight, a three
        of a kind, two pairs or one pair. If it has a royal
        flush, it returns the maximum value of a long,
        because nothing is greater than that.
    */
    public static long MatchHand(ArrayList<Card> cards) {
        long value = 0;

        if (royalFlush(cards)) {
            value = Long.MAX_VALUE;
        } else {
            value += straightFlush(cards);
            value += fourOfAKind(cards);
            value += fullHouse(cards);
            value += flush(cards);
            value += straight(cards);
            value += threeOfAKind(cards);
            value += twoPairs(cards);
        }
        return value;
    }

    /*
      twoPairs() checks if the given hand has one or two pairs,
      and it also checks for the high card in a given hand.
     */
    public static long twoPairs(ArrayList<Card> cards) {
        long value = 0;
        int Pair1 = 0;
        int Pair2 = 0;
        ArrayList<Integer> temp = new ArrayList<>();

        int position = -1;
        int position1 = -1;
        int position2 = -1;
        int position3 = -1;

        int firstPair = 0;

        for (int i = 0; i < cards.size(); i++) {
            for (int j = 0; j < cards.size(); j++) {
                if (cards.get(i).getPokerValue() == cards.get(j).getPokerValue() && i != j) {
                    if (firstPair == 0) {
                        position = i;
                        position1 = j;
                        firstPair++;
                        Pair1 = cards.get(i).getPokerValue();
                    } else {
                        if (i != position && i != position1) {
                            if (j != position && j != position1) {
                                Pair2 = cards.get(i).getPokerValue();
                                position2 = i;
                                position3 = j;
                            }
                        }
                    }
                }

            }
        }

        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getPokerValue() == Pair1 || cards.get(i).getPokerValue() == Pair2) {
            } else {
                temp.add(cards.get(i).getPokerValue());
            }
        }
        int highCard = 0;
        if (!temp.isEmpty()) {
            highCard = temp.get(0);
        }

        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i) > highCard) {
                highCard = temp.get(i);
            }
        }
        value += highCard;

        if (Pair2 == 0) {
            value += Pair1 * 0x10;
        } else if (Pair1 > Pair2) {
            value += Pair1 * 0x100;
            value += Pair2 * 0x10;
        } else if (Pair1 < Pair2) {
            value += Pair2 * 0x100;
            value += Pair1 * 0x10;
        }

        return value;
    }

    /*
     threeOfAKind() returns a positive value if the cards in the hand
     have a three of a kind.
     */
    public static long threeOfAKind(ArrayList<Card> cards) {
        long value = 0;

        for (int i = 0; i < cards.size(); i++) {
            for (int j = 0; j < cards.size(); j++) {
                for (int k = 0; k < cards.size(); k++) {
                    if (cards.get(i).getPokerValue() == cards.get(j).getPokerValue()) {
                        if (cards.get(i).getPokerValue() == cards.get(k).getPokerValue()) {
                            if (i != j && i != k && j != k) {
                                value = cards.get(i).getPokerValue() * 0x1000;
                            }
                        }
                    }
                }
            }
        }
        return value;
    }

    /*
        straight() returns a value if the given hand has
        a straight
    */
    public static long straight(ArrayList<Card> cards) {
        long value = 0;

        cards = sort(cards);
        if (cards.get(1).getPokerValue() - cards.get(0).getPokerValue() == 1) {
            if (cards.get(2).getPokerValue() - cards.get(1).getPokerValue() == 1) {
                if (cards.get(3).getPokerValue() - cards.get(2).getPokerValue() == 1) {
                    if (cards.get(4).getPokerValue() - cards.get(3).getPokerValue() == 1) {
                        value = cards.get(4).getPokerValue() * 0x10000;
                    }
                }
            }
        }

        if (cards.get(4).cardNumber == 1 && cards.get(0).cardNumber == 2) {
            if (cards.get(1).getPokerValue() - cards.get(0).getPokerValue() == 1) {
                if (cards.get(2).getPokerValue() - cards.get(1).getPokerValue() == 1) {
                    if (cards.get(3).getPokerValue() - cards.get(2).getPokerValue() == 1) {
                        value = cards.get(3).getPokerValue() * 0x10000;
                    }
                }
            }
        }

        return value;
    }
    /*
     flush() checks to see if all the cards in a given hand
     are in the same suit.
     */

    public static long flush(ArrayList<Card> cards) {
        long value = 0;
        cards = sort(cards);

        char complete = cards.get(0).getSuit();
        int counter = 0;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getSuit() == complete) {
                counter++;
            }
        }
        if (counter == cards.size()) {
            value = cards.get(4).getPokerValue() * 0x100000;
        }

        return value;
    }

    /*
     fullHouse() checks if the hand has a three of a kind
     and a pair.
     */
    public static long fullHouse(ArrayList<Card> cards) {
        long value = 0;
        int threeOfAKindValue = 0;

        int position1 = -1;
        int position2 = -1;
        int position3 = -1;
        int threeCount = 0;
        for (int i = 0; i < cards.size(); i++) {
            for (int j = 0; j < cards.size(); j++) {
                for (int k = 0; k < cards.size(); k++) {
                    if (cards.get(i).getPokerValue() == cards.get(j).getPokerValue()) {
                        if (cards.get(i).getPokerValue() == cards.get(k).getPokerValue()) {
                            if (i != j && i != k && j != k) {
                                threeCount++;
                                position1 = i;
                                position2 = j;
                                position3 = k;
                                threeOfAKindValue = cards.get(i).getPokerValue();
                            }
                        }
                    }
                }
            }
        }
        if (threeCount > 0) {
            for (int i = 0; i < cards.size(); i++) {
                for (int j = 0; j < cards.size(); j++) {
                    if (cards.get(i).getPokerValue() == cards.get(j).getPokerValue() && i != j) {
                        if (i != position1 && i != position2 && i != position3) {
                            if (j != position1 && j != position2 && j != position3) {
                                value = threeOfAKindValue * 0x1000000;
                            }
                        }
                    }

                }
            }
        }

        return value;
    }

    /*
     fourOfAKind() checks and returns a positive value if the
     hand it is given has a four of a kind.
     */
    public static long fourOfAKind(ArrayList<Card> cards) {
        long value = 0;

        for (int i = 0; i < cards.size(); i++) {
            for (int j = 0; j < cards.size(); j++) {
                for (int k = 0; k < cards.size(); k++) {
                    for (int l = 0; l < cards.size(); l++) {
                        if (cards.get(i).getPokerValue() == cards.get(j).getPokerValue()) {
                            if (cards.get(j).getPokerValue() == cards.get(k).getPokerValue()) {
                                if (cards.get(k).getPokerValue() == cards.get(l).getPokerValue()) {
                                    if (i != j && i != k && i != l && j != k && j != l && k != l) {
                                        value = cards.get(i).getPokerValue() * 0x1000000;
                                        value = value * 0x10;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return value;
    }

    /*
     straightFlush() checks if the hand is a straight 
     and a flush. If it is both, then it returns a value.
     */
    public static long straightFlush(ArrayList<Card> cards) {
        long value = 0;

        if (straight(cards) > 0) {
            if (flush(cards) > 0) {
                value = straight(cards) * 0x10000; //
            }
        }

        return value;
    }

    /*
    royalFlush() checks if the hand has a royal flush.
     */
    public static boolean royalFlush(ArrayList<Card> cards) {
        long value = 0;

        if (straightFlush(cards) > 0) {
            cards = sort(cards);
            if (cards.get(0).getPokerValue() == 10) {
                return true;
            }
        }

        return false;
    }

    /*
     sort() sorts all the cards by their numbers
     */
    public static ArrayList<Card> sort(ArrayList<Card> cards) {
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card i, Card j) {
                return i.getPokerValue() - j.getPokerValue(); // Ascending
            }

        });
        return cards;
    }
    
}
