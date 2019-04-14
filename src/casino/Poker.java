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
    public static void compareHands(){
        long hand1 = MatchHand(hand);
        long hand2 = MatchHand(dealer);
        if(hand1 > hand2){
            System.out.println("You win.");
            bet = bet * 2;
            money = bet + money;
        }
        else if(hand1 < hand2){
            System.out.println("You lose");
        } else{
            System.out.println("Push!");
            money = bet + money;
            System.out.println("Your money is returned.");
        }        
    }

    public static long MatchHand(ArrayList<Card> cards){
        long value = 0;
        
        if(royalFlush(cards)){
            value = 0xFFFFFFFF;
        }else {
            value += straightFlush(cards);
            value += fourOfAKind(cards);
            value += fullHouse(cards);
            value += flush(cards);
            value += straight(cards);
            value += threeOfAKind(cards);
            value += twoPairs(cards);
        }

        printHex(value);

        return value;
    }
    
    /*
    
    */
    public static long twoPairs(ArrayList<Card> cards){
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
        
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getPokerValue() == Pair1 || cards.get(i).getPokerValue() == Pair2){      
            }else{
                temp.add(cards.get(i).getPokerValue());
            }
        }
        int highCard = temp.get(0);
        for(int i = 0; i < temp.size(); i++){
            if(temp.get(i) > highCard){
                highCard = temp.get(i);
            }
        }
        value += highCard;
        
        if(Pair2 == 0){
            value += Pair1 * 0x10;
        } else if(Pair1 > Pair2){
            value += Pair1 * 0x100;
            value += Pair2 * 0x10;
        } else if(Pair1 < Pair2){
            value += Pair2 * 0x100;
            value += Pair1 * 0x10;
        } 
        
        return value;
    }
    
    /*
        Problematic
    */
    public static long threeOfAKind(ArrayList<Card> cards){
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
        should work
    */
    public static long straight(ArrayList<Card> cards){
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
        
        return value;
    }
    
    /*
        Works fine 
    */
    public static long flush(ArrayList<Card> cards){
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
        Might need to check.
    */
    public static long fullHouse(ArrayList<Card> cards){
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
        Might need to check
    */
    public static long fourOfAKind(ArrayList<Card> cards){
        long value = 0;
        
        for (int i = 0; i < cards.size(); i++) {
            for (int j = 0; j < cards.size(); j++) {
                for (int k = 0; k < cards.size(); k++) {
                    for (int l = 0; l < cards.size(); l++) {
                        if (cards.get(i).getPokerValue() == cards.get(j).getPokerValue()) {
                            if (cards.get(j).getPokerValue() == cards.get(k).getPokerValue()) {
                                if (cards.get(k).getPokerValue() == cards.get(l).getPokerValue()) {
                                    if (i != j && i != k && i != l && j != k && j != l && k != l) {
                                        value = cards.get(i).getPokerValue() * 0x10000000;
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
        Adjust values maybe
    */
    public static long straightFlush(ArrayList<Card> cards){
        long value = 0;
        
        if (straight(cards) > 0 ) {
            if (flush(cards) > 0) {
                value = straight(cards) * 0x10000; // 7 0s Adjust later
                //straight = 0xE000;
            }
        }
        
        return value;
    }
    
    /*
        Should work
    */
    public static boolean royalFlush(ArrayList<Card> cards){
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
    
    public static void printHex(long print){
        System.out.println(String.format("0x%08X", print));
    }
    
}
