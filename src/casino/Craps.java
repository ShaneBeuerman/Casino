package casino;

import java.util.Random;

public class Craps extends Game {

    public static void play() {
        int choice;
        displayMoney();
        bet();
        System.out.println("What type of bet do you choose?");
        System.out.println("1 for passline, 2 for don't pass");
        System.out.println("3 for field bet, 4 for eleven roll");
        System.out.println("5 for three roll, 6 for snake eyes");
        System.out.println("7 for twelve roll, 8 for hi-lo bet");
        System.out.println("9 for craps roll, 10 for seven roll");
        choice = user.nextInt();
        switch (choice) {
            case 1:
                comeOn(1);
                break;
            case 2:
                comeOn(2);
                break;
            case 3:
                fieldBet();
                break;
            case 4:
                yo();
                break;
            case 5:
                aceDeuce();
                break;
            case 6:
                snakeEyes();
                break;
            case 7:
                boxcars();
                break;
            case 8:
                hiLo();
                break;
            case 9:
                craps();
                break;
            case 10:
                bigRed();
                break;
            default:
                System.out.println("Invalid choice. Get out of here.");
        }
    }

    /*
     roll() returns the result of two dice.
     */
    private static int roll() {
        Random play = new Random();
        int die1;
        int die2;
        int total;
        die1 = play.nextInt(6) + 1;
        die2 = play.nextInt(6) + 1;
        total = die1 + die2;
        System.out.println("You have rolled a " + total);
        return total;
    }

    /*
     The come on roll is the first roll of the game.
     Your bet has been made on either the passline
     and don't passline.
     */
    private static void comeOn(int choice) {
        if (choice == 1) {
            int total = roll();
            passLine(total);
        } else if (choice == 2) {
            int total = roll();
            dontPass(total);
        }
    }

    /*
     If you bet the passline bet, then you have to start
     with a passline roll. If the passline roll results
     in a 7 or 11, then you double your bet. If the roll
     results in 2, 3, or 12, you lose. If it results in 4,
     5, 6, 8, 9, or 10, then you must roll again.
     */
    private static void passLine(int total) {
        if (total == 7 || total == 11) {
            System.out.println("You've doubled your bet.");
            bet = bet * 2;
            money = money + bet;
        } else if (total == 2 || total == 12 || total == 3) {
            System.out.println("You've lost your bet");
        } else {
            secondRoll(total);
        }
    }

    /*
     If you bet the don't passline bet, then you have to
     start with a don't passline roll. If the roll results
     in a 2 or 3, then you win. If you roll a 7 or 11, then
     you win. If your bet results in a different number, then
     you must do a second roll.
    
     May need to have a push.
     */
    private static void dontPass(int total) {
        if (total == 2 || total == 3) {
            System.out.println("You win");
            bet = bet * 2;
            money = money + bet;
        } else if (total == 7 || total == 11) {
            System.out.println("You lose");
        } else {
            dontPassSecondRoll(total);
        }
    }

    /*
     When you bet on the passline bet and it goes to
     the second roll, then you must roll the same
     number that you rolled on the first roll again
     to win. If you roll a 7, then you lose. If you
     roll a different number, then you continue to 
     roll until you roll a 7 or the first number you
     rolled.
     */
    private static void secondRoll(int point) {
        int total = roll();
        if (total == point) {
            System.out.println("You win");
            bet = bet * 2;
            money = money + bet;
        } else if (total == 7) {
            System.out.println("You lose");
        } else {
            secondRoll(point);
        }
    }

    /*
     When you bet on the don't pass line and it goes
     to the second roll, then you must roll a 7 to win.
     If you roll the same number that you rolled on the
     first roll, then you lose. If you roll a different
     number, then you continue to roll until you roll
     a 7 or the first number you rolled.
     */
    private static void dontPassSecondRoll(int point) {
        int total = roll();
        if (total == point) {
            System.out.println("You lose");
        } else if (total == 7) {
            System.out.println("You win");
            bet = bet * 2;
            money = money + bet;
        } else {
            dontPassSecondRoll(point);
        }
    }

    /*
     A field bet is a bet for a 2, 3, 4,
     9, 10, 11, and 12.
     */
    private static void fieldBet() {
        int total = roll();
        if (total == 3 || total == 4 || total == 9 || total == 10 || total == 11) {
            System.out.println("You win");
            bet = bet * 2;
            money = bet + money;
        } else if (total == 2 || total == 12) {
            System.out.println("You win");
            bet = bet * 3;
            money = money + bet;
        } else {
            System.out.println("You lose");
        }
    }

    /*
     A snake eyes bet is a bet for a total of 2.
     */
    private static void snakeEyes() {
        int total = roll();
        if (total == 2) {
            System.out.println("You win");
            bet = bet * 31;
            money = money + bet;
        } else {
            System.out.println("You lose");
        }
    }

    /*
     An Ace-deuce bet is a bet for a total of 3. 
     */
    private static void aceDeuce() {
        int total = roll();
        if (total == 3) {
            System.out.println("You win");
            bet = bet * 16;
            money = money + bet;
        } else {
            System.out.println("You lose");
        }
    }

    /*
     A yo bet is for a total of 11.
     */
    private static void yo() {
        int total = roll();
        if (total == 11) {
            System.out.println("You win");
            bet = bet * 16;
            money = money + bet;
        } else {
            System.out.println("You lose");
        }
    }

    /*
     A boxcars bet is two 6s totaling 12.
     */
    private static void boxcars() {
        int total = roll();
        if (total == 12) {
            System.out.println("You win");
            bet = bet * 31;
            money = money + bet;
        } else {
            System.out.println("You lose");
        }
    }

    /*
     A hi-lo bet is either 2 or a 12.
     */
    private static void hiLo() {
        int total = roll();
        if (total == 2 || total == 12) {
            System.out.println("You win");
            bet = bet * 16;
            money = money + bet;
        } else {
            System.out.println("You lose");
        }
    }

    /*
     A craps bet is for a 2, 3, or a 12.
     */
    private static void craps() {
        int total = roll();
        if (total == 2 || total == 3 || total == 12) {
            System.out.println("You win");
            bet = bet * 8;
            money = money + bet;
        } else {
            System.out.println("You lose");
        }
    }

    /*
     A big red bet is for a 7 roll.
     */
    private static void bigRed() {
        int total = roll();
        if (total == 7) {
            System.out.println("You win");
            bet = bet * 5;
            money = bet + money;
        } else {
            System.out.println("You lose");
        }
    }
}
