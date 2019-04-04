package casino;

import java.util.Scanner;

public class main {

    public static Scanner user = new Scanner(System.in);
    public static int money = 1000;
    
    public static void main(String[] args) {
        chooseGame();
    }
    
    /*
        Choose a game to play.
    */
    public static void chooseGame(){
        int choice;

        System.out.println("Which game do you want to play?");
        System.out.println("1 for roulette. 2 for craps.");
        System.out.println("3 for poker. 4 for blackjack.");
        System.out.println("Press 5 to display money. Press 6 to leave.");
        choice = user.nextInt();

        switch (choice) {
            case 1:
                Roulette.setMoney(money);
                Roulette.play();
                money = Roulette.returnMoney();
                chooseGame();
                break;
            case 2:
                Craps.setMoney(money);
                Craps.play();
                money = Craps.returnMoney();
                chooseGame();
                break;
            case 3:
                Poker.setMoney(money);
                Poker.play();
                money = Poker.returnMoney();
                chooseGame();
                break;
            case 4:
                Blackjack.setMoney(money);
                Blackjack.play();
                money = Blackjack.returnMoney();
                chooseGame();
                break;
            case 5:
                System.out.println("You have " + money + " dollars.");
                chooseGame();
                break;
            case 6:
                System.out.println("Goodbye.");
                break;
            default:
                System.out.println("Not an option.");
                chooseGame();
                break;
        }
    }
   

}
