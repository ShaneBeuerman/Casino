
package casino;

import java.util.Arrays;
import java.util.Random;

/*
    Cee-lo is a game played with three dice. A roll of 1-2-3 results in an
    automatic loss. 4-5-6 is an automatic win. If you roll a pair and a third
    distinct number, that number becomes a point. If you roll a three-of-a-kind,
    then it beats any point value in the game. Any roll that isn't 1-2-3, 4-5-6,
    a pair, or a three-of-a-kind doesn't have any value and must be rerolled
    until 1-2-3, 4-5-6, a pair, or a three-of-a-kind is rolled.
*/
public class Ceelo extends Game {
    static int[] dice = new int[3];
    static int dealerPoint;
    
    /*
        First, your current money is displayed, you make a bet, then the banker
        rolls. If the banker rolls a 1-2-3, you automatically win. If the banker
        rolls a 4-5-6, you automatically lose. After the banker rolls, the
        player rolls. If the player rolls a greater point, a greater
        three-of-a-kind, or a 4-5-6, they win. If they roll a lower point, lower
        three-of-a-kind, or a 1-2-3, the player loses.
    */
    public static void play(){
        displayMoney();
        bet();
        System.out.println("Banker rolls ");
        bankerRoll();
        System.out.println("Player rolls ");
        playerRoll();
        
    }
    
    public static void displayDice(){
        System.out.println(dice[0] + " " + dice[1] + " " + dice[2]);
    }
    
    /*
        The banker rolls first. In this case, the player makes their bet before
        either the player or banker rolls. The banker normally is the one that
        determines the bet beforehand, but it is the player this time. The
        banker has a slight advantage going first. A 1-2-3 roll is an automatic
        loss and 
    */
    public static void bankerRoll(){
        rollDice();
        while(true){
            if(dice[0] == 1 && dice[1] == 2 && dice[2] == 3){
                System.out.println("Banker loses.");
                System.out.println("You win.");
                bet = bet * 2;
                money = money + bet;
                break;
            }
            if(dice[0] == 4 && dice[1] == 5 && dice[2] == 6){
                System.out.println("Banker wins.");
                System.out.println("You lose");
                break;
            }
            if(dice[0] == dice[1] && dice[2] != dice[0]){
                dealerPoint = dice[2];
                break;
            }
            if(dice[0] != dice[1] && dice[1] == dice[2]){
                dealerPoint = dice[0];
                break;
            }
            if(dice[0] == dice[1] && dice[2] == dice[1]){
                dealerPoint = dice[0] + 6;
                break;
            }
            rollDice();
        }
        displayDice();
        
        
    }
    
    /*
        The player rolls second. This is a game of head-to-head Cee-lo. That
        means that only two players play and it is winner takes all between the
        player and the banker. A 1-2-3 roll is an automatic loss and a 4-5-6
        roll is an automatic win.
    */
    public static void playerRoll(){
        rollDice();
        while(true){
            if(dice[0] == 1 && dice[1] == 2 && dice[2] == 3){
                displayDice();
                System.out.println("You lose");
                break;
            }
            if(dice[0] == 4 && dice[1] == 5 && dice[2] == 6){
                displayDice();
                System.out.println("You win");
                bet = bet * 2;
                money = money + bet;
                break;
            }
            if(dice[0] == dice[1] && dice[2] != dice[0]){
                displayDice();
                if(dice[2] > dealerPoint){
                    System.out.println("You win.");
                    bet = bet * 2;
                    money = money + bet;
                    break;
                }else if(dice[2] == dealerPoint){
                    System.out.println("Tie.");
                    money = money + bet;
                    break;
                }else{
                    System.out.println("You lose.");
                    break;
                }
            }
            if(dice[0] != dice[1] && dice[1] == dice[2]){
                displayDice();
                 if(dice[0] > dealerPoint){
                    System.out.println("You win.");
                    bet = bet * 2;
                    money = money + bet;
                    break;
                }else if(dice[0] == dealerPoint){
                    System.out.println("Tie.");
                    money = money + bet;
                    break;
                }else{
                    System.out.println("You lose.");
                    break;
                }
            }
            if(dice[0] == dice[1] && dice[1] == dice[2]){
                displayDice();
                if(dice[0] + 6 > dealerPoint){
                    System.out.println("You win.");
                    bet = bet * 2;
                    money = money + bet;
                    break;
                }else if(dice[0] + 6 == dealerPoint){
                    System.out.println("Tie.");
                    money = money + bet;
                    break;
                }else{
                    System.out.println("You lose");
                }
            }
            rollDice();
        }
    }
    
    /*
        Three dice are rolled. Their value is determined by a random number
        generator that chooses a number between 1 and 6. 
    */
    public static void rollDice(){
        Random roll = new Random();
        for(int i = 0; i < dice.length; i++){
            dice[i] = roll.nextInt(6)+1;
        }
        Arrays.sort(dice);
    }
}
