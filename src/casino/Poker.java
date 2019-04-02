package casino;

import java.util.ArrayList;

public class Poker extends CardGame {
    
    public static int money;
    public static int bet;
    
    public static void play(){
        createDeck();
        //displayHand();
        displayDeck();
    }
    
    /*
        MatchHand determines what your best hand is.
    */
    public static void MatchHand(ArrayList<Card> hand){
        
    }
    
    /*
        highCard returns the high card in your hand
    */
    public static String highCard(){
        return "not finished";
    }
    
    /*
        pair() returns true if you have a pair in your hand.
    */
    public static void pair(){
        
    }
    
    /*
        twoPairs() returns true if you have two pairs in your hand.
    */
    public static void twoPairs(){
        
    }
    
    /*
        threeOfAKind() returns true if you have three of a kind.
    */
    public static void threeOfAKind(){
        
    }
    
    /*
        fourOfAKind() returns true if you have a four of a kind.
    */
    public static void fourOfAKind(){
        
    }
    
    /*
        flush() returns true if you have a flush.
    */
    public static void flush(){
        
    }
    
    /*
        straight() returns true if you have a straight.
    */
    public static void straight(){
        
    }
    
    /*
        fullHouse() returns true if you have a full house.
    */
    public static void fullHouse(){
        
    }
    
    /*
        straightFlush() returns true if you have a straight flush.
    */
    public static void straightFlush(){
        
    }
    
    /*
        royalFlush() returns true if you have a royal flush.
    */
    public static void royalFlush(){
        
    }
    
}
