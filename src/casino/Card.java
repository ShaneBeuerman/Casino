package casino;

/*
    Creates a card object with a card number value
    and a suit value.
*/
public class Card {
    public int cardNumber;
    public char suit;
    
    /*
    
    */
    public Card(int cardNumber, char suit){
        this.cardNumber = cardNumber;
        this.suit = suit;
    }
    
        
    /*
        Returns suit value
    */
    public char getSuit(){
        return suit;
    }
    
    /*
        Returns card number
    */
    public int getNumber(){
        return cardNumber;
    }
    
    /*
        Sets suit value
    */
    public void setSuit(char suit){
        this.suit = suit;
    }
    
    /*
        Sets card number
    */
    public void setNumber(int cardNumber){
        this.cardNumber = cardNumber;
    }
    
    /*
        Gets the value the cardNumber in Blackjack.
        Face cards are aces are unique in Blackjack.
    */
    public int getBlackjackValue(){
        if(cardNumber > 10){
            return 10;
        }
        else if(cardNumber == 1){
            return 11;
        }
        else{
            return cardNumber;
        }
    }
    
    /*
        Gets the value from the cardNumber in Poker
        Aces are higher than any other card.
    */
    public int getPokerValue(){
        if(cardNumber == 1){
            return 14;
        }
        else{
            return cardNumber;
        }
    }
    
    /*
        Prints the card
    */
    public void printCard(){
        String value = "";
        if(cardNumber == 1){
            value = "A";
        }
        else if(cardNumber == 11){
            value = "J";
        }
        else if(cardNumber == 12){
            value = "Q";
        }
        else if(cardNumber == 13){
            value = "K";
        }
        else{
            value = Integer.toString(cardNumber);
        }
        
        System.out.println("|" + value + " " + value + "|");
        System.out.println("| "  + suit + " |");
        System.out.println("|" + value + " " + value + "|");
    }
    
    
    
}
