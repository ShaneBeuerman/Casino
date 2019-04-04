package casino;

/*
 Creates a card object with a card number value
 and a suit value.
 */
public class Card {

    public int cardNumber;
    public char suit;

    /*
     A card contains a card number and a suit.
     The suit doesn't matter in blackjack, but
     it is vital in poker.
     */
    public Card(int cardNumber, char suit) {
        this.cardNumber = cardNumber;
        this.suit = suit;
    }

    /*
     getSuit() returns suit value
     */
    public char getSuit() {
        return suit;
    }

    /*
     getNumber() returns card number
     */
    public int getNumber() {
        return cardNumber;
    }

    /*
     setSuit() sets suit value
     */
    public void setSuit(char suit) {
        this.suit = suit;
    }

    /*
     setNumber() sets card number
     */
    public void setNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    /*
     Gets the value from the cardNumber in Poker
     Aces are higher than any other card.
     */
    public int getPokerValue() {
        if (cardNumber == 1) {
            return 14;
        } else {
            return cardNumber;
        }
    }
}
