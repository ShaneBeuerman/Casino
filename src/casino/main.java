package casino;

import java.util.Scanner;

public class main {

    public static Scanner user = new Scanner(System.in);

    public static void main(String[] args) {
        chooseGame();
    }

    /*
     Choose a game to play.
     */
    private static void chooseGame() {
        int choice;
        System.out.println("Which game do you want to play?");
        System.out.println("1 for roulette. 2 for craps.");
        System.out.println("3 for poker. 4 for blackjack.");
        System.out.println("Press 5 to display money. Press 6 to leave.");
        System.out.println("Or press 7 to play Yahtzee(beta).");
        choice = user.nextInt();

        switch (choice) {
            case 1:
                Roulette.play();
                chooseGame();
                break;
            case 2:
                Craps.play();
                chooseGame();
                break;
            case 3:
                Poker.play();
                chooseGame();
                break;
            case 4:
                Blackjack.play();
                chooseGame();
                break;
            case 5:
                Roulette.displayMoney();
                chooseGame();
                break;
            case 6:
                System.out.println("Goodbye.");
                break;
            case 7:
                Yahtzee.play();
                chooseGame();
                break;
            default:
                System.out.println("Not an option.");
                chooseGame();
                break;
        }
    }
}
