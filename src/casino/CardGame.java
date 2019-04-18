package casino;

import java.util.ArrayList;
import java.util.Collections;

public class CardGame extends Game {

    public static ArrayList<Card> deck = new ArrayList<Card>();
    public static ArrayList<Card> hand = new ArrayList<Card>();
    public static ArrayList<Card> dealer = new ArrayList<Card>();

    /*
     dealerDraw() draws a card for the dealer himself.
     */
    public static void dealerDraw() {
        dealer.add(deck.remove(0));
    }

    /*
     draw() draws a card from the deck.
     */
    public static void draw() {
        hand.add(deck.remove(0));
    }

    /*
     displayHand() displays the cards in a hand
     */
    public static void displayHand() {
        for (Card hand1 : hand) {
            if (hand1.cardNumber == 11) {
                System.out.println("J" + " " + hand1.suit);
            } else if (hand1.cardNumber == 12) {
                System.out.println("Q" + " " + hand1.suit);
            } else if (hand1.cardNumber == 13) {
                System.out.println("K" + " " + hand1.suit);
            } else if (hand1.cardNumber == 1) {
                System.out.println("A" + " " + hand1.suit);
            } else {
                System.out.println(hand1.cardNumber + " " + hand1.suit);
            }
        }
    }

    /*
     displayDealer() displays the dealer's hand.
     */
    public static void displayDealer() {
        for (Card dealer1 : dealer) {
            if (dealer1.cardNumber == 11) {
                System.out.println("J" + " " + dealer1.suit);
            } else if (dealer1.cardNumber == 12) {
                System.out.println("Q" + " " + dealer1.suit);
            } else if (dealer1.cardNumber == 13) {
                System.out.println("K" + " " + dealer1.suit);
            } else if (dealer1.cardNumber == 1) {
                System.out.println("A" + " " + dealer1.suit);
            } else {
                System.out.println(dealer1.cardNumber + " " + dealer1.suit);
            }
        }
    }

    /*
     displayDeck() displays every card in the deck.
     */
    public static void displayDeck() {
        for (Card deck1 : deck) {
            if (deck1.cardNumber == 11) {
                System.out.println("J" + " " + deck1.suit);
            } else if (deck1.cardNumber == 12) {
                System.out.println("Q" + " " + deck1.suit);
            } else if (deck1.cardNumber == 13) {
                System.out.println("K" + " " + deck1.suit);
            } else if (deck1.cardNumber == 1) {
                System.out.println("A" + " " + deck1.suit);
            } else {
                System.out.println(deck1.cardNumber + " " + deck1.suit);
            }
        }
    }

    /*
     reshuffleCards() reshuffle all the cards back into the deck.
     */
    public static void reshuffleCards() {
        int handSize = hand.size();
        int dealerSize = dealer.size();
        for (int i = 0; i < handSize; i++) {
            deck.add(hand.remove(0));
        }
        for (int i = 0; i < dealerSize; i++) {
            deck.add(dealer.remove(0));
        }
        Collections.shuffle(deck);
    }

    /*
     createDeck() creates a deck to be used
     and shuffles the cards in the deck.
     */
    public static void createDeck() {
        char suit = 'a';
        int number = 0;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                if (j % 4 == 0) {
                    suit = ((char) '\u2663');
                } else if (j % 4 == 1) {
                    suit = ((char) '\u2666');
                } else if (j % 4 == 2) {
                    suit = ((char) '\u2660');
                } else if (j % 4 == 3) {
                    suit = ((char) '\u2764');
                }
                deck.add(new Card(number + 1, suit));
                number = i;
            }
        }
        Collections.shuffle(deck);
    }
}