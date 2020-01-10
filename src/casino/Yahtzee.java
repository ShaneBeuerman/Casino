package casino;

import java.util.Arrays;
import java.util.Random;

public class Yahtzee extends Game {
    
    public static void play(){
        Random roll = new Random();
        int choice;
        int[] dice = new int[6];// die1, die2, die3, die4, die5;
        for(int i = 0; i < dice.length; i++){
            dice[i] = roll.nextInt(6) + 1;
            System.out.println("Dice " + i + " has " + dice[i]);
        }
        System.out.println("Would you like to reroll? 1 for yes. Anything else for no.");
        choice = user.nextInt();
        switch(choice){
            case 1:
                System.out.println("You have selected yes.");
                reroll(dice);
                break;
            default:
                System.out.println("You have selected no.");
                evaluateScore(dice);
                break;
        }
    }
    
    public static void reroll(int[] rolls){
        Random reRoll = new Random();
        System.out.println("Which die would you like to reroll?");
        int choice = user.nextInt();
        switch(choice){
            case 1:
                rolls[0] = reRoll.nextInt(6) + 1;
                System.out.println("Dice 1 is " + rolls[0] + " now.");
                break;
            case 2:
                rolls[1] = reRoll.nextInt(6) + 1;
                System.out.println("Dice 2 is " + rolls[1] + " now.");
                break;
            case 3:
                rolls[2] = reRoll.nextInt(6) + 1;
                System.out.println("Dice 3 is " + rolls[2] + " now.");
                break;
            case 4:
                rolls[3] = reRoll.nextInt(6) + 1;
                System.out.println("Dice 4 is " + rolls[3] + " now.");
                System.out.println("");
                break;
            case 5:
                rolls[4] = reRoll.nextInt(6) + 1;
                System.out.println("Dice 5 is " + rolls[4] + " now.");
                System.out.println("");
                break;
            default:
                System.out.println("Not an option. No reroll for you.");
                break;
        }
    }
    
    public static void evaluateScore(int[] rolls){
        Arrays.sort(rolls);    
        int score = 0;
        if(aces() > score){
            score = aces();
        }if(twos() > score){
            score = twos();
        }if(threes() > score){
            score = threes();
        }if(fours() > score){
            score = fours();
        }if(fives() > score){
            score = fives();
        }if(sixes() > score){
            score = sixes();
        }if(yahtzee() > score){
            score = yahtzee();
        }if(chance() > score){
            score = chance();
        }if(smallStraight() > score){
            score = smallStraight();
        }if(largeStraight() > score){
            score = largeStraight();
        }if(threeOfAKind() > score){
            score = threeOfAKind();
        }if(fourOfAKind() > score){
            score = fourOfAKind();
        }if(fullHouse() > score){
            score = fullHouse();
        }
        System.out.println("Your score is " + score);
    }
    
    public static int yahtzee(){
        return 0;
    }
    
    public static int smallStraight(){
        return 0;
    }
    
    public static int largeStraight(){
        return 0;
    }
    
    public static int threeOfAKind(){
        return 0;
    }
    
    public static int fourOfAKind(){
        return 0;
    }
    
    public static int fullHouse(){
        return 0;
    }
    
    public static int chance(){
        return 0;
    }
    
    public static int aces(){
        return 0;
    }
    
    public static int twos(){
        return 0;
    }
    
    public static int threes(){
        return 0;
    }
    
    public static int fours(){
        return 0;
    }
    
    public static int fives(){
        return 0;
    }
    
    public static int sixes(){
        return 0;
    }
}
