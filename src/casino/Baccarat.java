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
        System.out.println("What type of bet do you choose?");
        System.out.println("1 for Player, 2 for Dealer");
        System.out.println("3 for tie, 4 for player pairs");
        System.out.println("5 for dealer pairs");
        int choice = user.nextInt();
        switch(choice){
            case 1:
                Player();
                break;
            case 2:
                Dealer();
                break;
            case 3:
                Tie();
                break;
            case 4:
                pairs("Player");
                break;
            case 5:
                pairs("Dealer");
                break;
            default:
                System.out.println("Invalid choice. Get out of here.");
        }

        draw();
        dealerDraw();
        draw();
        dealerDraw();

        System.out.println();
        System.out.println("Player has ");
        displayHand();
        System.out.println();
        System.out.println("Player's total is " + getValue("Player"));

        System.out.println();
        System.out.println("Dealer has ");
        displayDealer();
        System.out.println();
        System.out.println("Dealer's total is " + getValue("Dealer"));

    }

    public static int getValue(String p) {
        int value = 0;

        switch (p) {
            case "Player":
                for (int i = 0; i < hand.size(); i++) {
                    if (hand.get(i).cardNumber < 10) {
                        value += hand.get(i).cardNumber;
                    }
                }   if (value > 10) {
                    value -= 10;
            }   break;
            case "Dealer":
                for (int i = 0; i < dealer.size(); i++) {
                    if (dealer.get(i).cardNumber < 10) {
                        value += dealer.get(i).cardNumber;
                    }
                }   if (value > 10) {
                    value -= 10;
            }   break;
        }

        return value;
    }

    public static void Player() {
        if(getValue("Player") > getValue("Dealer")){
            System.out.println("You win.");
            bet = bet * 2;
            money = money + bet;
        }else{
            System.out.println("You lose.");
        }
    }
    
    public static void Dealer(){
        if(getValue("Dealer") > getValue("Player")){
            System.out.println("You win.");
            bet = bet * 2;
            money = money + bet;
        }else{
            System.out.println("You lose.");
        }
    }
    
    public static void Tie(){
        if(getValue("Dealer") == getValue("Player")){
            System.out.println("You win.");
            bet = bet * 2;
            money = money + bet;
        }else{
            System.out.println("You lose.");
        }
    }
    
    public static void pairs(String p){
        if(p.equals("Player")){
            if(hand.get(0).cardNumber == hand.get(1).cardNumber){
                System.out.println("You win.");
                bet = bet * 12;
                money = money + bet;
            }else{
                System.out.println("You lose.");
            }
        }else if(p.equals("Dealer")){
            if(dealer.get(0).cardNumber == dealer.get(1).cardNumber){
                System.out.println("You win.");
                bet = bet * 12;
                money = money + bet;
            }else{
                System.out.println("You lose.");
            }
        }
    }
}
