package casino;

import java.util.ArrayList;
import java.util.Collections;

public class CardGame extends Game {
    
    public static ArrayList<Card> deck = new ArrayList<Card>();
    public static ArrayList<Card> hand = new ArrayList<Card>();
    
    /*
        Draws a card from the deck.
    */
    public static void draw(){
        hand.add(deck.remove(0));
    }
    
    /*
        Displays the cards in a hand
    */
    public static void displayHand(){
        for(int i = 0; i < hand.size(); i++){
            System.out.println(hand.get(i).cardNumber + " " + hand.get(i).suit);
        }
    }
    
    /*
        Displays the cards in the deck
    */
    public static void displayDeck(){
        for(int i = 0; i < deck.size(); i++){
            System.out.println(deck.get(i).cardNumber + " " + deck.get(i).suit);
        }
    }
    
    /*
        Reshuffle all the cards back into the deck.
    */
    public static void reshuffleCards(){
        for(int i = 0; i < hand.size(); i++){
            deck.add(hand.remove(0));
        }
    }
        
    /*
        Creates a deck to be used.
    */
    public static void createDeck(){
        char suit = 'a';
        int number = 0;
        for(int i = 0; i < 13; i++){
            for(int j = 0; j < 4; j++){
                if(j % 4 == 0){
                    suit = ((char) '\u2663');
                } else if (j % 4 == 1){
                    suit = ((char) '\u2666');
                } else if (j % 4 == 2){
                    suit = ((char) '\u2660');
                } else if (j % 4 == 3){
                    suit = ((char) '\u2764');
                }
                deck.add(new Card(number + 1, suit));
                number = i;
            }
        }
        Collections.shuffle(deck);
    }
    
    /*
        There is a player and a dealer. This is the player.
    */
    public static void player(){
        //nothing yet
    }
    
    /*
        There is a dealer that deals the cards.
    */
    public static void dealer(){
        //nothing yet
    }
    
}
