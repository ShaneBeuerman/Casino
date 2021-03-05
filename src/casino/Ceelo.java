
package casino;

import java.util.Arrays;
import java.util.Random;


public class Ceelo extends Game {
    static int[] dice = new int[3];
    static int dealerPoint;
    
    public static void play(){
        displayMoney();
        bet();
        bankerRoll();
        playerRoll();
        
    }
    
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
        
        
        
    }
    
    public static void playerRoll(){
        while(true){
            if(dice[0] == 1 && dice[1] == 2 && dice[2] == 3){
                System.out.println("You lose");
                break;
            }
            if(dice[0] == 4 && dice[1] == 5 && dice[2] == 6){
                System.out.println("You win");
                bet = bet * 2;
                money = money + bet;
                break;
            }
            if(dice[0] == dice[1] && dice[2] != dice[0]){
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
    
    
    public static void rollDice(){
        Random roll = new Random();
        for(int i = 0; i < dice.length; i++){
            dice[i] = roll.nextInt(6)+1;
        }
        Arrays.sort(dice);
        System.out.println(dice[0] + " " + dice[1] + " " + dice[2]);
    }
}
