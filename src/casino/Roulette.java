package casino;

import java.util.Random;

public class Roulette extends Game {
    
    public static void play(){
        int choice;
        int betNumber;
        displayMoney();
        bet();
        
        System.out.println("What is your bet?");
        System.out.println("1 for odd bet. 2 for even bet.");
        System.out.println("3 for red bet. 4 for black bet.");
        System.out.println("5 for first column bet. 6 for second column bet. 7 for thrid column bet.");
        System.out.println("8 for first dozen bet. 9 for second dozen bet. 10 for third dozen bet.");
        System.out.println("11 for bet from one to eighteen. 12 for bet from nineteen to thirty-six.");
        System.out.println("13 for a single bet");
        choice = user.nextInt();

        switch (choice) {
            case 1:
                oddBet();
                break;
            case 2:
                evenBet();
                break;
            case 3:
                redBet();
                break;
            case 4:
                blackBet();
                break;
            case 5:
                firstColumnBet();
                break;
            case 6:
                secondColumnBet();
                break;
            case 7:
                thirdColumnBet();
                break;
            case 8:
                firstDozen();
                break;
            case 9:
                secondDozen();
                break;
            case 10:
                thirdDozen();
                break;
            case 11:
                oneToEighteen();
                break;
            case 12:
                nineteenToThirtySix();
                break;
            case 13:
                System.out.println("What is your bet?");
                betNumber = user.nextInt();
                System.out.println("Thank you");
                singleBet(betNumber);
                break;
        }
        
    }
    
    /*
        spin() randomly chooses a value on the roulette wheel.
        It is ordered similar to an actual roulette wheel and
        simulates a roulette wheel by choosing its position
        randomly.
    */
    public static int spin(){
        int[] roulette = {0, 32, 15, 19, 4, 21, 2, 25, 17, 34,
            6, 27, 13, 36, 11, 30, 8, 23, 10, 5,
            24, 16, 33, 1, 20, 14, 31, 9, 22, 18,
            29, 7, 28, 12, 35, 3, 26};
        Random spin = new Random();
        int point = roulette[spin.nextInt(37)];
        System.out.println(point);
        return point;
    }
    
    /*
        redBet() bets on the red values of the roulette wheel.
    */
    public static void redBet(){
        int point = spin();
        boolean win = false;
        int[] red = {32, 19, 21, 25, 34, 27, 36, 30, 23, 5,
            16, 1, 14, 9, 18, 7, 12, 3};
        for (int i = 0; i < red.length; i++) {
            if (point == red[i]) {
                System.out.println("You win");
                win = true;
                bet = bet * 2;
                money = money + bet;
            }
        }
        if (!win) {
            System.out.println("You lose");
        }
    }
    
    /*
        blackBet() bets on the black values of the roulette wheel.
    */
    public static void blackBet(){
        int point = spin();
        boolean win = false;
        int[] black = {15, 4, 2, 17, 6, 13, 11, 8, 10, 24,
            33, 20, 31, 22, 29, 28, 35, 26};
        for (int i = 0; i < black.length; i++) {
            if (point == black[i]) {
                System.out.println("You win");
                win = true;
                bet = bet * 2;
                money = money + bet;
            }
        }
        if (!win) {
            System.out.println("You lose");
        }
    }
    
    /*
        evenBet() bets on the even values on the roulette wheel.
    */
    public static void evenBet(){
        int point = spin();
        if (point % 2 == 0) {
            System.out.println("You win");
            bet = bet * 2;
            money = money + bet;
        } else {
            System.out.println("You lose");
        }
    }
    
    /*
        oddBet() bets on the odd values on the roulette wheel.
    */
    public static void oddBet(){
        int point = spin();
        if (point % 2 == 1) {
            System.out.println("You win");
            bet = bet * 2;
            money = money + bet;
        } else {
            System.out.println("You lose");
        }
    }
    
    /*
        firstColumnBet() bets on the values on the first column
        of the roulette board.
    */
    public static void firstColumnBet(){
        int[] firstColumn = {1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34};
        int point = spin();
        boolean win = false;
        for (int i = 0; i < firstColumn.length; i++) {
            if (point == firstColumn[i]) {
                System.out.println("You win");
                win = true;
                bet = bet * 3;
                money = money + bet;
            }
        }
        if (!win) {
            System.out.println("You lose");
        }
    }
    
    /*
        secondColumnBet() bets on the values on the second column
        of the roulette board.
    */
    public static void secondColumnBet(){
        int[] secondColumn = {2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35};
        int point = spin();
        boolean win = false;
        for (int i = 0; i < secondColumn.length; i++) {
            if (point == secondColumn[i]) {
                System.out.println("You win");
                win = true;
                bet = bet * 3;
                money = money + bet;
            }
        }
        if (!win) {
            System.out.println("You lose");
        }
    }
    
    /*
        thirdColumnBet() bets on the values on the third column
        of the roulette board.    
    */
    public static void thirdColumnBet(){
        int[] thirdColumn = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36};
        int point = spin();
        boolean win = false;
        for (int i = 0; i < thirdColumn.length; i++) {
            if (point == thirdColumn[i]) {
                System.out.println("You win");
                win = true;
                bet = bet * 3;
                money = money + bet;
            }
        }
        if (!win) {
            System.out.println("You lose");
        }
    }
    
    /*
        oneToEighteen() bets on values 1-18 on the roulette wheel.
    */
    public static void oneToEighteen(){
        int point = spin();
        if (point <= 18 && point != 0) {
            System.out.println("You win");
            bet = bet * 2;
            money = money + bet;
        } else {
            System.out.println("You lose");
        }
    }
    
    /*
        nineteenToThirtySix() bets on values 19-36 on the roulette wheel.
    */
    public static void nineteenToThirtySix(){
        int point = spin();
        if (point > 18) {
            System.out.println("You win");
            bet = bet * 2;
            money = money + bet;
        } else {
            System.out.println("You lose");
        }
    }
    
    /*
        firstDozen() bets on values 1-12 on the roulette wheel.
    */
    public static void firstDozen(){
        int point = spin();
        if (point <= 12 && point != 0) {
            System.out.println("You win");
            bet = bet * 3;
            money = money + bet;
        } else {
            System.out.println("You lose");
        }
    }
    
    /*
        secondDozen() bets on values 13-24 on the roulette wheel.
    */
    public static void secondDozen(){
        int point = spin();
        if (point >= 13 && point <= 24) {
            System.out.println("You win");
            bet = bet * 3;
            money = money + bet;
        } else {
            System.out.println("You lose");
        }
    }
    
    /*
        thirdDozen() bets on values 25-36 on the roulette wheel.
    */
    public static void thirdDozen(){
        int point = spin();
        if (point >= 25) {
            System.out.println("You win");
            bet = bet * 3;
            money = money + bet;
        } else {
            System.out.println("You lose");
        }
    }
    
    /*
        snakeBet() is a unique bet that bets on a set of values 
        on the roulette board that make a snake shape.
    */
    public static void snakeBet(){
        int point = spin();
        boolean win = false;
        int[] snake = {1, 5, 9, 12, 14, 16, 19, 23, 27, 30, 32, 34};
        for (int i = 0; i < snake.length; i++) {
            if (point == snake[i]) {
                System.out.println("You win");
                win = true;
                bet = bet * 3;
                money = money + bet;
            }
        }
        if (!win) {
            System.out.println("You lose");
        }
    }
    
    /*
        insideBet() is used for all the inside bets
    */
    public static boolean insideBet(int[] bet){
        int point = spin();
        for (int i = 0; i < bet.length; i++) {
            if (bet[i] == point) {
                System.out.println("You win!");
                return true;
            }
        }
        System.out.println("You lose");
        return false;
    }
    
    /*
        singleBet() allows the user to bet on a single bet.
    */
    public static void singleBet(int number){
        int[] newBet = {number};
        if (insideBet(newBet)) {
            bet = bet * 36;
            money = bet + money;
        }
    }
    
}
