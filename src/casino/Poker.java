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

        //Display your hand
        System.out.println();
        System.out.println("You have ");
        displayHand();
        MatchHand(hand);
        System.out.println("-------------");
        displayDealer();
        MatchHand(dealer);

        reshuffleCards();

    }

    /*
     MatchHand determines what your best hand is.
     */
    public static void MatchHand(ArrayList<Card> cards) {
        String result = highCard(cards);

        if (Integer.parseInt(result) == 14) {
            result = "Ace";
        } else if (Integer.parseInt(result) == 11) {
            result = "Jack";
        } else if (Integer.parseInt(result) == 12) {
            result = "Queen";
        } else if (Integer.parseInt(result) == 13) {
            result = "King";
        }

        if (pair(cards) == true) {
            result = "You have a pair";
        }
        if (twoPairs(cards) == true) {
            result = "You have two pairs";
        }
        if (threeOfAKind(cards) == true) {
            result = "You have three of a kind";
        }
        if (straight(cards) == true) {
            result = "You have a straight";
        }
        if (flush(cards) == true) {
            result = "You have a flush";
        }
        if (fullHouse(cards) == true) {
            result = "You have a fullHouse";
        }
        if (fourOfAKind(cards) == true) {
            result = "You have four of a kind";
        }
        if (straightFlush(cards) == true) {
            result = "You have a straight flush";
        }
        if (royalFlush(cards) == true) {
            result = "You have a royal flush";
        }

        System.out.println(result);
    }

    /*
        highCard returns the high card in your hand
    */
    public static String highCard(ArrayList<Card> cards) {
        int highestCard;
        highestCard = cards.get(0).getPokerValue();
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getPokerValue() > highestCard) {
                highestCard = cards.get(i).getPokerValue();
            }
        }
        return Integer.toString(highestCard);
    }

    /*
        pair() returns true if you have a pair in your hand.
    */
    public static boolean pair(ArrayList<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            for (int j = 0; j < cards.size(); j++) {
                if (cards.get(i).getPokerValue() == cards.get(j).getPokerValue() && i != j) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     twoPairs() returns true if you have two pairs in your hand.
     */
    public static boolean twoPairs(ArrayList<Card> cards) {
        int position = -1;
        int position1 = -1;
        int firstPair = 0;
        for (int i = 0; i < cards.size(); i++) {
            for (int j = 0; j < cards.size(); j++) {
                if (cards.get(i).getPokerValue() == cards.get(j).getPokerValue() && i != j) {
                    if (firstPair == 0) {
                        position = i;
                        position1 = j;
                        firstPair++;
                    } else {
                        if (i != position && i != position1) {
                            if (j != position && j != position1) {
                                return true;
                            }
                        }
                    }
                }

            }
        }
        return false;
    }

    /*
     threeOfAKind() returns true if you have three of a kind.
    */
    public static boolean threeOfAKind(ArrayList<Card> cards) {
        for(int i= 0; i < cards.size(); i++){
            for(int j = 0; j < cards.size(); j++){
                for(int k = 0; k < cards.size(); k++){
                    if(cards.get(i).getPokerValue() == cards.get(j).getPokerValue()){
                        if(cards.get(i).getPokerValue() == cards.get(k).getPokerValue()){
                            if(i != j && i != k && j != k){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /*
     fourOfAKind() returns true if you have a four of a kind.
     */
    public static boolean fourOfAKind(ArrayList<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            for (int j = 0; j < cards.size(); j++) {
                for (int k = 0; k < cards.size(); k++) {
                    for (int l = 0; l < cards.size(); l++) {
                        if (cards.get(i).getPokerValue() == cards.get(j).getPokerValue()) {
                            if (cards.get(j).getPokerValue() == cards.get(k).getPokerValue()) {
                                if (cards.get(k).getPokerValue() == cards.get(l).getPokerValue()) {
                                    if (i != j && i != k && i != l && j != k && j != l && k != l) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /*
     flush() returns true if you have a flush.
     */
    public static boolean flush(ArrayList<Card> cards) {
        char complete = cards.get(0).getSuit();
        int counter = 0;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getSuit() == complete) {
                counter++;
            }
        }
        if (counter == cards.size()) {
            return true;
        }
        return false;

    }

    /*
     straight() returns true if you have a straight.
     */
    public static boolean straight(ArrayList<Card> cards) {
        cards = sort(cards);
        if (cards.get(1).getPokerValue() - cards.get(0).getPokerValue() == 1) {
            if (cards.get(2).getPokerValue() - cards.get(1).getPokerValue() == 1) {
                if (cards.get(3).getPokerValue() - cards.get(2).getPokerValue() == 1) {
                    if (cards.get(4).getPokerValue() - cards.get(3).getPokerValue() == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
     fullHouse() returns true if you have a full house.
     */
    public static boolean fullHouse(ArrayList<Card> cards) {
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
                                return true;
                            }
                        }
                    }

                }
            }
            return false;
        } else {
            return false;
        }
    }

    /*
     straightFlush() returns true if you have a straight flush.
     */
    public static boolean straightFlush(ArrayList<Card> cards) {
        if(straight(cards) == true){
            if(flush(cards) == true){
                return true;
            }
        }
        return false;
    }

    /*
     royalFlush() returns true if you have a royal flush.
     */
    public static boolean royalFlush(ArrayList<Card> cards) {
        if(straightFlush(cards) == true){
            cards = sort(cards);
            if(cards.get(0).getPokerValue() == 10){
                return true;
            }
        }
        
        return false;
    }
    
    public static ArrayList<Card> sort(ArrayList<Card> cards){
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card i, Card j) {
                return i.cardNumber - j.cardNumber; // Ascending
            }

        });
        return hand;
    }

}
