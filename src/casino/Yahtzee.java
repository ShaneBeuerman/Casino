package casino;

import java.util.Arrays;
import java.util.Random;

public class Yahtzee extends Game {
    static int[] dice = new int[5];
    static int rerollTotal = 3;
    public static void play(){
        int choice;
        rollDice();
        displayDice();
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
    
    /*
        Displays the value of each die.
    */
    public static void displayDice(){
        Arrays.sort(dice);
        for(int i = 0; i < dice.length; i++){
            System.out.println("Dice " + (i+1) + " is " + dice[i]);
        }
    }
    
    /*
        Adds the values of the dice together.
    */
    public static int sumDice(){
        int sum = 0;
        for(int i = 0; i < dice.length; i++){
            sum += dice[i];
        }
        return sum;
    }
    
    /*
        Rerolls whichever die you have selected.
    */
    public static void reroll(){
        if(rerollTotal < 1){
            System.out.println("I'm sorry, but you can't reroll.");
            return;
        }
        Random reRoll = new Random();
        System.out.println("Which die would you like to reroll?");
        int choice = user.nextInt();
        switch(choice){
            case 1:
                dice[0] = reRoll.nextInt(6) + 1;
                displayDice();
                System.out.println("Dice 1 is " + dice[0] + " now.");
                rerollTotal--;
                break;
            case 2:
                dice[1] = reRoll.nextInt(6) + 1;
                displayDice();
                System.out.println("Dice 2 is " + dice[1] + " now.");
                rerollTotal--;
                break;
            case 3:
                dice[2] = reRoll.nextInt(6) + 1;
                displayDice();
                System.out.println("Dice 3 is " + dice[2] + " now.");
                rerollTotal--;
                break;
            case 4:
                dice[3] = reRoll.nextInt(6) + 1;
                displayDice();
                System.out.println("Dice 4 is " + dice[3] + " now.");
                rerollTotal--;
                break;
            case 5:
                dice[4] = reRoll.nextInt(6) + 1;
                displayDice();
                System.out.println("Dice 5 is " + dice[4] + " now.");
                rerollTotal--;
                break;
            default:
                System.out.println("Not an option.");
                break;
        }
        System.out.println("Would you like to reroll again?");
        System.out.println("1 for yes, anything else for no.");
        choice = user.nextInt();
        switch(choice){
            case 1:
                System.out.println("Reroll again.");
                reroll();
                break;
            default:
                System.out.println("Alright, thank you.");
                break;
        }
    }
    
    /*
        Rolls each of the six dice.
    */
    public static void rollDice(){
        Random roll = new Random();
        for(int i = 0; i < dice.length; i++){
            dice[i] = roll.nextInt(6) + 1;
        }
        Arrays.sort(dice);
    }
    
    /*
        Evaluate the score of all of your dice.
    */
    public static void evaluateScore(){
        Arrays.sort(dice);
        int choice;
        int score = 0;
        System.out.println("Which roll are you going for?");
        System.out.println("1 for aces, 2 for twos.");
        System.out.println("3 for threes, 4 for fours.");
        System.out.println("5 for fives, 6 for sixes");
        System.out.println("7 for small straight, 8 for large straight");
        System.out.println("9 for three of a kind, 10 for four of a kind");
        System.out.println("11 for full House, 12 for chance");
        System.out.println("13 for Yahtzee");
        choice = user.nextInt();
        switch(choice){
            case 1:
                score = aces();
                break;
            case 2:
                score = twos();
                break;
            case 3:
                score = threes();
                break;
            case 4:
                score = fours();
                break;
            case 5:
                score = fives();
                break;
            case 6:
                score = sixes();
                break;
            case 7:
                score = smallStraight();
                break;
            case 8:
                score = largeStraight();
                break;
            case 9:
                score = threeOfAKind();
                break;
            case 10:
                score = fourOfAKind();
                break;
            case 11:
                score = fullHouse();
                break;
            case 12:
                score = chance();
                break;
            case 13:
                score = yahtzee();
                break;
            default:
                System.out.println("Not an option.");
                break;
        }
        System.out.println("Your score is " + score);
        rerollTotal = 3;
    }
    
    /*
        Determine your yahtzee score. If you have a yahtzee,
        you receive 50 points. Otherwise it is 0.
    */
    public static int yahtzee(){
        int score = 0;
        if(dice[0] == dice[4]){
            score = 50;
        }
        System.out.println("Yahtzee score is " + score);
        return score;
    }
    
    /*
        Determine if you have a smallStraight. If you have a
        small straight, then you receive 30 points.
    */
    public static int smallStraight(){
        int score = 0;
        if(dice[0] == 1 && dice[1] == 2 && dice[2] == 3 && dice[3] == 4 && dice[4] == 5){
            score = 30;
        }
        System.out.println("Small straight score is " + score);
        return score;
    }
    
    /*
        Determine if you have a largeStraight. If you have a 
        large straight, then you receive 40 points
    */
    public static int largeStraight(){
        int score = 0;
        if(dice[0] == 2 && dice[1] == 3 && dice[2] == 4 && dice[3] == 5 && dice[4] == 6){
            score = 40;
        }
        System.out.println("Large straight score is " + score);
        return score;
    }
    
    /*
        Checks if you have three dice with the same value. If
        you do have three of a kind, then your score returned
        is the sum of your dice.
    */
    public static int threeOfAKind(){
        int score = 0;
        if(dice[0] == dice[2] || dice[1] == dice[3] || dice[2] == dice[4]){
            for(int i = 0; i < dice.length; i++){
                score += dice[i];
            }
        }
             
        System.out.println("Three of a kind score is " + score);
        return score;
    }
    
    /*
        Checks if you have four dice with the same value. If you
        do have four of a kind, then your score returned is the
        sum of your dice.
    */
    public static int fourOfAKind(){
        int score = 0;
        if(dice[0] == dice[3] || dice[1] == dice[4]){
            for(int i = 0; i < dice.length; i++){
                score += dice[i];
            }
        }
        System.out.println("Four of a kind score is " + score);
        return score;
    }
    
    /*
        Similar to that of a poker hand. If you have three dice
        with the same value and a pair of dice with same value,
        then you get a score of 25 points.
    */
    public static int fullHouse(){
        int score = 0;
        if((dice[0] == dice[1] && dice[2] == dice[4]) ||
           (dice[0] == dice[2]) && dice[3] == dice[4]){
            score = 25;
        }
       
        System.out.println("Full House score is " + score);
        return score;
    }
    
    /*
        Returns the sum of the five dice.
    */
    public static int chance(){
        int score = 0;
        for(int i = 0; i < dice.length; i++){
            score += dice[i];
        }
        System.out.println("Chance score is " + score);
        return score;
    }
    
    /*
        Returns the sum of all the ones that you
        have rolled.
    */
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
    
    /*
        Returns the sum of all the twos that you
        have rolled.
    */
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
    
    /*
        Returns the sum of all the threes that you
        have rolled.
    */
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
    
    /*
        Returns the sum of all the fours that you
        have rolled.
    */
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
    
    /*
        Returns the sum of all the fives that you
        have rolled.
    */
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
    
    /*
        Returns the sum of all the sixes that you
        have rolled.
    */
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
