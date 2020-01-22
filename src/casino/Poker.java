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
        displayMoney();
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
    private static void compareHands() {
        long hand1 = MatchHand(hand);
        long hand2 = MatchHand(dealer);
        if (hand1 > hand2) {
            System.out.println("You win.");
            bet = bet * 2;
            money = bet + money;
        } else if (hand1 < hand2) {
            System.out.println("You lose");
        } else {
            System.out.println("Comparing high card");
            compareHighCard(4);
        }
    }
    
    /*
        compareHighCard() compares which hand has the higher card.
        It is only used if the dealer and player have the same score.
        It checks each highest card and compares it with the opposing
        player's highest card. If they are the same, it goes to the
        second highest card and so on. If both hands have the same score,
        it is considered a push and the player's money is returned.
    */
    private static void compareHighCard(int card){
        if(card < 0){
            System.out.println("Push!");
            money = bet + money;
            System.out.println("Your money is returned.");
            return;
        }
        int dealerValue = dealer.get(card).getPokerValue();
        int handValue = hand.get(card).getPokerValue();
        if(handValue == dealerValue){
            compareHighCard(card-1);
        }
        else if(dealerValue > handValue){
            System.out.println("You lose");
        }else if(dealerValue < handValue){
            System.out.println("You win.");
            bet = bet * 2;
            money = bet + money;
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
    private static long MatchHand(ArrayList<Card> cards) {
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
    private static long twoPairs(ArrayList<Card> cards) {
        long value = 0;
        int pair1 = 0;
        int pair2 = 0;
        if(cards.get(0).getPokerValue() == cards.get(1).getPokerValue()){
            pair1 = cards.get(0).getPokerValue();
            if(cards.get(2).getPokerValue() == cards.get(3).getPokerValue()){
                pair2 = cards.get(2).getPokerValue();
            }else if(cards.get(3).getPokerValue() == cards.get(4).getPokerValue()){
                pair2 = cards.get(3).getPokerValue();
            }
        }else if(cards.get(1).getPokerValue() == cards.get(2).getPokerValue()){
            pair1 = cards.get(1).getPokerValue();
            if(cards.get(3).getPokerValue() == cards.get(4).getPokerValue()){
                pair2 = cards.get(3).getPokerValue();
            }
        }else if(cards.get(2).getPokerValue() == cards.get(3).getPokerValue()){
            pair1 = cards.get(2).getPokerValue();
        }
        value += pair1 * 0x10;
        value += pair2 * 0x100; 
        
        return value;
    }

    /*
     threeOfAKind() returns a positive value if the cards in the hand
     have a three of a kind.
     */
    private static long threeOfAKind(ArrayList<Card> cards) {
        long value = 0;
        if(cards.get(0).getPokerValue() == cards.get(2).getPokerValue()){
            value = cards.get(0).getPokerValue() * 0x1000;
        }else if(cards.get(1).getPokerValue() == cards.get(3).getPokerValue()){
            value = cards.get(0).getPokerValue() * 0x1000;
        }else if(cards.get(2).getPokerValue() == cards.get(4).getPokerValue()){
            value = cards.get(0).getPokerValue() * 0x1000;
        }

        return value;
    }

    /*
        straight() returns a value if the given hand has
        a straight
    */
    private static long straight(ArrayList<Card> cards) {
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

    private static long flush(ArrayList<Card> cards) {
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
    private static long fullHouse(ArrayList<Card> cards) {
        long value = 0;
        if(cards.get(0).getPokerValue() == cards.get(1).getPokerValue()
           && cards.get(2).getPokerValue() == cards.get(4).getPokerValue()){
            value = cards.get(2).getPokerValue() * 0x1000000;
        }else if(cards.get(0).getPokerValue() == cards.get(2).getPokerValue()
           && cards.get(3).getPokerValue() == cards.get(4).getPokerValue()){
            value = cards.get(2).getPokerValue() * 0x1000000;
        }
        return value;
    }

    /*
     fourOfAKind() checks and returns a positive value if the
     hand it is given has a four of a kind.
     */
    private static long fourOfAKind(ArrayList<Card> cards) {
        long value = 0;
        if(cards.get(0).getPokerValue() == cards.get(3).getPokerValue()){
            value = cards.get(0).getPokerValue() * 0x1000000;
            value = value * 0x10;
        }else if(cards.get(1).getPokerValue() == cards.get(4).getPokerValue()){
            value = cards.get(1).getPokerValue() * 0x1000000;
            value = value * 0x10;
        }
        return value;
    }

    /*
     straightFlush() checks if the hand is a straight 
     and a flush. If it is both, then it returns a value.
     */
    private static long straightFlush(ArrayList<Card> cards) {
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
    private static boolean royalFlush(ArrayList<Card> cards) {
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
    private static ArrayList<Card> sort(ArrayList<Card> cards) {
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card i, Card j) {
                return i.getPokerValue() - j.getPokerValue(); // Ascending
            }

        });
        return cards;
    }
    
}
