package casino;

import java.util.Scanner;

public class Game {

    public static int money;
    public static int bet;
    public static Scanner user = new Scanner(System.in);

    /*
     bet() asks the user how much they want to bet.
     You can't bet negative money and you can't bet
     more money than you have.
     */
    public static void bet() {
        System.out.println("How much money are you going to bet?");
        bet = user.nextInt();
        if (bet < 0) {
            System.out.print("You can't bet that.");
        } else if (bet > money) {
            System.out.println("You can't bet that much.");
            bet();
        } else {
            System.out.println("Thank you.");
            money = money - bet;
        }
    }

    /*
     setMoney() sets the money you have for craps.
     */
    public static void setMoney(int value) {
        money = value;
    }

    /*
     returnMoney() returns the money value;
     */
    public static int returnMoney() {
        return money;
    }

    /*
     diplayMoney() displays the money you have left.
     */
    public static void displayMoney() {
        System.out.println("You have " + money + " dollars.");
    }

}
