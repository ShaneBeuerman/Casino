/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import java.util.Scanner;

/**
 *
 * @author Shane
 */
public class Game {
    
    public static int money;
    public static int bet;
    public static Scanner user = new Scanner(System.in);
    
    /*
        Bet() asks the user how much they want to bet.
        You can't bet negative money and you can't bet
        more money than you have.
    */
    public static void bet(){
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
        Prompts the user if they want to stay at the game chosen.
        If the user chooses to leave, then their money is displayed.
    */
    public static void start(){
        boolean stay = true;
        int choice;
        while (stay) {
            play();
            System.out.println("Do you want to stay?");
            System.out.println("Press 1 to leave. Press anything else to stay.");
            choice = user.nextInt();
            if (choice == 1) {
                System.out.println("See you.");
                displayMoney();
                stay = false;
            }
        }
    }
    
    /*
        Sets the money you have for craps.
    */
    public static void setMoney(int value){
        money = value;
    }
    
    /*
        Returns the money value;
    */
    public static int returnMoney(){
        return money;
    }
    
    /*
        Adjust soon.
    */
    public static void play(){
        //Overwritten in the games.
    }
    
    /*
        Displays the money you have left.
    */
    public static void displayMoney() {
        System.out.println("You have " + money + " dollars.");
    }
    
}
