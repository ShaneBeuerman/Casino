package casino;

import java.util.Arrays;
import java.util.Random;

public class Yahtzee extends Game {
    static int[] dice = new int[5];
    public static void play(){
        int choice;
        rollDice();
        System.out.println("Would you like to reroll? 1 for yes. Anything else for no.");
        choice = user.nextInt();
        switch(choice){
            case 1:
                System.out.println("You have selected yes.");
                reroll();
                evaluateScore();
                break;
            default:
                System.out.println("You have selected no.");
                evaluateScore();
                break;
        }
    }
    
    public static void displayDice(){
        for(int i = 0; i < dice.length; i++){
            System.out.println("Dice " + i + " is " + dice[i]);
        }
    }
    
    public static void reroll(){
        Random reRoll = new Random();
        System.out.println("Which die would you like to reroll?");
        int choice = user.nextInt();
        switch(choice){
            case 1:
                dice[0] = reRoll.nextInt(6) + 1;
                System.out.println("Dice 1 is " + dice[0] + " now.");
                break;
            case 2:
                dice[1] = reRoll.nextInt(6) + 1;
                System.out.println("Dice 2 is " + dice[1] + " now.");
                break;
            case 3:
                dice[2] = reRoll.nextInt(6) + 1;
                System.out.println("Dice 3 is " + dice[2] + " now.");
                break;
            case 4:
                dice[3] = reRoll.nextInt(6) + 1;
                System.out.println("Dice 4 is " + dice[3] + " now.");
                System.out.println("");
                break;
            case 5:
                dice[4] = reRoll.nextInt(6) + 1;
                System.out.println("Dice 5 is " + dice[4] + " now.");
                System.out.println("");
                break;
            default:
                System.out.println("Not an option. No reroll for you.");
                break;
        }
    }
    
    public static void rollDice(){
        Random roll = new Random();
        for(int i = 0; i < dice.length; i++){
            dice[i] = roll.nextInt(6) + 1;
            System.out.println("Dice " + (i+1) + " has " + dice[i]);
        }
    }
    
    public static void evaluateScore(){
        Arrays.sort(dice);    
        int score = 0;
        score = chance();
        System.out.println("Your score is " + score);
    }
    
    public static int yahtzee(){
        int score = 0;
        
        System.out.println("Yahtzee score is " + score);
        return 0;
    }
    
    public static int smallStraight(){
        int score = 0;
        
        System.out.println("Small straight score is " + score);
        return 0;
    }
    
    public static int largeStraight(){
        int score = 0;
        
        System.out.println("Large straight score is " + score);
        return 0;
    }
    
    public static int threeOfAKind(){
        int score = 0;
        
        System.out.println("Three of a kind score is " + score);
        return 0;
    }
    
    public static int fourOfAKind(){
        int score = 0;
        
        System.out.println("Four of a kind score is " + score);
        return 0;
    }
    
    public static int fullHouse(){
        int score = 0;
       
        System.out.println("Full House score is " + score);
        return 0;
    }
    
    public static int chance(){
        int score = 0;
        for(int i = 0; i < dice.length; i++){
            score += dice[i];
        }
        System.out.println("Chance score is " + score);
        return score;
    }
    
    public static int aces(){
        int score = 0;
        for(int i = 0; i < dice.length; i++){
            if(dice[i] == 1){
                score += dice[i];
            }
        }
        System.out.println("Aces score is " + score);
        return score;
    }
    
    public static int twos(){
        int score = 0;
        for(int i = 0; i < dice.length; i++){
            if(dice[i] == 2){
                score += dice[i];
            }
        }
        System.out.println("Twos score is " + score);
        return score;
    }
    
    public static int threes(){
        int score = 0;
        for(int i = 0; i < dice.length; i++){
            if(dice[i] == 3){
                score += dice[i];
            }
        }
        System.out.println("Threes score is " + score);
        return score;
    }
    
    public static int fours(){
        int score = 0;
        for(int i = 0; i < dice.length; i++){
            if(dice[i] == 4){
                score += dice[i];
            }
        }
        System.out.println("Fours score is " + score);
        return score;
    }
    
    public static int fives(){
        int score = 0;
        for(int i = 0; i < dice.length; i++){
            if(dice[i] == 5){
                score += dice[i];
            }
        }
        System.out.println("Fives score is " + score);
        return score;
    }
    
    public static int sixes(){
        int score = 0;
        for(int i = 0; i < dice.length; i++){
            if(dice[i] == 6){
                score += dice[i];
            }
        }
        System.out.println("Sixes score is " + score);
        return score;
    }
}
