package casino;

/*
 Blackjack extends from Cardgame which extends
 from Game
 */
public class Blackjack extends CardGame {

    /*
     Plays a game of Blackjack
     */
    public static void play() {
        if (deck.isEmpty()) {
            createDeck();
            System.out.println("Creating a deck.");
        }
        displayMoney();
        bet();

        //Deals cards to your hand and to the dealer.
        draw();
        dealerDraw();
        draw();
        dealerDraw();

        //Displays the cards in your hand.
        System.out.println();
        System.out.println("You have ");
        displayHand();
        System.out.println();
        System.out.println("Your total is " + getValue());

        //Displays the dealer's hand;
        System.out.println();
        if (dealer.get(0).cardNumber == 11) {
            System.out.println("Dealer has J " + dealer.get(0).suit);
        } else if (dealer.get(0).cardNumber == 12) {
            System.out.println("Dealer has Q " + dealer.get(0).suit);
        } else if (dealer.get(0).cardNumber == 13) {
            System.out.println("Dealer has K " + dealer.get(0).suit);
        } else if (dealer.get(0).cardNumber == 1) {
            System.out.println("Dealer has A " + dealer.get(0).suit);
        } else {
            System.out.println("Dealer has " + dealer.get(0).cardNumber + " " + dealer.get(0).suit);
        }
        System.out.println();

        // If you get a blackjack, you win.
        // Else, you must decide to hit or stay.
        if (getValue() == 21) {
            System.out.println("You win");
            bet = bet * 2;
            money = money + bet;
        } else {
            hitOrStay();
        }

        reshuffleCards();

    }

    /*
     Choose to either hit or stay. If you stay, it is the
     dealer's turn.
     */
    public static void hitOrStay() {
        int decide = 0;
        System.out.println("Hit or stay?");
        System.out.println("1 for hit. Anything else for stay.");
        decide = user.nextInt();
        if (decide == 1) {
            System.out.println("You have chosen to hit.");
            hit();
        } else {
            System.out.println("You have chosen to stay.");
            dealerTurn();
        }
    }

    /*
     getValue() returns the value of the cards in your hand.
     */
    public static int getValue() {
        int handValue = 0;
        int hasAce = 0;
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).cardNumber >= 10) {
                handValue = handValue + 10;
            } else if (hand.get(i).cardNumber == 1) {
                handValue = handValue + 11;
                hasAce++;
            } else {
                handValue = handValue + hand.get(i).cardNumber;
            }
        }
        if (hasAce >= 1 && handValue > 21) {
            handValue = handValue - 10;
        }
        if (hasAce >= 2 && handValue > 21) {
            handValue = handValue - 10;
        }
        if (hasAce >= 3 && handValue > 21) {
            handValue = handValue - 10;
        }
        if (hasAce >= 4 && handValue > 21) {
            handValue = handValue - 10;
        }
        return handValue;
    }

    /*
     dealerValue() returns the value of the cards in the dealer's hand.
     */
    public static int dealerValue() {
        int handValue = 0;
        int hasAce = 0;
        for (int i = 0; i < dealer.size(); i++) {
            if (dealer.get(i).cardNumber >= 10) {
                handValue = handValue + 10;
            } else if (dealer.get(i).cardNumber == 1) {
                handValue = handValue + 11;
                hasAce++;
            } else {
                handValue = handValue + dealer.get(i).cardNumber;
            }
        }
        if (hasAce >= 1 && handValue > 21) {
            handValue = handValue - 10;
        }
        if (hasAce >= 2 && handValue > 21) {
            handValue = handValue - 10;
        }
        if (hasAce >= 3 && handValue > 21) {
            handValue = handValue - 10;
        }
        if (hasAce >= 4 && handValue > 21) {
            handValue = handValue - 10;
        }
        return handValue;
    }

    /*
     hit() adds another card to your hand.
     */
    public static void hit() {
        draw();
        displayHand();
        if (getValue() > 21) {
            System.out.println("Your value is " + getValue());
            System.out.println("You bust.");
        } else if (getValue() == 21) {
            System.out.println("Your value is " + getValue());
            System.out.println("You win.");
            bet = bet * 2;
            money = money + bet;
        } else {
            System.out.println("Your value is " + getValue());
            hitOrStay();
        }
    }

    /*
     dealerTurn() iallows the dealer to decide what to do
     */
    public static void dealerTurn() {
        System.out.println("Dealer has");
        displayDealer();
        boolean stay = false;
        boolean done = false;
        if (dealerValue() > 16) {
            stay = true;
        }
        while (!done) {
            if (stay) {
                if (dealerValue() <= 21 && dealerValue() > getValue()) {
                    System.out.println("You lose.");
                    done = true;
                } else if (dealerValue() == getValue()) {
                    System.out.println("Push");
                    System.out.println("Your money is returned.");
                    money = money + bet;
                    done = true;
                } else {
                    System.out.println("You win.");
                    bet = bet * 2;
                    money = money + bet;
                    done = true;
                }
            } else if (!stay) {
                dealerDraw();
                System.out.println("Dealer has ");
                displayDealer();
                if (dealerValue() > 21) {
                    System.out.println("You win");
                    System.out.println("Dealer busts");
                    bet = bet * 2;
                    money = money + bet;
                    done = true;
                } else if (dealerValue() == 21) {
                    System.out.println("You lose");
                    System.out.println("Dealer has 21!");
                    done = true;
                } else if (dealerValue() > 16) {
                    stay = true;
                }
            }
        }
    }
}
