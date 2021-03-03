package casino;

/*
  Baccarat extends from CardGame which extends
  from Game
*/
public class Baccarat extends CardGame{
    
    /*
    Plays a game of Baccarrat
    */
    public static void play() {
        if(deck.isEmpty()) {
            createDeck();
            System.out.println("Creating a deck.");
        }
        displayMoney();
        bet();
        
        draw();
        dealerDraw();
        draw();
        dealerDraw();
        
        System.out.println();
        System.out.println("You have ");
        displayHand();
        System.out.println();
        System.out.println("Your total is " + getValue());
        
    }
    
    public static int getValue(){
        int value = 0;
        for(int i = 0; i < hand.size(); i++){
            if(hand.get(i).cardNumber < 10){
                value += hand.get(i).cardNumber;
            }
        }
        if(value > 10){
            value -= 10;
        }
        return value;
    }
}
